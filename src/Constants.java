//Here is where you can change certain constants throughout the game
//Keeps the game dynamic
public enum Constants {
    X_SIZE(10),
    Y_SIZE(10),
    VISIBILITY(5);

    private int v;

    Constants(int v) {
        this.v = v;
    }

    public int getValue() {
        return v;
    }
}
