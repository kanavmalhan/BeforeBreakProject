public abstract class NonPlayerCharacter extends Character {
    public NonPlayerCharacter(String name) {
        super(name, 100);
    }
    public abstract void interact(Player player);
}
