public abstract class Item {
    private String name;
    private double cost;

    public Item(){
        this.name="Unknown";
        this.cost = 0;
    }

    public abstract void use();
    public abstract String toString();
    public String getName(){
        return this.name;
    }

    public double getCost(){
        return this.cost;
    }
}
