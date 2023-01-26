package org.example;

public class Goblin extends Entity {
// Stats from: https://www.dndbeyond.com/monsters/16907-goblin

    public Goblin(int str, int ac, int hp, int x, int y){
        super(str, ac, hp, x, y);
    }


    @Override
    public String toString() {
        return "Goblin. Armour class: " + this.getArmourClass() + " , Hit Points: " + this.getHitPoints() + " , X position: " + this.getX()
                + " , Y position: " + this.getY() + ".";
    }
}
