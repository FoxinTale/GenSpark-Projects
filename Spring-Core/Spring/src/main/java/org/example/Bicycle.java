package org.example;

import org.springframework.stereotype.Component;

@Component
public class Bicycle implements Vehicle {
    Tyre wheel;

    public void setWheel(Tyre wheel){
        this.wheel = wheel;
    }
    public void drive(){
        System.out.println("Bike time!" + wheel);
    }
}
