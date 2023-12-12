package A23.C6.TP3.ServiceREST.database;

import A23.C6.TP3.ServiceREST.Application;
import A23.C6.TP3.ServiceREST.LectureJSON.JsonManager;
import A23.C6.TP3.ServiceREST.route.RouteManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

@RestController
public class RequestUpdateDB {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @GetMapping(value = "/getRoute")
//    public ResponseEntity<JSONArray> getRouteOptimal() {
//        Route route = jdbcTemplate.queryForObject("SELECT * FROM route WHERE id = 1", new TP3RouteRowMapper());
//        JSONArray jsRoute = new JSONArray();
//        jsRoute.add(route.getRoute());
//        return new ResponseEntity<>(jsRoute, HttpStatus.OK);
//    }

    @GetMapping(value = "/getRoute")
    public ResponseEntity<JSONArray> getRouteOptimal() {
        DatabaseManager databaseManager = new DatabaseManager(jdbcTemplate);
        Route route = databaseManager.getRouteEntity().get(0);
        JSONArray jsRoute = new JSONArray();
        jsRoute.add(route.getRoute());
        return new ResponseEntity<>(jsRoute, HttpStatus.OK);
    }

    @PutMapping(value = "/putRoute")
    public ResponseEntity<String> remplacerRoute(@RequestBody String newRoute) {
        DatabaseManager databaseManager = new DatabaseManager(jdbcTemplate);
        databaseManager.replaceRouteEntity(newRoute);
        return new ResponseEntity<>("Route replaced", HttpStatus.CREATED);
    }
}
