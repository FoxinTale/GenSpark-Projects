package org.example;

public class Human extends Entity {
    // stats from: https://roll20.net/compendium/dnd5e/Commoner#content

    public Human(int str, int ac, int hp, int x, int y) {
        super(str, ac, hp, x, y);
    }


    @Override
    public String toString() {
        return "Human. Armour class: " + this.getArmourClass() + " , Hit Points: " + this.getHitPoints() + " , X position: " + this.getX()
                + " , Y position: " + this.getY() + ".";
    }
}
