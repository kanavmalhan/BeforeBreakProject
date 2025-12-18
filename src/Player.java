import java.util.ArrayList;

public class Player extends Character{
    private int xLocation;
    private int yLocation;
    private int readiness;
    private ArrayList<Item> inventory;

    public Player(){
        super();
        this.xLocation = 0;
        this.yLocation = 0;
        this.inventory = new ArrayList<>();
        this.readiness = 100;
    };

    public Player(String name, int stamina, int xLocation, int yLocation, int readiness){
        super(name, stamina);
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.inventory= new ArrayList<>();
        this.readiness = readiness;
    }

    public int getXLocation(){
        return this.xLocation;
    }
    public int getYLocation(){
        return this.yLocation;
    }

    public int getReadiness(){
        return this.readiness;
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
