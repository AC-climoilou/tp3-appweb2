package modele;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Consomme le service REST
 */
public class ConsommationRest {

	private HttpURLConnection con;

	/**
	 * Consomme le GET getClients du Service REST
	 * @return response du service REST
	 */
	public List<String> getAllClientsDetails() {
		String response = GET("http://localhost:8080/getClients");
		return parseClientsDetails(response);
	}

	/**
	 *
	 * @param jsonResponse la reponse de getClients
	 * @return une liste de string des clients formattes
	 */
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

	/**
	 * Consommme le GET du service REST
	 * @param url l'url du GET
	 * @return le contenu du GET
	 */
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

	public boolean PUT() {
		try {
			URL url = new URL("http://localhost:8080/putRoute");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/json");

			// Prepare the data to be sent in the body of the request
			JSONObject obj = new JSONObject();
			Map<String, String> maMap = new HashMap<>();
			maMap.put("age", "70");
			maMap.put("nom", "Gerard");
			maMap.put("prenom", "Jean");

			obj.putAll(maMap);

			OutputStream os = conn.getOutputStream();
			os.write(obj.toString().getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			conn.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
