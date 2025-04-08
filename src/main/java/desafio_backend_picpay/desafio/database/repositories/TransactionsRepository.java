package desafio_backend_picpay.desafio.database.repositories;

import desafio_backend_picpay.desafio.database.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
}
