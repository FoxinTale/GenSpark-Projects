package org.example;
//  Another sub-class of "Animal" since it extends.
public class Dog extends Animal{ // Inheritance, again.
   // I don't know if constructors cound as method over-loading, but they're an easy example.
    // Same name, different parameters.
    public Dog(String name, int age) {
        super(name, age);
    }
    public Dog(){
        super();
    }

    // Method over-riding... Over-riding the speak method.
    @Override
    public void speak() {
        System.out.println("I'm a dog. *bark*");
    }

    // Abstraction. The function does exactly what one  thinks it does by name.
    public static String printAgeInDogYears(){
        int age = getAge(); // Inheritance, again. Using its parent functions.
        return "I am " + (age * 7) + " years old in dog years.";
    }
}
