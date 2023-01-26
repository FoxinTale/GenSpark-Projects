package org.example;

public class Entity {
    private int strength;
    private int armourClass;
    private int hitPoints;
    private int x;
    private int y;

    public Entity(int str, int ac, int hp, int x, int y) {
        this.strength = str;
        this.armourClass = ac;
        this.hitPoints = hp;
        this.x = x;
        this.y = y;
    }

    public void takeDamage(int damage){
        hitPoints = hitPoints - damage;
    }

    public int getStrength(){
        return this.strength;
    }

    public void setStrength(int str){
        this.strength = str;
    }

    public int getArmourClass() {
        return armourClass;
    }

    public void setArmourClass(int armourClass) {
        this.armourClass = armourClass;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isDead(){
        return hitPoints <= 0;
    }

    @Override
    public String toString() {
        return "Generic Entity. Armour class: " + this.getArmourClass() + " , Hit Points: " + this.getHitPoints() + " , X position: " + this.getX()
                + " , Y position: " + this.getY() + ".";
    }
}
