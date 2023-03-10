package org.example;

public class Dog extends Animal{ // Inheritance, again.
    public Dog(String name, int age) {
        super(name, age);
    }
    public Dog(){
        super();
    }

    @Override
    public void speak() {
        System.out.println("I'm a dog. *bark*");
    }

    // Abstraction. The function does exactly what one  thinks it does by name.
    //
    public static String printAgeInDogYears(){
        int age = getAge(); // Inheritance, again. Using its parent functions.
        return "I am " + (age * 7) + " years old in dog years.";
    }
}
