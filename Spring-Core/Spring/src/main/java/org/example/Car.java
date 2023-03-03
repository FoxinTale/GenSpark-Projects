package org.example;


public class Car implements Vehicle {
    Tyre wheel;

    public void init(){
        System.out.println("Car's init method.");
        // Stuff that happens at start-up would essentially go here.
    }

    public void destroy(){
        System.out.println("The car is totaled, That's going to be expensive.");

    }

    public void setWheel(Tyre wheel){
        this.wheel = wheel;
    }
    public void drive(){
        System.out.println("Time to go drive something." + wheel);
    }
}
