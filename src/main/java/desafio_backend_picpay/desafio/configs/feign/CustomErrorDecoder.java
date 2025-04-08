package desafio_backend_picpay.desafio.configs.feign;

import desafio_backend_picpay.desafio.handler.exceptions.BadRequestException;
import desafio_backend_picpay.desafio.handler.exceptions.InternalErrorException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        String requestUrl = response.request().url();
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());

        if(responseStatus.value() == 400){ //bad request
            return new BadRequestException(requestUrl);
        }
        if(responseStatus.value() == 500){ //erro interno servidor
            return new InternalErrorException(requestUrl);
        }
        else{
            return new Exception("Exception: " +  responseStatus);
        }
    }
}
