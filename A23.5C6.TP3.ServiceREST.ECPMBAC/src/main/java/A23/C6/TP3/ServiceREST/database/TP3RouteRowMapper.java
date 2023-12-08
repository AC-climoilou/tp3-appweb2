package A23.C6.TP3.ServiceREST.database;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TP3RouteRowMapper implements RowMapper<Route> {

    @Override
    public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
        Route TP3Route = new Route();
        TP3Route.setId(rs.getLong("id"));
        TP3Route.setRoute(rs.getString("route"));

        return TP3Route;
    }
}

