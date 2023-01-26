package org.example;

public class Human extends Entity {
    // stats from: https://roll20.net/compendium/dnd5e/Commoner#content

    public Human(int str, int ac, int hp, int x, int y) {
        super(str, ac, hp, x, y);
    }

    public void attack(Goblin enemy){
        // Human goes first.
        if (Game.rollTwenty() < enemy.getArmourClass()) {
            System.out.println("You attacked the goblin, but it did no damage.");
        } else {
            // Player attacks.
            int damage = Game.rollSix(); // This is based off a Rapier, which does 1d6 damage.
            if (damage == 1) {
                System.out.println("You attacked the goblin for one whole damage.");
            } else {
                System.out.println("You attacked for " + damage + " damage.");
            }
            enemy.takeDamage(damage);
        }
    }

    @Override
    public String toString() {
        return "Human. Armour class: " + this.getArmourClass() + " , Hit Points: " + this.getHitPoints() + " , X position: " + this.getX()
                + " , Y position: " + this.getY() + ".";
    }
}
