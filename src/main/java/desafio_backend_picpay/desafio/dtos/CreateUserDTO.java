package desafio_backend_picpay.desafio.dtos;

import desafio_backend_picpay.desafio.database.enuns.TypeUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
    private String name;
    private String cpfOrCnpj;
    private String email;
    private String password;
    private TypeUser type;
    private BigDecimal balance;
}
