package A23.C6.TP3.ServiceREST.route;

import A23.C6.TP3.ServiceREST.database.Route;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class RequeteREST
{
    /*
    * Exemple
    * {
    *   adresses [
    *               0 : "adresse1",
    *               1 : "adresse2"
    *             ],
    *   depard : "adresse depard"
    * }
    *
    * */
    @PostMapping(value = "postOptimizeRoute")
    public ResponseEntity<String> getRouteOptimizes(@RequestBody RequeteRoute requete)
    {


        System.out.println("Methode commence");


        String[] routeFinal = RouteManager.getOptimizedRouteAddresseArray(requete.adresses, requete.depard);

        String resultatFinal = "";
        resultatFinal += routeFinal[0];

        for(int i = 1; i < routeFinal.length - 1; i++)
        {
            resultatFinal += " & " + routeFinal[i];
        }

        System.out.println(resultatFinal);

        return new ResponseEntity<>(resultatFinal, HttpStatus.CREATED);
    }
}