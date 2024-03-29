package org.example;

// this is the "super class".
public class Animal {
    private static String name;
    private static int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Empty constructor.
    public Animal(){

    }

    // Polymorphism. Same named methods, but they do different things.
    // Though, I suppose since its a constructor I'm not sure it really qualifies.
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
// IntelliJ indicates "2 over-rides for this".
    public void speak(){
        System.out.println("*Generic animal noises*");
    }
}
