package desafio_backend_picpay.desafio.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomErrorResponse {
    private int status;
    private String error;
    private String code;
}