
package lab_week9;


public class Warrior extends GameCharacter implements Attacker {
    private int armor;

    public Warrior( String name, int level, int maxHealth,int armor) {
        super(name, level, maxHealth);
        this.armor = armor;
    }
    
    


    @Override
    public String getCharacterInfo() {
        return "Warrior: " + getName() + ", Level: " + getLevel()  + ", Health: " + getHealth() + ", Armor: " + armor;
    }
     @Override
    public int calculatePower() {
        return getLevel() * 10 + armor * 2;
    }
    
    @Override
    public int takeDamage(int damage) {

    int reducedDamage;

    if (damage <= 0) {
        return 0;
    }

    reducedDamage = damage - (armor / 2);

    if (reducedDamage < 1) {
        reducedDamage = 1;
    }

    return super.takeDamage(reducedDamage);
}
    
    @Override
public int attack(GameCharacter target) {

    if (!isAlive() || !target.isAlive()) {
        return 0;
    }

    int damage = calculatePower() / 4;

    return target.takeDamage(damage);
}
    
    
    }