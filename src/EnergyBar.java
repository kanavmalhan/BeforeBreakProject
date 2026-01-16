//This is the energybar class
public class EnergyBar extends Item {
    //Constructor
    public EnergyBar() {
        this.name = "Energy Bar";
    }
@Override
//This is how the player interacts with the energy bar
    public void use(Player player) {
        player.addStamina(30);
        System.out.println("You tear open the wrapper and eat the bar. Warmth spreads through your muscles.");
    }
}
