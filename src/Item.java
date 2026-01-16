//Abstract class serving as a wrapper for all of the other specific items
public abstract class Item {
    protected String name;
    public abstract void use(Player player);
    public String toString() { return name; }
}
