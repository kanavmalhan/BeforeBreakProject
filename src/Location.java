public class Location {
    private String name;
    private NonPlayerCharacter npc;

    public Location(String name, NonPlayerCharacter npc) {
        this.name = name;
        this.npc = npc;
    }

    public String getName() {
        return name;
    }

    public void interact(Player player) {
        if (npc != null) npc.interact(player);
        else System.out.println("Nothing of interest here.");
    }
}
