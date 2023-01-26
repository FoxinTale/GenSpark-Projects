package org.example;

public class Human extends Entity {
    // stats from: https://roll20.net/compendium/dnd5e/Commoner#content

    public Human(int str, int ac, int hp, int x, int y) {
        super(str, ac, hp, x, y);
    }

    public String attack(Goblin enemy) {
        if (Game.rollTwenty() < enemy.getArmourClass()) {
            return "You attacked the goblin, but it did no damage.";
        } else {
            int damage = Game.rollSix(); // This is based off a Rapier, which does 1d6 damage.
            enemy.takeDamage(damage);
            if (damage == 1) {
                return "You attacked the goblin for one whole damage.";
            } else {
                return "You attacked for " + damage + " damage.";
            }

        }
    }

    @Override
    public String toString() {
        return "Human. Armour class: " + this.getArmourClass() + " , Hit Points: " + this.getHitPoints() + " , X position: " + this.getX()
                + " , Y position: " + this.getY() + ".";
    }
}
