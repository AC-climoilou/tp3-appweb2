package A23.C6.TP3.ServiceREST;

import A23.C6.TP3.ServiceREST.LectureJSON.*;
import A23.C6.TP3.ServiceREST.database.DatabaseManager;
import A23.C6.TP3.ServiceREST.route.RequeteRESTRoute;
import org.json.simple.JSONArray;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application {

	private boolean conditionTestGetRoute = true;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		JsonManager test = new JsonManager();
		JSONArray json = test.getClientsFromJson();
		Entrepot entrepot = test.getEntrepot();
		int test2 = 0;

		float[] test3 = RequeteRESTRoute.getAdresse("180 9em rue quebec");
	}

	/**
	 * permet d'effectuer un querry sur le server MySQL 110.0.0.6:3306
	 * @param jdbcTemplate
	 * @param databaseManager
	 * @return
	 */
	@Bean
	public CommandLineRunner getRoute(JdbcTemplate jdbcTemplate, DatabaseManager databaseManager) {
		return args -> {
			DatabaseManager newDatabaseManager = new DatabaseManager(jdbcTemplate);

			if (conditionTestGetRoute) {
				//get current route
				//newDatabaseManager.getRouteEntity().forEach(System.out::println);

				//update current toute
				//newDatabaseManager.replaceRouteEntity(new Route("BBBBBBBBBBB"));
			}
		};
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
