package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

import model.BroadwayShow;
import model.BroadwayShowList;
import org.json.JSONArray;
import org.json.JSONObject;

// Represents a reader that reads show list from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructor
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads shows from file and returns it;
    // throws IOException if an error occurs reading data from file
    public BroadwayShowList read() throws IOException {
        String jsonData = this.readFile(this.source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return this.parseBroadwayShowList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }


    // EFFECTS: parses shows from JSON object and returns it
    private BroadwayShowList parseBroadwayShowList(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        BroadwayShowList bsl = new BroadwayShowList(name);
        addBroadwayShows(bsl, jsonObject);
        return bsl;
    }

    // MODIFIES: bsl
    // EFFECTS: parses broadway show from JSON object and adds them to list of broadway shows
    private void addBroadwayShows(BroadwayShowList bsl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Shows");
        for (Object json : jsonArray) {
            JSONObject nextShow = (JSONObject) json;
            addBroadwayShow(bsl, nextShow);

       /* Iterator var4 = jsonArray.iterator();

        while (var4.hasNext()) {
            Object json = var4.next();
            JSONObject nextShow = (JSONObject) json;
            this.addBroadwayShow(bsl, nextShow);
        }*/

        }
    }

    // MODIFIES: bsl
    // EFFECTS: parses show from JSON object and adds it to list
    private void addBroadwayShow(BroadwayShowList bsl, JSONObject jsonObject) {
       // String name = jsonObject.getString("name");
        int id = jsonObject.getInt("ID");
        String title = jsonObject.getString("Title");
        String description = jsonObject.getString("Description");
        int rating = jsonObject.getInt("Rating");
        BroadwayShow show = new BroadwayShow(id, title, description, rating);
        bsl.addShow(show);
    }
}