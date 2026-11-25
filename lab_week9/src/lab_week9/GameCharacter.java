
package lab_week9;

public abstract class GameCharacter {
    private String name;
    private int level;
    private int health;
    private int maxHealth;

    public GameCharacter(String name, int level, int maxHealth) {
        this.name = name;
        
        if(level<1 || level>100 ){
            System.out.println("invalid level");
            this.level=1;
            
        }else{
            this.level = level;
        }
       
       
        
        if(maxHealth<=0 ){
            System.out.println("invalid max health");
            this.maxHealth=100;
        }else{
            this.maxHealth = maxHealth; 
        }
         this.health = this.maxHealth;
       
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
    
    
    
    public abstract String getCharacterInfo();
    public abstract int calculatePower();
    
    public boolean isAlive(){
        if(health>0){
            return true;
            
        }else 
            return false;
    }
    
    public int takeDamage(int damage){
        int actualDamage;
        if (damage <= 0) {
            actualDamage = 0;
        } else if (damage > health) {
            actualDamage = health;
        } else {
            actualDamage = damage;
        }

        health -=actualDamage;
        return actualDamage;
        
    }
    
    public int restoreHealth(int amount){
        
        if(!isAlive() || amount<=0){
            return 0;
        }
        
        int actualRestore;
        if(health + amount > maxHealth){
            actualRestore=maxHealth-health;
            
        }else{
            actualRestore=amount;
        }
        
        health+=actualRestore;
        
        return actualRestore;
        
        
    }
    
    
    
    
}
