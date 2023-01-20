import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Choose a game. 1 for \"Dragon Game\", and 2 for \"Choose a Number\".");

        try{
            choice = Integer.parseInt(sc.nextLine());
			 // I could ahave used a if / else, but this is left open for there to be more options if I decide to come back and add another game in the future.
            if (choice == 1) {
                dragonGame();
            } else if (choice == 2){
                numberGame();
            }
        } catch (NumberFormatException NFE){
            System.out.println("That wasn't a valid option.");
        }
      //

    }

    // Project one.
    public static void dragonGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("You are in a land full of dragons. Let's call it Tamriel because why not.");
        System.out.println("In front of you, there are two caves.");
        System.out.println("In one cave, the dragon is friendly and will share his treasure with you.");
        System.out.println("The other dragon is greedy and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? (1 or 2)");
        String input = sc.nextLine();
        // A switch statement could be used, however there are too few things here for it to be of much use.
        try {
            if (input.equals("1")) {
                System.out.println("You approach the cave...");
                System.out.println("It is dark and spooky...");
                System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
                System.out.println("Gobbles you down in one bite!");
            } else if (input.equals("2")) {
                System.out.println("You approach the cave...");
                System.out.println("It is dark and spooky...");
                System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
                System.out.println("Tells you where his treasure is!");
            } else {
                System.out.println("That wasn't an option.");
            }
        } catch (NumberFormatException NFE) {
            System.out.println("How did you manage this?");
        }
    }


    // Project two.
    public static void numberGame() {
        String name = "";
        String strInput;
        int num = 0;
        int input = 0;
        int tries = 0;
        boolean keepGoing = true;
        boolean error = false;

        Scanner sc = new Scanner(System.in);
        System.out.println("Good day, Who may you be?");
        name = sc.nextLine();

        while (keepGoing) {
            num = ThreadLocalRandom.current().nextInt(1, 20);
            System.out.println("Greetings, " + name + ". There is a number between 1 and 20 for you to guess. Go ahead.");

            while (tries < 6 && input != num) {
                System.out.println("Take a guess, or try again.");
                try {
                    input = Integer.parseInt(sc.nextLine());

                    if (1 > input || input > 20) { // Less than 1 or greater than 20.
                        System.out.println("Input number was out of range.");
                        error = true;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("That is...not a number, sorry. ");
                    error = true;
                }

                if (!error && input > num) {
                    System.out.println("The guess was too high.");
                } else if (!error && input < num) {
                    System.out.println("The guess was too low.");
                }

                if (!error) { // We don't want an error counting as a try after all.
                    tries += 1;
                } else {
                    error = false; // reset for a new line.
                }

            }
            if (input == num) {
                System.out.println("Conglaturations, " + name + ". You guessed it in " + tries + " tries.");
                // Mis-spelling of congratulations is intentional. This is a reference to the screen when you beat Ghostbusters for the Atari 2600 & NES.
            }
            if (tries >= 6) {
                System.out.println("Amount of tries exceeded.");
            }

            System.out.println("Would you like to play again? (y or n)");
            strInput = sc.nextLine();

            if (strInput.equalsIgnoreCase("n")) {
                System.out.println("Goodbye then.");
                keepGoing = false;
            } else {
                tries = 0; // Reset the tries so they can play again.
            }
        }

    }

}