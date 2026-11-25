
package lab_week9;

public class Healer extends GameCharacter implements Supporter {
     private int healAmount;

    public Healer(String name, int level, int maxHealth, int healAmount) {
        super(name, level, maxHealth);
        this.healAmount = healAmount;
    }

    @Override
    public String getCharacterInfo() {
        return "Healer: " + getName()+ ", Level: " + getLevel() + ", Health: " + getHealth()+ ", Heal Amount: " + healAmount;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 5 + healAmount;
    }
    
    @Override
public int heal(GameCharacter target) {

    if (!isAlive()) {
        return 0;
    }

    int amount = healAmount + getLevel();

    return target.restoreHealth(amount);
}
}
