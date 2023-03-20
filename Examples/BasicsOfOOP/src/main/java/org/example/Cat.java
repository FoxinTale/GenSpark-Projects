package org.example;

// Sub-class of "Animal" since it extends.
public class Cat extends Animal{ // Inheritance.

    public Cat(){
        super();
    }
    public Cat(String name, int age) {
        super(name, age);
    }

    // Method over-riding... Over-riding the speak method of the superclass.
    @Override
    public void speak() {
        System.out.println("I'm a cat! *meow*");
    }
}
