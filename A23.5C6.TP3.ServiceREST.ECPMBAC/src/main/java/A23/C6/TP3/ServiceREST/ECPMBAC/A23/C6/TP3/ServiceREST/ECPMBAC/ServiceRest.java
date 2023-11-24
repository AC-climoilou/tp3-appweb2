package A23.C6.TP3.ServiceREST.ECPMBAC.A23.C6.TP3.ServiceREST.ECPMBAC;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class ServiceRest {
    public ServiceRest() {

    }

    @GetMapping(value = "/personne/{id}")
    public Personne getPersonne(@PathVariable int id) {
        return gestionPersonnes.retournerPersonne(id);
    }

    @PostMapping(value = "/personne")
    public ResponseEntity<String> creerPersonne(@RequestBody Personne personne) {
        gestionPersonnes.ajouterPersonne(personne);
        return new ResponseEntity<>("Personne added", HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/personne/")
    public void deletePersonne(@RequestBody int id) {
        gestionPersonnes.detruirePersonne(id);
    }

    @PutMapping(value = "/personne/{id}")
    public ResponseEntity<String> remplacePersonne(@PathVariable int id, @RequestBody Personne personne) {
        gestionPersonnes.remplacerPersonne(id, personne);
        return new ResponseEntity<>("Personne replaced", HttpStatus.CREATED);
    }
}
