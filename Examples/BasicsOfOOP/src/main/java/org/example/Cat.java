package org.example;

public class Cat extends Animal{ // Inheritance.
    public Cat(String name, int age) {
        super(name, age);
    }

    // Polymorphism.
    @Override
    public void speak() {
        System.out.println("I'm a cat! *meow*");
    }
}
