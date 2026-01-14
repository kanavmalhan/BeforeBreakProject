public class CleatsMerchant extends NonPlayerCharacter{
    public CleatsMerchant(String name, String role){
        super(name, role);
    };
    @Override
    public void talk(Player player){

    };

    @Override
    public boolean evaluate(Player player){
        return true;
    };

}
