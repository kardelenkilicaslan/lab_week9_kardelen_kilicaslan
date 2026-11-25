
package lab_week9;


public class Lab_week9 {

    public static void main(String[] args) {
    

       
        Team team = new Team();

       
        Warrior warrior = new Warrior("Thor", 10, 150, 20);
        Mage mage = new Mage("Merlin", 12, 100, 80);
        Healer healer = new Healer("Luna", 8, 120, 25);

        
        team.addCharacter(warrior);
        team.addCharacter(mage);
        team.addCharacter(healer);

        
        Warrior duplicate = new Warrior("Thor", 5, 100, 10);
        team.addCharacter(duplicate);

        
        Mage invalidMage = new Mage("DarkMage", 150, 100, 50);
        team.addCharacter(invalidMage);

       
        Warrior enemy = new Warrior("Golem", 20, 300, 30);

      
        System.out.println("INITIAL TEAM");
        team.displayTeam();

       
        System.out.println("\nROUND 1");

        team.attackAll(enemy);

        System.out.println("Enemy health: " + enemy.getHealth());

       
        enemy.attack(warrior);
        enemy.attack(mage);

        System.out.println("Warrior health: " + warrior.getHealth());
        System.out.println("Mage health: " + mage.getHealth());

       
        team.healTeam();

        System.out.println("\nAfter healing:");
        team.displayTeam();

        
        System.out.println("\nROUND 2");

        team.attackAll(enemy);

        System.out.println("Enemy health: " + enemy.getHealth());

       
        enemy.attack(healer);
        enemy.attack(warrior);

        System.out.println("Healer health: " + healer.getHealth());
        System.out.println("Warrior health: " + warrior.getHealth());

        
        team.healTeam();

        System.out.println("\nAfter second healing:");
        team.displayTeam();

        
        System.out.println("\nREMOVING MAGE");
        team.removeCharacter("Merlin");

        
        System.out.println("\nSEARCHING FOR THOR");
        GameCharacter found = team.findByName("Thor");

        if (found != null) {
            System.out.println(found.getCharacterInfo());
        } else {
            System.out.println("Character not found!");
        }

       
        System.out.println("\nFINAL TEAM");
        team.displayTeam();

        
        System.out.println("\nTotal team power: " + team.getTotalPower());
    }
}

    
    

