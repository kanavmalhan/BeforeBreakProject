public class Location {
    private final int xLocation;
    private final int yLocation;
    private final String name;
    private final NonPlayerCharacter npc;

    public Location(int xLocation, int yLocation, String name, NonPlayerCharacter npc){
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.name = name;
        this.npc = npc;
    }

    public int getXLocation(){
        return xLocation;
    }
    
    public int getYLocation(){
        return yLocation;
    }

    public String toString(){
        return this.name + " " + this.xLocation + " " + this.yLocation;
    }

    public boolean hasNPC(){
        return (this.npc != null);
    }

    public NonPlayerCharacter getNPC(){
        return this.npc;
    }

    public String getName(){
        return this.name;
    }
}
