package desafio_backend_picpay.desafio.services;

import desafio_backend_picpay.desafio.database.entities.Users;
import desafio_backend_picpay.desafio.database.repositories.UserRepository;
import desafio_backend_picpay.desafio.dtos.CreateUserDTO;
import desafio_backend_picpay.desafio.handler.exceptions.CpfOrCnpjAlreadyExistsException;
import desafio_backend_picpay.desafio.handler.exceptions.EmailAlreadyExistsException;
import desafio_backend_picpay.desafio.handler.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository uRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void createUser(CreateUserDTO request) throws EmailAlreadyExistsException, CpfOrCnpjAlreadyExistsException {
        validateEmailAndCPF(request);
        userRepository.save(Users.builder().name(request.getName())
                .type(request.getType())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .cpf(request.getCpf())
                .balance(request.getBalance()).build());
    }


    public Users findById(Long id) throws NotFoundException {
        return uRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(String.format("Usuário nao encontrado: %s", id)));
    }
    public void save(Users user){
        uRepository.save(user);
    }
    public void validateEmailAndCPF(CreateUserDTO request) throws CpfOrCnpjAlreadyExistsException, EmailAlreadyExistsException {
        Users user = uRepository.findByCpf(request.getCpf()).orElse(null);
        if(user != null)throw new CpfOrCnpjAlreadyExistsException(request.getCpf());

        user = uRepository.findByEmail(request.getEmail()).orElse(null);
        if(user != null) throw new EmailAlreadyExistsException(request.getEmail());
    }
}
