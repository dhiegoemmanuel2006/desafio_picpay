package desafio_backend_picpay.desafio.database.repositories;

import desafio_backend_picpay.desafio.database.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByCpfOrCnpj(String cpfOrCnpj);

    Optional<Users> findByEmail(String email);
}
