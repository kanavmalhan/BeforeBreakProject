public class Key extends Item{
    public Key(){
        super();
    }
    @Override
    public void use(){
        
    }
    @Override
    public String toString(){
        return super.getName() + ", " + super.getCost();
    }


}
