package desafio_backend_picpay.desafio.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class PostgreSQLConnection {
    @Bean
    public DataSource connection(){
        DriverManagerDataSource postgres = new DriverManagerDataSource();

        postgres.setDriverClassName("org.postgresql.Driver");
        postgres.setUrl("jdbc:postgresql://localhost:5432/picpay");
        postgres.setUsername("postgres");
        postgres.setPassword("root");

        return postgres;
    }

}
