package A23.C6.TP3.ServiceREST.LectureJSON;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import javax.json.JsonReader;
import java.io.*;
import java.util.Scanner;

public class JsonManager
{
    public JSONArray getClientsFromJson()
    {
        try
        {
            InputStream stream = ClassLoader.getSystemResourceAsStream("clients.json");
            Scanner scanner = new Scanner(stream,"UTF-8");
            String jsonString = "";

            while(scanner.hasNext())
            {
                jsonString += scanner.nextLine();
            };

            JSONObject object = (JSONObject) new JSONParser().parse(jsonString);
            JSONArray array = new JSONArray();
            array.add(object);

            return array;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Entrepot getEntrepot()
    {
        try {
            InputStream input = ClassLoader.getSystemResourceAsStream("entrepot.json");

            Scanner scanner = new Scanner(input);
            String stringJson = "";

            while (scanner.hasNext()) {
                stringJson += scanner.nextLine();
            }

            JSONObject json = (JSONObject) new JSONParser().parse(stringJson);

            Entrepot entrepot = new Entrepot();

            entrepot.setNom((String) json.get("nom"));
            entrepot.setAdresse((String) json.get("adresse"));

            return entrepot;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
