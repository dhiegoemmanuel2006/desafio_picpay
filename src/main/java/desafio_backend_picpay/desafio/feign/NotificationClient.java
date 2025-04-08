package desafio_backend_picpay.desafio.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "AuthorizationClient", url = "https://util.devi.tools/api")
public interface NotificationClient {

    @PostMapping(value = "/v1/notify")
    void sendNotification();
}