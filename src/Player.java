import java.util.ArrayList;

public class Player extends Character {
    private int x;
    private int y;
    private int readiness;
    private boolean hasCleats;
    private ArrayList<Item> inventory;

    public Player(String name) {
        super(name, 100);
        this.x = 5;
        this.y = 5;
        this.readiness = 0;
        this.hasCleats = false;
        this.inventory = new ArrayList<>();
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
        addStamina(-5);
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public int getReadiness() {
        return readiness;
    }

    public void addReadiness(int amount) {
        readiness += amount;
    }

    public boolean hasCleats() {
        return hasCleats;
    }

    public void obtainCleats() {
        hasCleats = true;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public String inventoryString() {
        if (inventory.isEmpty()) return "Your bag is empty.";
        String out = "You are carrying:\n";
        for (Item i : inventory) out += "- " + i + "\n";
        return out;
    }
}
