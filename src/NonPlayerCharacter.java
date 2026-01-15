public abstract class NonPlayerCharacter extends Character{
    private String role;

    public NonPlayerCharacter(String name, String role){
        super(name, 100);
        this.role=role;
    }


    public abstract void talk(Player player, boolean isFirstConversation);

    public abstract boolean evaluate(Player player);
    
}
