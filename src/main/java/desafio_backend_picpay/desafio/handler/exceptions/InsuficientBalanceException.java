package desafio_backend_picpay.desafio.handler.exceptions;

public class InsuficientBalanceException extends Exception{
    public InsuficientBalanceException() {
        super("Saldo insuficiente");
    }
}