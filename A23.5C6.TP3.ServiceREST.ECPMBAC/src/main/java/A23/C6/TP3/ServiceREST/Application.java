package A23.C6.TP3.ServiceREST;

import A23.C6.TP3.ServiceREST.LectureJSON.*;
import org.json.simple.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		JsonManager test = new JsonManager();
		JSONArray json = test.getClientsFromJson();
		Entrepot entrepot = test.getEntrepot();
		int test2 = 0;
	}

	private String nom;

	private String adresse;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
