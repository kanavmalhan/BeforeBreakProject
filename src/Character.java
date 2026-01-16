//Parent class for all 'HUMAN' entities in the game
public class Character {
//Instance variables
    protected String name;
    protected int stamina;
//Constructor
    public Character(String name, int stamina) {
        this.name = name;
        this.stamina = stamina;
    }
// Accesor functions
    public String getName() {
        return name;
    }

    public int getStamina() {
        return stamina;
    }
    public void addStamina(int amount) {
        stamina += amount;
        if (stamina < 0) stamina = 0;
    }
}
