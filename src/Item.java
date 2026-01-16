public abstract class Item {
    protected String name;
    public abstract void use(Player player);
    public String toString() { return name; }
}
