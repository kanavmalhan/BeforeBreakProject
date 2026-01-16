public class EnergyBar extends Item {
    public EnergyBar() {
        this.name = "Energy Bar";
    }

    public void use(Player player) {
        player.addStamina(30);
        System.out.println("You tear open the wrapper and eat the bar. Warmth spreads through your muscles.");
    }
}
