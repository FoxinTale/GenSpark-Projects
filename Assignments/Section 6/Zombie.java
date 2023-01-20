package genspark.assignments.section6;

import genspark.assignments.Assignment;

public class Zombie extends Humanoid implements Assignment{

    // Default Constructor
    private int brainLust;
    private int strength;
    private int intelligence;
    private int health;
    private int compassion;
    public Zombie(int lust, int str, int intel, int hp, int comp) {
        this.brainLust = lust;
        this.strength = str;
        this.intelligence = intel;
        this.health = hp;
        this.compassion = comp;
    }

    public Zombie() {

    }

    public String attack(Object obj){
        Human being = (Human) obj;

        being.setHealth(being.getHealth() - this.strength);

        if(being.getHealth() <= 3){
            return "The zombie bites the human for " + this.strength + " damage, the human has died...";
        } else {
            return "The zombie bites the human for " + this.strength + " damage, the human survives but will be turning soon...";
        }

    }

    public Class<?> whoIsTheParent(){
        return this.getClass().getSuperclass();
    }


    public int getBrainLust(){
        return brainLust;
    }

    public void setBrainLust(int lust){
        brainLust = lust;
    }

    public int getStrength(){
        return strength;
    }

    public void setStrength(int str){
        strength = str;
    }

    public int getIntelligence(){
        return intelligence;
    }

    public void setIntelligence(int intel){
        intelligence = intel;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int hp){
        health = hp;
    }

    public int getCompassion(){
        return compassion;
    }

    public void setCompassion(int comp){
        compassion = comp;
    }

}
