package A23.C6.TP3.ServiceREST.LectureJSON;

import org.json.simple.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RequeteRESTClient {

    @GetMapping(value = "getClients")
    public ResponseEntity<JSONArray> getClients()
    {
        JsonManager manager = new JsonManager();
        JSONArray clients = new JSONArray();
        clients.addAll(manager.getClientsFromJson());

        return new ResponseEntity<JSONArray>(clients, HttpStatus.OK);

    }
}
