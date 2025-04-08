package desafio_backend_picpay.desafio.handler.exceptions;

public class InvalidTransactionException extends Exception{
    public InvalidTransactionException() {
        super("Sender e receiver não podem ser o mesmo");
    }
}