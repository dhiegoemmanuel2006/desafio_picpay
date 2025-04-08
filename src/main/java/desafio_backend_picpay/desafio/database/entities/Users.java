package desafio_backend_picpay.desafio.database.entities;

import desafio_backend_picpay.desafio.database.enuns.TypeUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "name_user")
    private String name;

    @Column(name = "email_user", unique = true)
    private String email;

    @Column(name = "cpf_or_cnp_user", unique = true)
    private String CpfOrCnpj;

    @Column(name = "password_user")
    private String password;

    @Column(name = "type_user")
    private TypeUser type;

    @Column(name = "balance_user")
    private BigDecimal balance;

}
