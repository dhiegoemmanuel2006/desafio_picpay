package desafio_backend_picpay.desafio.handler.exceptions;

public class NotAuthorizedTransactionException extends Exception{
    public NotAuthorizedTransactionException() {
        super("Transacao nao autorizada");
    }
}