public class Location {
    private int xLocation;
    private int yLocation;
    private String name;
    private NonPlayerCharacter npc;

    public Location(int xLocation, int yLocation, String name, NonPlayerCharacter npc){
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.name = name;
        this.npc = npc;
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
