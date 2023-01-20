package org.example;

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
    }
    // --------------------------------------------------- Project One. -------------------------------------------------------------

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
        gameOutput(input);
        } catch (NumberFormatException NFE) {
            System.out.println("How did you manage this?");
        }
    }

    public static String gameOutput(String input){
        if (input.equals("1")) {
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("Gobbles you down in one bite!");
            return "Well that didn't go as planned.";
        } else if (input.equals("2")) {
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("Tells you where his treasure is!");
            return "Hey, I'm rich and friends with a freaking dragon.";
        } else {
            System.out.println("That wasn't an option.");
        }
        return "";
    }

    // --------------------------------------------------- Project Two. -------------------------------------------------------------
    public static boolean error = false;
    // Thsese are constants so that I can easily access them from the test class.
    // I prefer to write strings in a separate class just called "Strings" for larger programs (see https://github.com/FoxinTale/Modpack-Installer/tree/master/Source%20Code)
    // for localisation purposes. so this is a bit of a remnant habit.
    public static String outOfRange = "Input number was out of range.";
    public static String notANumber = "That is...not a number, sorry. ";
    public static String correctAnswer = "That is correct!";
    public static String answerTooLow = "That guess is too low.";
    public static String answerTooHigh = "That guess is too high.";

    public static void numberGame() {
        String name = "";
        String strInput;
        int num = 0;
        int input = 0;
        int tries = 0;
        boolean keepGoing = true;

        Scanner sc = new Scanner(System.in);
        System.out.println("Good day, Who may you be?");
        name = sc.nextLine();

        while (keepGoing) {
            num = randomNumber();
            System.out.println("Greetings, " + name + ". There is a number between 1 and 20 for you to guess. Go ahead.");
            input = Integer.parseInt(sc.nextLine());

            while (tries < 6 && input != num) {
                System.out.println("Take a guess, or try again.");
                System.out.println(validateInput(input));

                System.out.println(valueCheck(input, num));

                if (!error) { // We don't want an error counting as a try after all.
                    tries += 1;
                } else {
                    error = false; // reset for a new line.
                }

            }
            if (input == num) {
                System.out.println("Conglaturations, " + name + ". You guessed it in " + tries + " tries.");
                // Mis-spelling of congratulations is intentional. This is a reference to the screen when you beat Ghostbusters for the Atari 2600 & NES.
                // In a production or formal product, this would not be here, but it's a small project just to go-over basic things, so...why not then?
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

    public static String validateInput(int input) {
        try {
            if (1 > input || input > 20) { // Less than 1 or greater than 20.
                error = true;
                return outOfRange;
            }
        } catch (NumberFormatException nfe) {
 //           error = true;
            return notANumber;
        }
        return "";
    }

    public static int randomNumber(){
        return ThreadLocalRandom.current().nextInt(1, 20);
    }

    public static String valueCheck(int guess, int num) {
        if (guess > num) {
            return answerTooHigh;
        } else if (guess < num) {
            return answerTooLow;
        } else {
            return correctAnswer;
        }
    }
}