package org.example;

public class Main {
    public static void main(String[] args) {

        // Two ways of declaring a dog.
        Dog spot = new Dog("Spot", 2);
        Dog spotTheSecond = new Dog();
        Cat boots = new Cat("Boots", 4);

        spot.speak();
        boots.speak();

        System.out.println(spot.printAgeInDogYears());
    }
}