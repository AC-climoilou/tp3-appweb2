package A23.C6.TP3.ServiceREST.database;

import A23.C6.TP3.ServiceREST.LectureJSON.JsonManager;
import A23.C6.TP3.ServiceREST.route.RouteManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestUpdateDB {
    @GetMapping(value = "/getRoute")
    public ResponseEntity<JSONArray> getClients() {
        DatabaseManager databaseManager = new DatabaseManager(new JdbcTemplate());
        Route route = databaseManager.getRouteEntity().get(0);
        JSONArray jsRoute = new JSONArray();
        jsRoute.add(route);
        return new ResponseEntity<JSONArray>(jsRoute, HttpStatus.OK);
    }

    @PutMapping(value = "/putRoute")
    public ResponseEntity<String> remplacePersonne(@RequestBody Route newRoute) {
        DatabaseManager databaseManager = new DatabaseManager(new JdbcTemplate());
        databaseManager.replaceRouteEntity(newRoute);
        return new ResponseEntity<>("Route replaced", HttpStatus.CREATED);
    }
}
