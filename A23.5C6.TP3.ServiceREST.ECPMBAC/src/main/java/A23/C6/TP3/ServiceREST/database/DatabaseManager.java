package A23.C6.TP3.ServiceREST.database;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Manage les querries a send du server MySQL 110.0.0.6:3306
 */
@Repository
public class DatabaseManager {
    private final JdbcTemplate jdbcTemplate;

    public DatabaseManager(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * querry selectionne le(s) route(s), devrais toujours uniquement avoir une seul route dans la table route
     * @return
     */
    public List<Route> getRouteEntity() {
        String sql = "SELECT * FROM route";
        return jdbcTemplate.query(sql, new TP3RouteRowMapper());
    }

    /**
     * permet de remplacer la route dans la table route
     * @param route
     */
    public void replaceRouteEntity(String route) {
        String sql = "UPDATE route SET route = ? WHERE id = 1";
        jdbcTemplate.update(sql, route);
    }
}
