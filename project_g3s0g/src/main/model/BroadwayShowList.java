package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;
import ui.BroadWaysApp;

import java.util.ArrayList;
import java.util.Iterator;

//Represents a list of currently playing Broadway Shows
public class BroadwayShowList implements Writable {
    private String name;
    private ArrayList<BroadwayShow> shows;

    public BroadwayShowList(String name) {
        this.name = name;
        this.shows = new ArrayList<BroadwayShow>();
    }

    public String getName() {
        return this.name;
    }

    // EFFECTS: returns place of show in the list
    public BroadwayShow getIndex(int index) {
        return this.shows.get(index);
    }

    // EFFECTS: returns shows in list
    public ArrayList<BroadwayShow> getShows() {
        return this.shows;
    }

    // EFFECTS: returns amount of shows in list
    public int getSize() {
        return this.shows.size();
    }

    // MODIFIES: this
    // EFFECTS: adds shows to the list of shows
    public void addShow(BroadwayShow show) {
        this.shows.add(show);
        String eventMsg = show.getTitle();
        eventMsg += " added in Broadway Show List";
        EventLog.getInstance()
                .logEvent(new Event(eventMsg));
    }

    // MODIFIES: this
    // EFFECTS: removes shows from the list of shows
    public void removeShow(int index) {
        this.shows.remove(index);
        String eventMsg = "Removed show in Broadway Show List";
        EventLog.getInstance()
                .logEvent(new Event(eventMsg));
    }

    // MODIFIES: this
    // EFFECTS: closes events
    public void closeAction() {
        for (Event e : EventLog.getInstance()) {
            System.out.println(e);
        }
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.name);
        json.put("Shows", this.showsToJson());
        return json;
    }

    // EFFECTS: returns shows in this list as a JSON array
    private JSONArray showsToJson() {
        JSONArray jsonArray = new JSONArray();
        Iterator var2 = this.shows.iterator();

        while (var2.hasNext()) {
            BroadwayShow bs = (BroadwayShow) var2.next();
            jsonArray.put(bs.toJson());
        }

        return jsonArray;
    }

}