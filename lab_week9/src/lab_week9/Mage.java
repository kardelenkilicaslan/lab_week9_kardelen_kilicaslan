
package lab_week9;


public class Mage extends GameCharacter implements Attacker, Supporter{
    private int mana;

    public Mage(String name, int level, int maxHealth, int mana) {
        super(name, level, maxHealth);
        this.mana = mana;
    }

    @Override
    public String getCharacterInfo() {
        return "Mage: " + getName()+ ", Level: " + getLevel() + ", Health: " + getHealth() + ", Mana: " + mana;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 8 + mana;
    }
    
    @Override
public int attack(GameCharacter target) {

    if (!isAlive() || !target.isAlive()) {
        return 0;
    }

    if (mana < 20) {
        System.out.println("Not enough mana!");
        return 0;
    }

    int damage = calculatePower() / 3;

    mana -= 20;

    return target.takeDamage(damage);
}

@Override
public int heal(GameCharacter target) {

    if (!isAlive()) {
        return 0;
    }

    if (mana < 15) {
        System.out.println("Not enough mana!");
        return 0;
    }

    int amount = getLevel() * 2;

    mana -= 15;

    return target.restoreHealth(amount);
}

}
