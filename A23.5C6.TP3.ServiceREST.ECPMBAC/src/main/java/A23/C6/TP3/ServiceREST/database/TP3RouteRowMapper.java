package A23.C6.TP3.ServiceREST.database;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * permet de mapper les rows de la database avec la class de representation Route
 * qui trenscrit la table MySQL en java
 * permet que jdnc puisse reconetre nos columns MySQL dans nottre table
 */
public class TP3RouteRowMapper implements RowMapper<Route> {

    /**
     * Map chaque rows de la table avec nottre classe representative
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
        Route route = new Route();
        route.setId(rs.getLong("id"));
        route.setRoute(rs.getString("route"));

        return route;
    }
}

