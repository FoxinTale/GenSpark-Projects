package org.GSProject6;

public class Goblin extends Entity {
// Stats from: https://www.dndbeyond.com/monsters/16907-goblin

    public Goblin(int str, int ac, int hp, int x, int y) {
        super(str, ac, hp, x, y);
    }

    public String attack(Human player) {
        if (Game.rollTwenty() < player.getArmourClass()) {
            /*
                D & D has this mechanic called "Armour Class" (AC). At its most basic level, this is determined by the type of armour the character is wearing.
                Bonuses, can of course be applied as well. How this works, is when an attack is made, a d20 is rolled. If the number is lower than the entity's AC,
                the attack fails. If it is equal to or greater than the AC, the attack lands and a damage roll is done which the amount is weapon-dependent.
            */
            return "The goblin attacked, but it did no damage.";
        } else {
            int damage = Game.rollFour(); // this is based off of a wooden club, which does 1d4 damage, hence the rollFour()
            player.takeDamage(damage);

            if (damage == 1) {
                return "The goblin attacked for one whole damage.";
            } else {
                return "The goblin attacked for " + damage + " damage.";
            }
        }
    }

    @Override
    public String toString() {
        return "Goblin. Armour class: " + this.getArmourClass() + " , Hit Points: " + this.getHitPoints() + " , X position: " + this.getX()
                + " , Y position: " + this.getY() + ".";
    }


}
