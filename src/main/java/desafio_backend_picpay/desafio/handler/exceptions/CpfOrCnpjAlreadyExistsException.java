package desafio_backend_picpay.desafio.handler.exceptions;

public class CpfOrCnpjAlreadyExistsException extends Exception {
    public CpfOrCnpjAlreadyExistsException(String CpfOrCnpj) {
        super(String.format("Você não pode usar o cpf/cnpj  %s", CpfOrCnpj));
    }

}