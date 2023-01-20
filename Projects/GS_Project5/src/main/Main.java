package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    /*
    This is a text based hangman game.
    The program thinks of a word, then draws a blank line on the console for each letter in the word.
    Then the player tries to guess the word.

    It will also output the current state of the game itself

     */

    // This is probably a fair amount, but it prevents me needing to pass a lot of arguments / parameters between functions.
    private static String word;
    private static char[] wordChars;
    private static char[] charsToGuess;
    private static ArrayList<Character> guessedChars;
    private static ArrayList<Character> wrongChars;
    private static int guessCount = 0;
    private static boolean keepGoing = true;
    private static boolean firstRun = true; // This cannot be defined in main, as main is called again at some point, if the user re-does the game.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(firstRun){
            setupGame();
            firstRun = false;
        }


        String input;

        while (guessCount < 11 && keepGoing) {
            input = sc.nextLine();
            handleInputAndGame(input, sc);
        }

        if(guessCount >= 10){
            System.out.println("The man has been hung.");
            endOfGame(sc);
        }
        // To do: Try to unit test things.
    }


    public static void handleInputAndGame(String s, Scanner sc) {
        boolean error = false; // Reset as it's a new input.
        char c = 0;
        if(s.isEmpty() || s.isBlank()){
            System.out.println("That's an empty space. There are no words with spaces this cna give you.");
            error = true;
        } else {
            c = s.charAt(0);
        }
         // If the user inputs more than one character, it will ignore everything but the first one.
        // This would get changed to true if an invalid input is done.

        try {
            if (Integer.parseInt(s) > 0) {
                System.out.println("Uh..that's a number, not a letter. Try again.");
                error = true;
            }
        } catch (NumberFormatException NFE) { // Yeah. This is how I wrote it. It's supposed to do this.
            if (guessedChars.contains(c) || wrongChars.contains(c)) {
                System.out.println("You've already guessed that letter.");
                error = true;
            }
            if (word.contains(s) && !error) {
                guessedChars.add(c);
                rebuildArray(wordChars, charsToGuess, c);
                printCharArray(charsToGuess);

                if (checkWin(wordChars, charsToGuess)) { // If the word has been completed.
                    System.out.println("That's the word. Good job.");
                    endOfGame(sc);
                }

            } else if (!error) { // If nothing else has gone wrong, it is an incorrect character.
                System.out.println("Try again.");
                wrongChars.add(c);
                System.out.println(printStage(guessCount));
                System.out.println(); // Spacer.
                printCharArray(charsToGuess);
                printWrongChars(wrongChars);
                guessCount += 1;
            }
        }
    }


    public static void setupGame() {
        System.out.println("Welcome to  H A N G M A N");
        resetGame();
    }


    public static void endOfGame(Scanner sc){
        String response = "";
        System.out.println("Would you like to play again?");
        response = sc.nextLine();

        if (response.equalsIgnoreCase("y")) {
            keepGoing = true;
            main(null); // I have no idea why, but without this, it would not keep playing the game if you chose yes.
            // Hell, I didn't even know you could do this.
        } else {
            keepGoing = false;
        }
    }


    public static String generateWord() {
        // A super generic word list.
        String[] words = {"hair", "foxes", "what", "computer", "things", "word", "worms", "phone", "games", "stuff"};
        int num = ThreadLocalRandom.current().nextInt(0, words.length - 1);

        return words[num];
    }


    public static void resetGame() {
        guessCount = 0;
        word = generateWord();
        System.out.println("Input a character.");

        wordChars = word.toCharArray();
        charsToGuess = new char[wordChars.length];

        guessedChars = new ArrayList<>();
        wrongChars = new ArrayList<>();

        Arrays.fill(charsToGuess, '_'); // Fill with underscores.
        printCharArray(charsToGuess);
    }


    public static String printStage(int tries) {
        switch (tries) {
            case 0:
                return "_ ___";
            case 1:
                return " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + "_|___";
            case 2:
                return " ___________\n" + " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + "_|___";
            case 3:
                return " ___________\n" + " |/\n" + " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + "_|___";
            case 4:
                return " ___________\n" + " |/      |\n" + " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + "_|___";
            case 5:
                return " ___________\n" + " |/      |\n" + " |      (_)\n" + " |\n" + " |\n" + " |\n" + " |\n" + "_|___\n";
            case 6:
                return " ___________\n" + " |/      |\n" + " |      (_)\n" + " |       |\n" + " |       |\n" + " |\n" + " |\n" + "_|___";
            case 7:
                return " ___________\n" + " |/      |\n" + " |      (_)\n" + " |       |\n" + " |       |\n" + " |      /\n" + " |\n" + "_|___";
            case 8:
                return " ___________\n" + " |/      |\n" + " |      (_)\n" + " |       |\n" + " |       |\n" + " |      / \\\n" + " |\n" + "_|___";
            case 9:
                return " ___________\n" + " |/      |\n" + " |      (_)\n" + " |      \\|\n" + " |       |\n" + " |      / \\\n" + " |\n" + "_|___";
            case 10:
                return " ___________\n" + " |/      |\n" + " |      (_)\n" + " |      \\|/\n" + " |       |\n" + " |      / \\\n" + " |\n" + "_|___";
            default:
                return "";
        }
    }


    public static void rebuildArray(char[] word, char[] guess, char c) {
        ArrayList<Integer> positions = new ArrayList<>();


        for (int i = 0; i < word.length; i++) {
            if (word[i] == c) {
                positions.add(i);
            }
        }

        for (Integer position : positions) {
            guess[position] = c;
        }
    }


    public static boolean checkWin(char[] word, char[] guess) {
        return Arrays.equals(word, guess);
    }


    public static void printWrongChars(ArrayList<Character> chars) {
        System.out.println("Missed letters: " + Arrays.toString(chars.toArray()).replace(",", "").replace("[", "").replace("]", ""));
    }


    public static void printCharArray(char[] arr) {
        System.out.println(Arrays.toString(arr).replace(",", "").replace("[", "").replace("]", ""));
    }
}