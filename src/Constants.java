public enum Constants {
    X_SIZE(10),
    Y_SIZE(10);

    private int v;

    Constants(int v) {
        this.v = v;
    }

    public int getValue() {
        return v;
    }
}
