package desafio_backend_picpay.desafio.dtos;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema
public class CreateTranferDTO {

    private BigDecimal value;
    private Long payer;
    private Long payee;

}