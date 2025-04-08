package desafio_backend_picpay.desafio.handler.exceptions;

public class BadRequestException extends Exception{
    public BadRequestException(String url) {
        super(String.format("Bad request ao chamar a seguinte url %s", url));
    }
}