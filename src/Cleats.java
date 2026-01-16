public class Cleats extends Item {
    public Cleats() {
        this.name = "Professional Soccer Cleats";
    }

    public void use(Player player) {
        player.obtainCleats();
        player.addReadiness(50);
        System.out.println("You lace up the cleats. The ground feels different beneath your feet.");
    }
}
