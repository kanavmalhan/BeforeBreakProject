public class Character {
    private String name;
    private int stamina;

    public Character(){
        this.name="unknown";
        this.stamina=100;
    };

    public Character(String name, int stamina){
        this.name = name;
        this.stamina = stamina;
    }

    
    public String getName(){
        return this.name;
    }

    public int getStamina(){
        return this.stamina;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public void addStamina(int amount){
        this.stamina += amount;
    }

}
