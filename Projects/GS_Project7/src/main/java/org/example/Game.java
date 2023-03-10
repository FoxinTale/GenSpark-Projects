package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    // This is probably a fair amount, but it prevents me needing to pass a lot of arguments / parameters between functions.
    private static String word;
    private static char[] wordChars;
    private static char[] charsToGuess;
    private static ArrayList<Character> guessedChars;
    private static ArrayList<Character> wrongChars;
    private static String[] gameState;
    private static int guessCount = 0;
    static boolean keepGoing = true;
    private static int currentScore = 0;
    private static int highScore;
    private static String playerName;

    public static String handleInput(String s){
        if(s.isEmpty() || s.isBlank()){
            return "That's an empty space. There are no words with spaces this can give you.";
        }
        try {
            if (Integer.parseInt(s) >= 0 || Integer.parseInt(s) <= 0) {
                return "That's a number, not a letter.";
            }
        } catch (NumberFormatException NFE) {
            String specialChars = "~`!@#$%^&*()_-+=[]{}|\\:;\"'<,.>?/";
            if(s.length() > 1){
                return "That has more than one character.";
            } else if(specialChars.contains(s)){
                return "You're playing hangman, not trying to guess a password.";
            }
            else {
                return "";
            }
        }
        return "Something went wrong.";
    }


    public static String gameStuff(String s){
        String result = handleInput(s);

        if(result.isEmpty()){
            char c = s.charAt(0);
            if (guessedChars.contains(c) || wrongChars.contains(c)) {
                return "You've already guessed that letter.";
            }
            if (word.contains(s)) {
                currentScore += 10;
                guessedChars.add(c);
                rebuildArray(wordChars, charsToGuess, c);
                printCharArray(charsToGuess);

                if (checkWin(wordChars, charsToGuess)) { // If the word has been completed.
                    System.out.println("That's the word. Good job.");
                    endOfGame();
                    return ""; // I do this instead of just returning the above string because during testing,
                    // if the user guessed the word correctly, it wouldn't tell them they got it until the program finished running.
                }
            } else { // If nothing else has gone wrong, it is an incorrect character.
                currentScore = 0;
                wrongChars.add(c);
                System.out.println(printStage(guessCount));
                System.out.println(); // Spacer.
                printCharArray(charsToGuess);
                printWrongChars(wrongChars);
                guessCount += 1;
                return "Try again.";
            }
        }
        return result;
    }

    public static void setupGame() {
        System.out.println("Welcome to H A N G M A N, " + playerName + ".");
        FileOps.readDataFile();
        resetGame();
    }

    public static void endOfGame(){
        String response;
        if(checkHighScore()){
            System.out.println("You do not have the high score of " + highScore + " points. Even though scoring hangman makes little sense.");
        } else {
            System.out.println("You have the high score of " + currentScore + " points. Even though scoring hangman makes little sense.");
            highScore = currentScore;
        }
        System.out.println("Would you like to play again?");
        Scanner sc = new Scanner (System.in);
        response = sc.nextLine();

        if (response.equalsIgnoreCase("y")) {
            keepGoing = true;
            resetGame();
            Main.main(null); // I have no idea why, but without this, it would not keep playing the game if you chose yes.
            // Hell, I didn't even know you could do this.
        } else {
            FileOps.writeDataFile();
            System.out.println("Thanks for playing!");
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

    /*
    Takes two char arrays, A and B, and a single char. A is the actual word to guess, B is the guesses and blank spots.

    The first loop looks for where the given char is at within A, and if the item at that position is the given char,
    it adds the position to an arraylist due to the possibility of there being multiple of it.

     The second loop uses the previously found positions to set the index of the guessed word array equal to the character.

     I tried to turn these into streams. Everything went to hell and broke.  The game kept resetting, or it gave you a win if
     you guessed only one letter correct
     */
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

    public static boolean checkHighScore(){

        return currentScore < highScore;
    }

    public static void printWrongChars(ArrayList<Character> chars) {
        System.out.println("Missed letters: " + Arrays.toString(chars.toArray()).replace(",", "").replace("[", "").replace("]", ""));
    }

    public static void printCharArray(char[] arr) {
        System.out.println(Arrays.toString(arr).replace(",", "").replace("[", "").replace("]", ""));
    }

    public static void setGameState(String[] gameState) {
        Game.gameState = gameState;
    }

    public static void setPlayerName(String playerName) {
        Game.playerName = playerName;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static int getGuessCount(){
        return guessCount;
    }

    public static int getCurrentScore() {
        return currentScore;
    }

    public static void setHighScore(int highScore) {
        Game.highScore = highScore;
    }

    public static String printStage(int tries) {
        if(tries >= 0 && tries <= 10){
            return gameState[tries].replaceAll("\r\n?", "\n").stripTrailing();
        }
        return "";
    }
}
