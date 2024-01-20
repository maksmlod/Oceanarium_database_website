package oceanarium_project.SpringApplication;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSON {

    /**
     * Get data from JSON file
     * @param name : name of object of table (e.g. pracownik) (the json file should have that name as the title of object)
     * @param words : list of parameters of table you want to get (e.g. for pracownicy = imie, nazwisko, ...)
     * @param path : path of the json file
     */
    @SuppressWarnings("unchecked")
    public static List<String> getJSON(String name, List<String> words, String path)
    {
        JSONParser jsonParser = new JSONParser();
        List<String> data = new ArrayList<>();
        try (FileReader reader = new FileReader(path))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray objectList = (JSONArray) obj;

            for (int i = 0; i < objectList.size(); i++) {
                Object emp = objectList.get(i);
                List<String> list = parseObject((JSONObject) emp, words, name);
                data.addAll(list);
            }
            return data;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<String> parseObject(JSONObject employee, List<String> words, String name)
    {
        List<String> list = new ArrayList<>();
        JSONObject object = (JSONObject) employee.get(name);
        for(int i = 0; i < words.size(); i++) {
            String word = (String) object.get(words.get(i));
            list.add(word);
        }
        return list;
    }
}
