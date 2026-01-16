public class Character {
    protected String name;
    protected int stamina;

    public Character(String name, int stamina) {
        this.name = name;
        this.stamina = stamina;
    }

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
