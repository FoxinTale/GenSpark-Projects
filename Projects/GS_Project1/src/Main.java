import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" You are in a land full of dragons. Let's call it Tamriel because why not.");
        System.out.println(" In front of yopu, there are two caves.");
        System.out.println(" In one cave, the dragon is friendly and will share his treasure with you.");
        System.out.println(" The other dragon is greedy and hungry and will eat you on sight.");
        System.out.println(" Which cave will you go into? (1 or 2)");
        String input = sc.nextLine();
        // A switch statement could be used, however there are too few things here for it to be of much use.
        if (input.equals("1"))
        {
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("Gobbles you down in one bite!");
        }
        else if (input.equals("2"))
        {
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("Tells you where his treasure is!");
        } else {
            System.out.println("That wasn't an option.");
        }

    }
}