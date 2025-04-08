package desafio_backend_picpay.desafio.configs;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiDocConfig{
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().
                info(new io.swagger.v3.oas.models.info.Info()
                .title("Desafio-Picpay API").version("v1")
                .description("Documentação da API do Desafio Back-End-Junior Picpay"));
    }

}