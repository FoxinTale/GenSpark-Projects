import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*
Project Two - Auubrey Woodhouse
Description:

This is a guess the number type game, where a number between 1 and 20 is chosen, then the user is asked to guess it.
After each guess, they will be told if it is too high or too low. If guessed within six tries, the user wins.


When this is over, the user is asked if they wish to play again, and if not the program exits.

- the user is also asked for their name and this is displayed.
- When correct, it congratulates the user and lists how many tries it took.
  */
public class Main {
    public static void main(String[] args) {
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
                try{
                    input = Integer.parseInt(sc.nextLine());

                    if(1 > input || input > 20){ // Less than 1 or greater than 20.
                        System.out.println("Input number was out of range.");
                        error = true;
                    }
                } catch (NumberFormatException nfe){
                    System.out.println("That is...not a number, sorry. ");
                    error = true;
                }

                if (!error && input > num){
                    System.out.println("The guess was too high.");
                }
                else if (!error && input < num){
                    System.out.println("The guess was too low.");
                }

                if(!error){ // We don't want an error counting as a try after all.
                    tries += 1;
                } else {
                    error = false; // reset for a new line.
                }

            }
            if (input == num) {
                System.out.println("Conglaturations, " + name + ". You guessed it in " + tries + " tries.");
                // Mis-spelling of congratulations is intentional. This is a reference to the screen when you beat Ghostbusters for the Atari 2600 & NES.
            }
            if(tries >= 6){
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