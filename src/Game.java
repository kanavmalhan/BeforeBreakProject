import java.util.Scanner;

public class Game { //Game class. This is the class which controls the majority of the game
//Instance variables created
    private Location[][] board;
    private Player player;
    private Scanner input;
//Constructor
    public Game(Scanner input) {
        this.input = input;
        board = new Location[Constants.X_SIZE.getValue()][Constants.Y_SIZE.getValue()];
    }
//Function which initializes the game such as the board and the player
    public void init() {
    //Iterates throughout the board and sets every location to an empty location
        for (int i = 0; i < Constants.X_SIZE.getValue(); i++)
            for (int j = 0; j < Constants.Y_SIZE.getValue(); j++)
                board[i][j] = new Location("Empty Block", null);
    // Sets location for Coach's Office
        board[4][4] = new Location("Coach's Office", new Coach());
    // Sets location for Cleats Store
        board[6][6] = new Location(
            "Cleats Store",
            new RiddleNPC(//Instantiates the shop owner with a riddle
                "Shop Owner",
                "I grip the ground but never move. I have studs but no legs. What am I?",
                "cleats",
                new Cleats()//This is the object that will be given to the player
            )
        );
    // Sets location for Grocery Store
        board[3][7] = new Location(
            "Grocery Store",
            new RiddleNPC(//Instantiates Cashier at grocery store
                "Cashier",
                "What has a heart that doesn't beat?",
                "artichoke",
                new EnergyBar()//This is the object that will be given to a player
            )
        );
//Sets Location for GYM
        board[7][3] = new Location(
            "Gym",
            new RiddleNPC(
                "Trainer", // Trainer NPC instantiated
                "The more you use it, the stronger it gets. What is it?",
                "muscle",
                new Item() { //Makes the item which is supposed to be given to the player.
                    public void use(Player p) {
                        p.addReadiness(50);
                        System.out.println("Sweat drips down your face as your body adapts.");
                    }
                }
            )
        );

        //Introductory messages
        System.out.println("Welcome to " + "MATCHDAY: THE FINAL TRIAL");
        System.out.println("What is your name?");
        String name = this.input.nextLine();
        //Takes in players name
        System.out.println("Do you want to load in a game from before or start a new game");
        System.out.println("Type 'load' or type 'new'");
        //Does a switch case on whether the player wants to load or not load
        String response = this.input.nextLine();
        switch(response){
            case "load":
                //Checks if the file exists 
                // If it exists it loads and if not it doesn't
                if(SaveManager.saveExists()){
                    player = SaveManager.load();
                    System.out.println("Hello, " + player.getName());
                }
                else{
                    System.out.println("Save file not found so nothing to load");
                }
                break;
            //If the player wants to play a new game it prints the emssages for the new game. 
            case "new":
                player = new Player(name);
                System.out.println("Hello, " + name);
        
                System.out.println("By tonight, the coach will decide who makes the team \nYou have one day to prepare");
                System.out.println("Train wisely. Manage your stamina");
                System.out.println("What you do today will decide your future");
                System.out.println("You have to achieve 100 readiness to be approved for your trial. \nYou also have to have 20 stamina so that you can perform well at the trial. \nGood luck");
                
                System.out.println("");
                System.out.println("Commands: move north/south/east/west, look, talk, map, stats, inventory, help, exit");
                System.out.println("Speak with Coach Miller first, he can guide you");
                System.out.println("Type 'look' to see where he is");
        }
    }
    //Update functions. Runs a game loop.

