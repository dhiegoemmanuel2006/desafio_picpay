package desafio_backend_picpay.desafio.database.repositories;

import desafio_backend_picpay.desafio.database.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
