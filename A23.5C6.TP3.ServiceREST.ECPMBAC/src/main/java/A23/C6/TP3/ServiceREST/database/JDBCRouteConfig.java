package A23.C6.TP3.ServiceREST.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**'
 * une class de confguration qui fait le lien entre le database manager et
 * le jdbc MySQL qui est inclue dans le pom.xml et la connexion parametre
 * dans application.propreties
 */
@Configuration
public class JDBCRouteConfig {

    /**
     * instanciation avec Spring du DatabaseManager
     * @param jdbcTemplate
     * @return
     */
    @Bean
    public DatabaseManager JDBCRouteConfigMethode(JdbcTemplate jdbcTemplate) {
        return new DatabaseManager(jdbcTemplate);
    }
}
