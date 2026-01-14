public abstract class NonPlayerCharacter extends Character{
    private boolean trustsPlayer;
    private String role;

    public NonPlayerCharacter(String name, String role){
        super(name, 100);
        this.trustsPlayer = true;
        this.role=role;
    }


    public abstract void talk(Player player);

    public abstract boolean evaluate(Player player);
    
}
