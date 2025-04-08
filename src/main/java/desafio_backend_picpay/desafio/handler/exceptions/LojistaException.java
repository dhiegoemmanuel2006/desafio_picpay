package desafio_backend_picpay.desafio.handler.exceptions;

public class LojistaException extends Exception{
    public LojistaException(Long userId) {
        super(String.format("O usuario %s é lojista e nao pode realizar transacoes", userId));
    }
}