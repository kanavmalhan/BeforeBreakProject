public class Coach extends NonPlayerCharacter {

    public Coach() {
        super("Coach Miller");
    }
    
    @Override

    public void interact(Player player) {
        System.out.println("\nCoach Miller looks up from his clipboard.");
        if (player.hasCleats() && player.getReadiness() >= 100 && player.getStamina() >= 20) {
            System.out.println("He nods once.");
            System.out.println("\"You've earned it. Step onto the field tonight.\"");
            System.out.println("\nYOU MADE THE TEAM.");
            System.exit(0);
        } else {
            System.out.println("\"You're not ready yet.\"");
            System.out.println("Cleats. 100 Readiness. 20 Stamina. Come back when you have all three.");
        }
    }
}
