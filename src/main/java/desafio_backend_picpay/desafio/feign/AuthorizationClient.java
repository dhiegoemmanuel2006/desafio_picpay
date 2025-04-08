package desafio_backend_picpay.desafio.feign;

import desafio_backend_picpay.desafio.configs.feign.FeignConfiguration;
import desafio_backend_picpay.desafio.dtos.feign.AuthorizationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "AuthorizationClient", url = "https://util.devi.tools/api", configuration = FeignConfiguration.class)
public interface AuthorizationClient {

    @GetMapping(value = "/v2/authorize")
    AuthorizationResponse getAuthorization();

}