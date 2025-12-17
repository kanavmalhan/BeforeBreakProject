import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private int xLocation;
    private int yLocation;
    private ArrayList<Item> inventory;

    public Player(){
        this.name = "unknown";
        this.money = 0;
        this.xLocation = 0;
        this.yLocation = 0;
        this.inventory = new ArrayList<Item>();
    };

    public Player(String name, int money, int xLocation, int yLocation){
        this.name = name;
        this.money = money;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.inventory= new ArrayList<Item>();
    }
    
    public String getName(){
        return this.name;
    }

    public int getMoney(){
        return this.money;
    }

    public int getXLocation(){
        return this.xLocation;
    }
    public int getYLocation(){
        return this.yLocation;
    }
    
    public void move(int xMove, int yMove){
        this.xLocation += xMove;
        this.yLocation += yMove;
    }

    public Item getItemFromInventory(int inventorySlot){
        return this.inventory.get(inventorySlot);
    }

    public ArrayList<Item> getInventory(){
        return this.inventory;
    }

    public String printInventory(){
        String output = "";
        for(int i = 0; i< inventory.size(); i++){
            Item item = inventory.get(i);
            output = output + ", " + item.toString();
        }
        return output;
    }
    public void addItem(Item newItem){
        this.inventory.add(newItem);
    }

    public void removeItem(int index){
        this.inventory.remove(index);
    }


}
