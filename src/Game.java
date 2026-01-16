import java.util.Scanner;

public class Game {
    private Location[][] board;
    private Player player;
    private Scanner input;

    public Game(Scanner input) {
        this.input = input;
        board = new Location[10][10];
    }

    public void init() {

       
        
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                board[i][j] = new Location("Empty Block", null);
            
        board[4][4] = new Location("Coach's Office", new Coach());
        
        board[6][6] = new Location(
            "Cleats Store",
            new RiddleNPC(
                "Shop Owner",
                "I grip the ground but never move. I have studs but no legs. What am I?",
                "cleats",
                new Cleats()
            )
        );
        
        board[3][7] = new Location(
            "Grocery Store",
            new RiddleNPC(
                "Cashier",
                "What has a heart that doesn’t beat?",
                "artichoke",
                new EnergyBar()
            )
        );

        board[7][3] = new Location(
            "Gym",
            new RiddleNPC(
                "Trainer",
                "The more you use it, the stronger it gets. What is it?",
                "muscle",
                new Item() {
                    public void use(Player p) {
                        p.addReadiness(50);
                        System.out.println("Sweat drips down your face as your body adapts.");
                    }
                }
            )
        );
        System.out.println("Welcome to " + "MATCHDAY: THE FINAL TRIAL");
        System.out.println("What is your name?");
        String name = this.input.nextLine();
        System.out.println("Do you want to load in a game from before or start a new game");
        String response = this.input.nextLine();
        switch(response){
            case "load":
                player = SaveManager.load();
                System.out.println("Hello, " + player.getName());
                break;
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

    public void update() {
        System.out.print("\n> ");
        String cmd = input.nextLine();

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

    private void lookAround() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!board[i][j].getName().equals("Empty Block")) {
                    int dx = i - player.getX();
                    int dy = j - player.getY();
                    if (Math.abs(dx) <= 5 && Math.abs(dy) <= 5) {
                        System.out.println(board[i][j].getName() +
                                " is " + dx + " east/west and " + dy + " north/south.");
                    }
                }
            }
        }
    }

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

    private void printMap() {
        for (int y = 9; y >= 0; y--) {
            for (int x = 0; x < 10; x++) {
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
}
