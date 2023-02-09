package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    /*
    This is a text based hangman game.
    The program thinks of a word, then draws a blank line on the console for each letter in the word.
    Then the player tries to guess the word.

    It will also output the current state of the game itself.

    ------------------
    Additions for project 7:
    [ ] - No loops except for the main game loop, which should be a while loop. Other loops should be done through map, filter and reduce.
    [x] - The art should be read through a file, which connotates the state of the game.
    [x] - The user should be able to enter their name.
    [-] - The name and high score is recorded to a file at the end of each game.
    [ ] - The game tells the user if they have the high score or not.
    [ ] - No exceptions. Everything must be caught.
     */

    private static boolean firstRun = true; // This cannot be defined within main, as main is called again at some point, if the user re-does the game.

    public static void main(String[] args) {

        /*
        Scanner sc = new Scanner(System.in);
        if(firstRun){
            System.out.println("Input a username.");
            Game.setPlayerName(sc.nextLine());
            Game.setupGame();
            Game.setGameState(FileOps.readArtFile());
            firstRun = false;
        }

        String input;

        while (Game.getGuessCount() < 11 && Game.keepGoing) {
            input = sc.nextLine();
            System.out.println(Game.gameStuff(input));
        }

        if(Game.getGuessCount() >= 10){
            System.out.println("The man has been hung.");
            Game.endOfGame();
        }
         */
    }
}