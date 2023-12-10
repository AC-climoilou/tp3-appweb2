package A23.C6.TP3.ServiceREST.route;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RouteManager
{
    public static String GetOptimizesRoute()
    {
        try {
            String chaineUrl = "https://api.openrouteservice.org/geocode/search?api_key=5b3ce3597851110001cf6248434d4e24e8434f72b2d7c372f4754ba7&text=";
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

            float[] coordonees = new float[2];
            coordonees = (float[]) json.get("feature");
        } catch (
                IOException eIo) {
            System.out.println(eIo.getMessage());
        } catch (
                ParseException pe) {
            System.out.println(pe.getMessage());
        }

        return null;
    }



    public void getOptimizedRoute(float[][] tabCoordonnées)
    {
        JSONArray tabJSON = new JSONArray();

        for(int i = 0 ; i < tabCoordonnées.length; i++)
        {
            JSONObject objet = new JSONObject();
            objet.put("id", i);
            objet.put("location", tabCoordonnées[i]);
            tabJSON.add(objet);
        }

        try
        {
            URL url = new URL("https://api.openrouteservice/optimization");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
        }
        catch(MalformedURLException eURL)
        {
            System.out.println(eURL.getMessage());
        }
        catch(IOException eIo)
        {
            System.out.println(eIo.getMessage());
        }
    }
}


