package A23.C6.TP3.ServiceREST.ECPMBAC.A23.C6.TP3.ServiceREST.ECPMBAC;

import A23.C6.TP3.ServiceREST.ECPMBAC.A23.C6.TP3.ServiceREST.ECPMBAC.route.GestionRoute;
import A23.C6.TP3.ServiceREST.ECPMBAC.A23.C6.TP3.ServiceREST.ECPMBAC.route.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class ServiceRest {
    private GestionRoute gestionRoute;
    public ServiceRest() {
        this.gestionRoute = new GestionRoute();
    }

    @GetMapping(value = "/route")
    public Route getPersonne() {
        return gestionRoute.getRoute();
    }

    @PostMapping(value = "/personne")
    public ResponseEntity<String> creerPersonne(@RequestBody Route route) {
        gestionRoute.replaceRoute(route);
        return new ResponseEntity<>("Personne added", HttpStatus.CREATED);
    }
}