    public void update() {
        System.out.print("\n> ");
        String cmd = input.nextLine();
        //Parses command of the user
        switch (cmd) {
            case "move north": 
                player.move(0, 1); 
                isOnLocation();
                break;
            case "move south": player.move(0, -1); isOnLocation();break;
            case "move east": player.move(1, 0); isOnLocation(); break;
            case "move west": player.move(-1, 0); isOnLocation(); break;

            case "look":
                lookAround();
                break;

            case "map":
                printMap();
                break;

            case "talk":
                board[player.getX()][player.getY()].interact(player);
                break;

            case "stats":
                System.out.println("Stamina: " + player.getStamina());
                System.out.println("Readiness: " + player.getReadiness());
                break;

            case "inventory":
                System.out.println(player.inventoryString());
                break;

            case "exit":
                System.exit(0);
            case "help":
                System.out.println("Commands: move north/south/east/west, look, talk, map, stats, inventory, help, exit");
                break;
            case "save":
                SaveManager.save(this.player);
                break;
        }
    }
/* Iterates throughout entire board using for loop and only looks through named blocks (Not empty). 
Based on those it checks if it is still visible to the user (Visibility currently set to 5) and prints out directions to those locations */
    private void lookAround() {
        for (int i = 0; i < Constants.X_SIZE.getValue(); i++) {
            for (int j = 0; j < Constants.Y_SIZE.getValue(); j++) {
                if (!board[i][j].getName().equals("Empty Block")) {
                    int dx = i - player.getX();
                    int dy = j - player.getY();
                    if (Math.abs(dx) <= Constants.VISIBILITY.getValue() && Math.abs(dy) <= Constants.VISIBILITY.getValue()) {
                        System.out.println(board[i][j].getName() +
                                " is " + dx + " east/west and " + dy + " north/south.");
                    }
                }
            }
        }
    }

    //Checks if player is on a location and provides a dialogue which tells the player that it is on the location.

    private void isOnLocation(){
        if(!board[player.getX()][player.getY()].getName().equals("Empty Block")){
            String name1 = board[player.getX()][player.getY()].getName();
            switch(name1){
                case "Cleats Store":
                    System.out.println("You step into the cleats store. Rows of brand-new cleats line the walls, each pair looking faster and lighter than the last.\n" + //
                                                "A merchant looks up from behind the counter and says,\n" + //
                                                "\"Speed starts from the ground up. Not everyone who walks in here earns a pair.\"\n" + //
                                                "He gestures toward a locked display case.\n" + //
                                                "");
                    System.out.println("Type 'talk' to speak with the Cleats merchant");
                    break;
                case "Coach's Office":
                    System.out.println("You enter the coach's office. Trophies line the shelves and play diagrams cover the walls.\n" + //
                                                "The coach looks up from his clipboard and studies you carefully.\n" + //
                                                "\"This is where decisions are made,\" he says.\n" + //
                                                "\"Only players who are truly ready get a shot at tryouts.\"\n" +
                                                "Type 'talk' to speak with the coach"+
                                                "");
                    break;
                case "Grocery Store":
                    System.out.println("You enter the grocery store. The smell of energy drinks and protein bars fills the air.\n" + //
                                                "A fridge hums softly in the corner, stocked with recovery snacks and energy bars.\n" + //
                                                "A sign on the wall reads:\n" + //
                                                "\"Fuel your body, or your body will fail you.\"\n" + //
                                                "");
                    System.out.println("Type 'talk' to speak with the grocery store merchant");
                    break;
                case "Gym":
                    System.out.println("You walk into the gym. The sound of weights clanking and shoes squeaking echoes through the room.\n" + //
                                                "Athletes are training hard, pushing their limits.\n" + //
                                                "A trainer notices you and says,\n" + //
                                                "\"Training here isn't free. You'll need the stamina to keep up.\"");
                    System.out.println("Type 'talk' to speak to the trainer");
                    break;
            }
        }
    }

    //Prints the map of the city in the console
    //P = Player, L = Location

    private void printMap() {
        for (int y = 9; y >= 0; y--) {
            for (int x = 0; x < Constants.X_SIZE.getValue(); x++) {
                if (player.getX() == x && player.getY() == y) {
                    System.out.print("[P]");
                } else if (!board[x][y].getName().equals("Empty Block")) {
                    System.out.print("[L]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    public String toString(){
        return "Board: " + this.board + "Player: " + this.player;
    }
}
