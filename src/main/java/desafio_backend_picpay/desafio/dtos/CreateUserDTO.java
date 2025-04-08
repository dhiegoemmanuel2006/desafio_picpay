package desafio_backend_picpay.desafio.dtos;

import desafio_backend_picpay.desafio.database.enuns.TypeUser;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema
public class CreateUserDTO {
    private String name;
    private String cpf;
    private String email;
    private String password;
    private TypeUser type;
    private BigDecimal balance;

}
