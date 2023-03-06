package ui;

import model.BroadwayShow;
import model.BroadwayShowList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// Broadways Application
public class BroadWaysApp {
    private static final String JSON_STORE = "./data/BroadwayShows.json";
    private Scanner input;
    private BroadwayShowList bsl;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    public BroadWaysApp() throws FileNotFoundException {
        this.input = new Scanner(System.in);
        this.bsl = new BroadwayShowList("My Broadway Show List");
        this.jsonWriter = new JsonWriter("./data/BroadwayShows.json");
        this.jsonReader = new JsonReader("./data/BroadwayShows.json");
        this.runBroadWaysApp();

    }

    // MODIFIES: this
    // EFFECTS: processes user input
    public void runBroadWaysApp() {
        this.initShows();
        this.printBroadwayShows();
        boolean keepGoing = true;
        String command = null;
        this.input = new Scanner(System.in);

        while (keepGoing) {
            this.displayMenu();
            command = this.input.next();
            command = command.toLowerCase();
            if (command.equals("q")) {
                keepGoing = false;
            } else {
                this.processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add Broadway Show");
        System.out.println("\tp -> print Broadway Shows");
        System.out.println("\ts -> save Broadway Shows to file");
        System.out.println("\tl -> load Broadway Shows from file");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            this.addBroadwayShow();
        } else if (command.equals("p")) {
            this.printBroadwayShows();
        } else if (command.equals("s")) {
            this.saveBroadwayShowList();
        } else if (command.equals("l")) {
            this.loadBroadwayShowList();
        } else {
            System.out.println("Selection not valid...");
        }

    }

    // MODIFIES: this
    // EFFECTS: prompt user for broadway shows traits and adds to list of shows
    private void addBroadwayShow() {
        System.out.println("Please enter name of show: ");
        int id = this.bsl.getSize() + 1;
        String title = this.input.next();
        System.out.println("please enter a description: ");
        String desc = this.input.next();
        System.out.println("please enter a rating: ");
        int rating = this.input.nextInt();
        this.bsl.addShow(new BroadwayShow(id, title, desc, rating));
    }

    private BroadwayShow readShow() {
        if (this.bsl.getSize() <= 0) {
            return null;
        } else {
            System.out.println("Please select an ID for your show");
            int menuLabel = 1;

            for (Iterator var2 = this.bsl.getShows().iterator(); var2.hasNext(); ++menuLabel) {
                BroadwayShow bs = (BroadwayShow) var2.next();
                System.out.println(bs.getId() + " -> " + bs.getTitle());
            }

            int menuSelection = this.input.nextInt();
            return this.bsl.getIndex(menuLabel);
        }
    }

    private void initShows() {
        bsl.addShow(new BroadwayShow(1, "Hamilton",
                "|The story of America then, told by America now.|", 1));
        bsl.addShow(new BroadwayShow(2, "Chicago",
                "|Satire on corruption in the administration of criminal justice.|",
                1));
        bsl.addShow(new BroadwayShow(3, "Wicked",
                "|Highlighting the importance of healthy and mutual female support systems.|",
                1));
        bsl.addShow(new BroadwayShow(4, "Waitress the Musical",
                "|A baker and waitress in an abusive relationship with her husband.|",
                1));
    }

    // EFFECTS: prints all the shows in list (inc current ones) to the console
    private void printBroadwayShows() {
        String name = this.bsl.getName();
        List<BroadwayShow> lst = bsl.getShows();
        System.out.println("Currently playing Broadway Shows:");
        System.out.println("ID" + "\t" + "Title" + "\t\t\t\t" + "Description" + "\t\t\t\t" + "Rating");

        for (BroadwayShow t : lst) {
            System.out.println(t.getId() + "\t" + t.getTitle() + "\t\t\t\t" + t.getDescription()
                    + "\t\t\t\t" + t.getRating());
        }
    }

   /* private void broadwaysAlgorithm(int command) {
        if (command > 0 && command < 5) {
            System.out.println("Make a Rating (1 to 5)");
            int newRating = selectNum.nextInt();
            displayRating(command, newRating);
            System.out.println("Would you like to rate a different show?");
            System.out.println("9 -> Continue 0 -> quit");
            int input = selectNum.nextInt();
            if (input == 0) {
                System.exit(0);
            } else {
                runBroadWaysApp();
            }
        } else {
            System.out.println("Error: Please select a number 1-4");
        }
    }*/

    // EFFECTS: saves the user's list to file with current ones
    private void saveBroadwayShowList() {
        try {
            this.jsonWriter.open();
            this.jsonWriter.write(this.bsl);
            this.jsonWriter.close();
            System.out.println("Saved " + this.bsl.getName() + " to " + "./data/BroadwayShows.json");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: ./data/BroadwayShows.json");
        }

    }

    // MODIFIES: this
    // EFFECTS: loads list from file
    private void loadBroadwayShowList() {
        try {
            bsl = jsonReader.read();
            System.out.println(this.bsl.getSize());
            if (this.bsl.getSize() <= 0) {
                System.out.println("No shows in list! Please add a Broadway show.");
            } else {
                this.jsonReader = new JsonReader("./data/BroadwayShows.json");
                this.bsl = this.jsonReader.read();
                System.out.println("Loaded " + this.bsl.getName() + " from " + "./data/BroadwayShows.json");
            }
        } catch (IOException e) {
            System.out.println("Unable to read from file: ./data/BroadwayShows.json");
        }

    }
}

