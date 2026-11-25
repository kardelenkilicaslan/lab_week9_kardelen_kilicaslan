
package lab_week9;

import java.util.ArrayList;
public class Team {
     private ArrayList<GameCharacter> characters=new ArrayList<>();
     
     public void addCharacter(GameCharacter character) {
         for(GameCharacter c:characters){
             if(c.getName().equals(character.getName())){
                 System.out.println("Character already exists!");
                 return;
                 
                         
             }
             
                 
         }
         characters.add(character);
     }
     
    public void removeCharacter(String name){
        for(int i=0; i<characters.size(); i++){
             if(characters.get(i).getName().equals(name))
                 characters.remove(i);
             return;
             
         }
          System.out.println("Character not found!");
         
     }
     
    public GameCharacter findByName(String name) {
      for (GameCharacter c : characters) {
         if (c.getName().equals(name)) {
            return c;
        }
    }

    return null;
}
    public void attackAll(GameCharacter target) {
       for (GameCharacter c : characters) {

            if (c.isAlive() && c instanceof Attacker) {
 
            Attacker attacker = (Attacker) c;

            attacker.attack(target);
        }
    }
}
    
    
    
    
    public void healTeam() {
    GameCharacter weakest = null;

     for (GameCharacter c : characters) {

        if (c.isAlive()) {

            if (weakest == null) {
                weakest = c;
            } else if ((double)c.getHealth() / c.getMaxHealth()
                    < (double)weakest.getHealth() / weakest.getMaxHealth()) {

                weakest = c;
            }
        }
    }

    if (weakest == null) {
        return;
    }

    for (GameCharacter c : characters) {

        if (c.isAlive() && c instanceof Supporter) {

            Supporter s = (Supporter) c;
            s.heal(weakest);
        }
    }
}
    
    public int getTotalPower() {
        int total = 0;
        for (GameCharacter c : characters) {
            if (c.isAlive()) {
                total += c.calculatePower();
            }
        }

        return total;
    }

    public void displayTeam() {
        for (GameCharacter c : characters) {

            System.out.println(c.getCharacterInfo());
        }
    }
}
    
     
     
     
     
     
     

