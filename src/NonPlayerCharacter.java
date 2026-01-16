//Abstract wrapper class for all the NPCs throughout the game
//Still an instance of the Character class
public abstract class NonPlayerCharacter extends Character {
    public NonPlayerCharacter(String name) {
        super(name, 100);
    }
    public abstract void interact(Player player);
}
