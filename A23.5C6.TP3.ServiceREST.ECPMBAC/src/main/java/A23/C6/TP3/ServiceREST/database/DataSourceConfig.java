package A23.C6.TP3.ServiceREST.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * adaptateur pour les nouvelles instances de jdbc pour la connexion database
 */
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        // Configure your DataSource here, for example, using HikariCP
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://110.0.0.6:3306/TP3Route");
        config.setUsername("root");
        config.setPassword("");

        return new HikariDataSource(config);
    }

}

