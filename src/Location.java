public class Location {
    private int xLocation;
    private int yLocation;
    private String name;
    private NonPlayerCharacter npc;

    public Location(int xLocation, int yLocation, String name){
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.name = name;
    }

    public String toString(){
        return this.name + " " + this.xLocation + " " + this.yLocation;
    }

    public String getName(){
        return this.name;
    }
}
