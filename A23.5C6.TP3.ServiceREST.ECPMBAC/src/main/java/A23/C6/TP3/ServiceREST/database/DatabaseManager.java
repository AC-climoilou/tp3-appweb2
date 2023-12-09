package A23.C6.TP3.ServiceREST.database;


import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class DatabaseManager {
    private final JdbcTemplate jdbcTemplate;

    public DatabaseManager(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Route> getRouteEntity() {
        String sql = "SELECT * FROM route";
        return jdbcTemplate.query(sql, new TP3RouteRowMapper());
    }

    public void replaceRouteEntity(Route route) {
        String sql = "UPDATE route SET route = " + route.getRoute() + " WHERE id = (SELECT MIN(id) FROM route)";
        jdbcTemplate.update(sql, route);
    }
}
