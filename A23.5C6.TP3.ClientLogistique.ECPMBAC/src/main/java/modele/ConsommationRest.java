package modele;

import org.json.simple.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsommationRest {

	private HttpURLConnection con;

	public String getALL() {
		return GET("http://10.1.4.120:8080/WarPersonne-prod/personnes");
	}

	public String getRouteOptimale(int id) {
		return GET("http://10.1.4.120:8080/WarPersonne-prod/personne/" + id);
	}

	private String GET(String url) {
		String content = null;

		try {
			URL myurl = new URL(url);

			con = (HttpURLConnection) myurl.openConnection();
			con.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			content = new String();

			while ((inputLine = in.readLine()) != null) {
				content += (inputLine);
			}

			in.close();

		} catch (FileNotFoundException e) {
			content = "Aucun resultat";
		} catch (IOException e) {
			content = "Aucun resultat";
		}

		finally {
			con.disconnect();
		}
		return content;

	}
}
