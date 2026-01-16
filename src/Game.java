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
        player = new Player("Player");

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

        System.out.println("MATCHDAY: THE FINAL TRIAL");
        System.out.println("Commands: move north/south/east/west, look, talk, map, stats, inventory, exit");
    }

    public void update() {
        System.out.print("\n> ");
        String cmd = input.nextLine();

        switch (cmd) {
            case "move north": player.move(0, 1); break;
            case "move south": player.move(0, -1); break;
            case "move east": player.move(1, 0); break;
            case "move west": player.move(-1, 0); break;

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
