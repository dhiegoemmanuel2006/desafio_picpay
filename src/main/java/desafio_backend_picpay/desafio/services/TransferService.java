package desafio_backend_picpay.desafio.services;

import desafio_backend_picpay.desafio.database.entities.Transactions;
import desafio_backend_picpay.desafio.database.entities.Users;
import desafio_backend_picpay.desafio.database.enuns.TypeUser;
import desafio_backend_picpay.desafio.database.repositories.TransactionsRepository;
import desafio_backend_picpay.desafio.dtos.CreateTranferDTO;
import desafio_backend_picpay.desafio.dtos.feign.AuthorizationResponse;
import desafio_backend_picpay.desafio.handler.exceptions.InsuficientBalanceException;
import desafio_backend_picpay.desafio.handler.exceptions.InvalidTransactionException;
import desafio_backend_picpay.desafio.handler.exceptions.LojistaException;
import desafio_backend_picpay.desafio.handler.exceptions.NotAuthorizedTransactionException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final TransactionsRepository transactionsRepository;
    private final UserService usersService;
    private final FeignClientService feignClientService;

    @Transactional
    public void createTransfer(CreateTranferDTO request) throws Exception{
        Users sender = usersService.findById(request.getPayer());
        Users receiver = usersService.findById(request.getPayee());

        if(sender.getType().name().equals(TypeUser.LOJISTA.name()))
            throw new LojistaException(sender.getId());

        if(sender.getBalance().compareTo(request.getValue()) < 0)
            throw new InsuficientBalanceException();

        if(sender.getId().equals(receiver.getId()))
            throw new InvalidTransactionException();

        AuthorizationResponse response = feignClientService.getAuthorization();
        if(!response.getData().getAuthorization())
            throw new NotAuthorizedTransactionException();

        sender.setBalance(sender.getBalance().subtract(request.getValue()));
        receiver.setBalance(receiver.getBalance().add(request.getValue()));

        usersService.save(sender);
        usersService.save(receiver);

        transactionsRepository.save(Transactions.builder()
                .sender(sender)
                .receiver(receiver)
                .transactionValue(request.getValue())
                .build());

        feignClientService.sendNotification();
    }
}
