public class Location {
//Instance Variables
    private String name;
    private NonPlayerCharacter npc;
//Constructor
    public Location(String name, NonPlayerCharacter npc) {
        this.name = name;
        this.npc = npc;
    }
//Accessor function
    public String getName() {
        return name;
    }
//How the player interacts with the location.
    public void interact(Player player) {
        if (npc != null) npc.interact(player);
        else System.out.println("Nothing of interest here.");
    }
}
