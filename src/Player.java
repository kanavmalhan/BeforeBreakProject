import java.util.ArrayList;
//Player class
public class Player extends Character {
//Instance variables
    private int x;
    private int y;
    private int readiness;
    private boolean hasCleats;
    private ArrayList<Item> inventory;
//Constructor when you want to make a new player (When you select the new game option in the beginning)
    public Player(String name) {
        super(name, 100);
        this.x = 5;
        this.y = 5;
        this.readiness = 0;
        this.hasCleats = false;
        this.inventory = new ArrayList<>();
    }
//Constructor when you want to load a game from the save file.
    public Player(String name, int stamina, int xLocation, int yLocation, int readiness, boolean hasCleats){
        super(name, stamina);
        this.x = xLocation;
        this.y = yLocation;
        this.readiness = readiness;
        this.hasCleats = hasCleats;
        this.inventory = new ArrayList<>();
    }
//Move function. Moves wherever you want
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
        addStamina(-5);
    }
//Accessor functions
    public int getX() { return x; }
    public int getY() { return y; }

    public int getReadiness() {
        return readiness;
    }
//Adds however much readiness you want
    public void addReadiness(int amount) {
        readiness += amount;
    }
//Checks whether the player has cleats or not
    public boolean hasCleats() {
        return hasCleats;
    }
//Adds items
    public void obtainCleats() {
        hasCleats = true;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }
//Here is what it shows when you type the 'inventory' command
    public String inventoryString() {
        if (inventory.isEmpty()) return "Your bag is empty.";
        String out = "You are carrying:\n";
        for (Item i : inventory) out += "- " + i + "\n";
        return out;
    }
}
