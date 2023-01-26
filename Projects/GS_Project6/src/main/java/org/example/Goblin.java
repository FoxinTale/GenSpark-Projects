package org.example;

public class Goblin extends Entity {
// Stats from: https://www.dndbeyond.com/monsters/16907-goblin

    public Goblin(int str, int ac, int hp, int x, int y){
        super(str, ac, hp, x, y);
    }
    public void attack(Human player) {
        if (Game.rollTwenty() < player.getArmourClass()) {
            /*
                D & D has this mechanic called "Armour Class" (AC). At its most basic level, this is determined by the type of armour the character is wearing.
                Bonuses, can of course be applied as well. How this works, is when an attack is made, a d20 is rolled. If the number is lower than the entity's AC,
                the attack fails. If it is equal to or greater than the AC, the attack lands and a damage roll is done which the amount is weapon-dependent.
            */
            System.out.println("The goblin attacked, but it did no damage.");
        } else {
            // Goblin attacks.
            int damage = Game.rollFour(); // this is based off of a wooden club, which does 1d4 damage, hence the rollFour()

            if (damage == 1) {
                System.out.println("The goblin attacked for one whole damage.");
            } else {
                System.out.println("The goblin attacked for " + damage + " damage.");
            }
            player.takeDamage(damage);
            int playerHP = player.getHitPoints();
            if (playerHP > 0) {
                System.out.println("You now have " + playerHP + " hit points.");
            } else {
                System.out.println("You now have 0 hit points.");
            }
        }
    }
    @Override
    public String toString() {
        return "Goblin. Armour class: " + this.getArmourClass() + " , Hit Points: " + this.getHitPoints() + " , X position: " + this.getX()
                + " , Y position: " + this.getY() + ".";
    }


}
