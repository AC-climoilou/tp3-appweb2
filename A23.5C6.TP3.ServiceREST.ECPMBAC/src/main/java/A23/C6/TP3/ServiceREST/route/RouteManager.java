package A23.C6.TP3.ServiceREST.route;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class RouteManager
{
    public static JSONObject getAdresse(String recherche)
    {
        try {
            String chaineUrl = "https://api.openrouteservice.org/geocode/search?api_key=5b3ce3597851110001cf6248434d4e24e8434f72b2d7c372f4754ba7&text=" + recherche;
            chaineUrl = chaineUrl.replaceAll(" ", "+");

            System.out.println(chaineUrl);
            URL url = new URL(chaineUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String content = new String();
            String inputLine = "";

            while ((inputLine = in.readLine()) != null) {
                content += (inputLine);
            }

            in.close();
            System.out.println(content);

            JSONObject json = (JSONObject) new JSONParser().parse(content);

            return json;
        } catch (
                IOException eIo) {
            System.out.println(eIo.getMessage());
        } catch (
                ParseException pe) {
            System.out.println(pe.getMessage());
        }

        return null;
    }



    public static String[] getOptimizedRoute(float[][] tabCoordonnees, float[] coordonneesDepard)
    {

        JSONObject request = new JSONObject();

        JSONArray arrayJobs = new JSONArray();
        for(int i = 0; i < tabCoordonnees.length; i++)
        {
            JSONObject jobObject = new JSONObject();
            jobObject.put("id", i);
            JSONArray arrayLocation = new JSONArray();
            arrayLocation.add(tabCoordonnees[i][0]);
            arrayLocation.add(tabCoordonnees[i][1]);
            jobObject.put("location", arrayLocation);
            arrayJobs.add(jobObject);
        }
        request.put("jobs", arrayJobs);

        JSONArray tabVehicule = new JSONArray();
        JSONObject  vehiculeObject = new JSONObject();
        vehiculeObject.put("id", 1);
        JSONArray arrayCoordonnesDepard = new JSONArray();
        arrayCoordonnesDepard.add(coordonneesDepard[0]);
        arrayCoordonnesDepard.add(coordonneesDepard[1]);

        vehiculeObject.put("start", arrayCoordonnesDepard);
        vehiculeObject.put("profile", "driving-car");

        tabVehicule.add(vehiculeObject);

        request.put("vehicles", tabVehicule);

        try
        {
            URL url = new URL("https://api.openrouteservice.org/optimization");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "5b3ce3597851110001cf6248434d4e24e8434f72b2d7c372f4754ba7");
            conn.setRequestProperty("Content-Type", "application/json");


            OutputStream os = conn.getOutputStream();

            String test = request.toJSONString();

            os.write(request.toJSONString().getBytes());
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String output = "";

            String temporaryString;
            while ((temporaryString = br.readLine()) != null)
            {
                output += temporaryString;
            }

            JSONObject response = (JSONObject) new JSONParser().parse(output);
            JSONArray routes = (JSONArray) response.get("routes");
            JSONObject routes2 = (JSONObject) routes.get(0);
            JSONArray steps = (JSONArray) routes2.get("steps");


            double[][] listeCoordonnees = new double[steps.size()][2];

            for(int i = 0; i < steps.size(); i++)
            {
                JSONObject step2 = (JSONObject) steps.get(i);
                JSONArray location = (JSONArray) step2.get("location");
                listeCoordonnees[i][0] = ((Number) location.get(0)).doubleValue();
                listeCoordonnees[i][1] = ((Number) location.get(1)).doubleValue();
            }

            String[] tabAdresse = new String[listeCoordonnees.length];

            for(int i = 0; i < listeCoordonnees.length;i++)
            {
                JSONObject adresseJson = getAdresseFromCoordinates(listeCoordonnees[i][0], listeCoordonnees[i][1]);
                tabAdresse[i] = getAdresseStringFromAdresse(adresseJson);
            }

            return tabAdresse;
        }
        catch(IOException eIo)
        {
            System.out.println(eIo.getMessage());
        }
        catch(ParseException ep)
        {
            System.out.println(ep.getMessage());
        }
        return null;
    }

    public static JSONObject getAdresseFromCoordinates(double longitude, double latitude)
    {
        String stringUrl = "https://api.openrouteservice.org/geocode/reverse?api_key=5b3ce3597851110001cf6248434d4e24e8434f72b2d7c372f4754ba7&point.lon=" +  longitude + "&point.lat=" + latitude + "&size=1";
    try {
            URL url = new URL(stringUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String content = new String();
            String inputLine = "";

            while ((inputLine = in.readLine()) != null) {
                content += (inputLine);
            }

            in.close();
            System.out.println(content);

            JSONObject json = (JSONObject) new JSONParser().parse(content);

            return json;
        }
        catch(IOException ioE)
        {
            System.out.println(ioE.getMessage());;
        }
        catch(ParseException pE)
        {
            System.out.println(pE.getMessage());
        }
        return null;
    }


    public static String getAdresseStringFromAdresse(JSONObject adresse)
    {
        JSONArray features = (JSONArray) adresse.get("features");
        JSONObject properties = (JSONObject) features.get(0);
        JSONObject properties2 = (JSONObject) properties.get("properties");
        String adresseString = (String) properties2.get("label");
        return adresseString;
    }

    public static String[] getOptimizedRouteAddresseArray(String[] tabAdresses, String emplacementDepard)
    {
        JSONArray tabJSON = new JSONArray();

        for(int i = 0; i < tabAdresses.length; i++)
        {
            tabJSON.add(getAdresse(tabAdresses[i]));
        }

        String[] tabAdressesString = new String[tabJSON.size()];

        float[][] tabCoordoneClients = new float[tabJSON.size()][2];
        for(int i = 0; i < tabAdressesString.length; i++)
        {
             tabCoordoneClients[i] = getCoordinateFromJson((JSONObject) tabJSON.get(i));
        }

        float[] coordoneDepard = getCoordinateFromJson(getAdresse(emplacementDepard));
        return getOptimizedRoute(tabCoordoneClients, coordoneDepard);
    }

    public static float[] getCoordinateFromJson(JSONObject adresseJSon)
    {
        JSONArray features = (JSONArray) adresseJSon.get("features");
        JSONObject features2 = (JSONObject) features.get(0);
        JSONObject geometry = (JSONObject) features2.get("geometry");
        JSONArray coordinates = (JSONArray) geometry.get("coordinates");

        float[] coordoneFloat = new float[2];

        coordoneFloat[0] = ((Number)coordinates.get(0)).floatValue();
        coordoneFloat[1] = ((Number)coordinates.get(1)).floatValue();

        return coordoneFloat;
    }
}