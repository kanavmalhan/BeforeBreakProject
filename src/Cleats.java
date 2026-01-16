//Cleats Item
public class Cleats extends Item {
    //Constructor for the cleats.
    public Cleats() {
        this.name = "Professional Soccer Cleats";
    }
//Defines what happens when the player uses the cleats
    public void use(Player player) {
        player.obtainCleats();
        player.addReadiness(50);
        System.out.println("You lace up the cleats. The ground feels different beneath your feet.");
    }
}
