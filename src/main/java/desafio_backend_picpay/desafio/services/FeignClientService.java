package desafio_backend_picpay.desafio.services;


import desafio_backend_picpay.desafio.dtos.feign.AuthorizationResponse;
import desafio_backend_picpay.desafio.feign.AuthorizationClient;
import desafio_backend_picpay.desafio.feign.NotificationClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeignClientService {

    private final AuthorizationClient authorizationClient;
    private final NotificationClient notificationClient;

    public AuthorizationResponse getAuthorization(){
        try{
            return authorizationClient.getAuthorization();
        }catch (Exception e){
            log.error("Erro ao chamar api de autorizacao: " + e.getMessage());
            throw e;
        }
    }

    @Async
    public void sendNotification(){
        try{
            notificationClient.sendNotification();
        }catch (Exception e){
            log.error("Erro ao chamar api de noptificacao: " + e.getMessage());
            throw e;
        }
    }
}