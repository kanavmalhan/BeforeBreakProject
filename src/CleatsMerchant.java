public class CleatsMerchant extends NonPlayerCharacter{
    public CleatsMerchant(String name, String role){
        super(name, role);
    };
    @Override
    public void talk(Player player, boolean isFirstConversation){

    };

    @Override
    public boolean evaluate(Player player){
        return true;
    };

}
