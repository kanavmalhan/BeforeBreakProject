
public enum Constants {
    X_SIZE(10),
    Y_SIZE(10),
    VISIBILITY(5);

    private final int value;

    private Constants(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

}
