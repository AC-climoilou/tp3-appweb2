package A23.C6.TP3.ServiceREST.route;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class RequeteRESTRoute
{
    private static HttpURLConnection conn;

    private static URL url;

    private String content;

    public RequeteRESTRoute()
    {
        try {
            url = new URL("https://api.openrouteservice.org/geocode/search?api_key=5b3ce3597851110001cf6248434d4e24e8434f72b2d7c372f4754ba7&text=Namibian%20Brewery");
            conn = (HttpURLConnection) url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            content = new String();
            while ((inputLine = in.readLine()) != null) {
                content += (inputLine);
            }
            in.close();

        }
        catch(IOException eIo)
        {
            System.out.println(eIo.getMessage());
        }
    }

}
*/