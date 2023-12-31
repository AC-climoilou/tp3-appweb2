package A23.C6.TP3.ServiceREST;

import A23.C6.TP3.ServiceREST.database.DatabaseManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

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
