package org.example;

public class Main {
    public static void main(String[] args) {

        Dog spot = new Dog("Spot", 2);
        Cat boots = new Cat("Boots", 4);

        spot.speak();
        boots.speak();
        System.out.println(spot.printAgeInDogYears());

    }
}