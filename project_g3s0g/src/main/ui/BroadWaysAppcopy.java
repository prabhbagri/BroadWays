
/*
public class BroadWaysApp {

    private BroadwayShow show = null;
    private BroadwayShowList showList = new BroadwayShowList();
    private Scanner selectNum = new Scanner(System.in);

    // EFFECTS: runs the BroadWays application
    public BroadWaysApp() {
        addShows();
        runBroadWaysApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input for main menu\
    //          and loops program when needed
    public void runBroadWaysApp() {
        System.out.println("Currently playing shows on Broadway: ");
        while (true) {
            displayTitles();
            int command = selectNum.nextInt();

            if (command == 0) {
                break;
            }
            broadwaysAlgorithm(command);
        }
        System.out.println("Thanks for using Broadways! :)");
    }

    // EFFECTS: runs the entire application
    private void broadwaysAlgorithm(int command) {
        if (command > 0 && command < 5) {
            displayDescription(command);
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
    }

    // EFFECTS: displays main menu of currently playing Broadway Shows
    private void addShows() {
        showList.set(new BroadwayShow("1 -> Hamilton",
                "|The story of America then, told by America now.|",
                1));
        showList.set(new BroadwayShow("2 -> Wicked",
                "|Highlighting the importance of healthy and mutual female support systems.|",
                1));
        showList.set(new BroadwayShow("3 -> Chicago",
                "|Satire on corruption in the administration of criminal justice.|",
                1));
        showList.set(new BroadwayShow("4 -> Waitress the Musical",
                "|A baker and waitress in an abusive relationship with her husband.|",
                1));
    }

    // EFFECTS: output a string that represents the title of Broadway Shows numbered 1-4
    private void displayTitles() {
        for (int i = 0; i < showList.getSize(); i++) {
            show = showList.get(i);
            System.out.println(show.getTitle());
        }
        System.out.println("0 -> quit application");
        System.out.println("Select Show number (1-4)");
    }

    // EFFECTS: output a string that gives the description of each Broadway Show
    private void displayDescription(int num) {
        int n = num - 1;
        show = showList.get(n);
        System.out.println(show.getDescription());
        displayStars(show.getRating());

    }

    // EFFECTS input a number 1-5 for one of the shows (1-4)
    private void displayRating(int index, int newRating) {
        int n = index - 1;
        showList.get(n).setRating(newRating);
        displayStars(showList.get(n).getRating());
    }

    // MODIFIES: this
    // EFFECTS: translate ratings to display stars as a visual character
    private void displayStars(int rating) {
        StringBuilder sb1 = new
                StringBuilder();
        for (int i = 0; i < rating; i++) {
            if (i >= 5) {
                break;
            }
            sb1.append("*"); //print stars instead of a number
        }
        System.out.println("Current Rating: " + sb1);
    }

}
*/
