package modele;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ConsommationRest {

	private HttpURLConnection con;

	public List<String> getAllClientsDetails() {
		String response = GET("http://localhost:8080/getClients");
		return parseClientsDetails(response);
	}

	private List<String> parseClientsDetails(String jsonResponse) {
		List<String> clientsDetails = new ArrayList<>();

		try {
			JSONParser parser = new JSONParser();
			JSONArray clientsArray = (JSONArray) parser.parse(jsonResponse);

			for (Object obj : clientsArray) {
				JSONObject clientObject = (JSONObject) obj;
				JSONArray clients = (JSONArray) clientObject.get("clients");

				for (Object client : clients) {
					JSONObject clientDetails = (JSONObject) client;
					String clientName = (String) clientDetails.get("nom");
					String clientAddress = (String) clientDetails.get("adresse");
					String clientDetailsString = clientName + " - " + clientAddress;
					clientsDetails.add(clientDetailsString);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return clientsDetails;
	}

	private String GET(String url) {
		String content = null;

		try {
			URL myurl = new URL(url);

			con = (HttpURLConnection) myurl.openConnection();
			con.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder contentBuilder = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				contentBuilder.append(inputLine);
			}

			in.close();
			content = contentBuilder.toString();

		} catch (FileNotFoundException e) {
			content = "Aucun resultat";
		} catch (IOException e) {
			content = "Aucun resultat";
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}
		return content;
	}
}
