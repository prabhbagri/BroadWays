package model;

import org.json.JSONObject;
import persistence.Writable;


// Represent a Broadway Show that has a title, small description, and a rating
public class BroadwayShow implements Writable {
    private int id; //place in list
    //  private static int initRating = 1; //All broadway shows are given an initial rating of 1 star
    private String title;  //Broadway Show name
    private String description; //Broadway Show description
    private int rating; //Rating given to Broadway Show

    public BroadwayShow(int id, String broadwayShowName, String broadwayShowDescription, int rating) {
        this.id = id;
        this.title = broadwayShowName;
        this.description = broadwayShowDescription;
        this.rating = rating;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public int getRating() {
        return this.rating;
    }

    // REQUIRES: rating >= 0 && [1,5]
    // MODIFIES: this
    // EFFECTS: replaces old rating with user's new rating
    public void setRating(int newRating) {
        this.rating = newRating;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return this.title + " : " + this.description;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("ID", this.id);
        json.put("Title", this.title);
        json.put("Description", this.description);
        json.put("Rating", this.rating);
        return json;
    }
}
