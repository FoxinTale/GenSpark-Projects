package org.example;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @org.junit.jupiter.api.Test
    void checkWin() {
        // I wrote this with my cat on my lap...That was the inspiration.
        // This is for if the words equal each other
        assertTrue(Game.checkWin(new char[]{'d', 'o', 'i', 'n', 'g'}, new char[]{'d', 'o', 'i', 'n', 'g'}));
        assertTrue(Game.checkWin(new char[]{'u', 'n', 'i', 't'}, new char[]{'u', 'n', 'i', 't'}));
        assertTrue(Game.checkWin(new char[]{'t', 'e', 's', 't', 'i', 'n', 'g'}, new char[]{'t', 'e', 's', 't', 'i', 'n', 'g'}));
        assertTrue(Game.checkWin(new char[]{'w', 'i', 't', 'h'}, new char[]{'w', 'i', 't', 'h'}));
        assertTrue(Game.checkWin(new char[]{'c', 'a', 't'}, new char[]{'c', 'a', 't'}));

        // This is for if the words do not equal each other.
        assertFalse(Game.checkWin(new char[]{'a'}, new char[]{'u'}));
        assertFalse(Game.checkWin(new char[]{'s', 't', 'u', 'f', 'f'}, new char[]{'t', 'h', 'i', 'n', 'g', 's'}));
        assertFalse(Game.checkWin(new char[]{'w', 'h', 'a', 't'}, new char[]{'w', 'h', 'e', 'r', 'e'}));
        assertFalse(Game.checkWin(new char[]{'w', 'h', 'o'}, new char[]{'w', 'h', 'y'}));
        assertFalse(Game.checkWin(new char[]{'='}, new char[]{'-'}));
    }


    @org.junit.jupiter.api.Test
        // This one is more or less making sure that we do have a word to use, and it's not just an empty string.
    void generateWord() {
        for (int i = 0; i < 20; i++) {
            assertNotEquals("", Game.generateWord());
        }
    }

    @org.junit.jupiter.api.Test
    void handleInput(){
        //Empty spaces
        assertEquals("That's an empty space. There are no words with spaces this can give you.", Game.handleInput(""));
        assertEquals("That's an empty space. There are no words with spaces this can give you.", Game.handleInput("\t"));
        assertEquals("That's an empty space. There are no words with spaces this can give you.", Game.handleInput("\n"));
        assertEquals("That's an empty space. There are no words with spaces this can give you.", Game.handleInput(" "));
        assertEquals("That's an empty space. There are no words with spaces this can give you.", Game.handleInput("           "));

        // Numbers.
        assertEquals("That's a number, not a letter.", Game.handleInput("-13"));
        assertEquals("That's a number, not a letter.", Game.handleInput("-23556"));
        assertEquals("That's a number, not a letter.", Game.handleInput("-1"));

        assertEquals("That's a number, not a letter.", Game.handleInput("0"));

        assertEquals("That's a number, not a letter.", Game.handleInput("45"));
        assertEquals("That's a number, not a letter.", Game.handleInput("1"));
        assertEquals("That's a number, not a letter.", Game.handleInput("2332"));


        // Multiple characters. The most likely case is the user hits two keys right next to each other.
        assertEquals("That has more than one character.", Game.handleInput("de"));
        assertEquals("That has more than one character.", Game.handleInput("ew"));
        assertEquals("That has more than one character.", Game.handleInput("cat"));
        assertEquals("That has more than one character.", Game.handleInput("what"));
        assertEquals("That has more than one character.", Game.handleInput("wq"));

        // "Special" characters.
        assertEquals("You're playing hangman, not trying to guess a password.", Game.handleInput("!"));
        assertEquals("You're playing hangman, not trying to guess a password.", Game.handleInput("&"));
        assertEquals("You're playing hangman, not trying to guess a password.", Game.handleInput("\\"));
        assertEquals("You're playing hangman, not trying to guess a password.", Game.handleInput("?"));
        assertEquals("You're playing hangman, not trying to guess a password.", Game.handleInput(","));

        // And finally, the game as it should be.
        assertEquals("", Game.handleInput("t"));
        assertEquals("", Game.handleInput("h"));
        assertEquals("", Game.handleInput("i"));
        assertEquals("", Game.handleInput("n"));
        assertEquals("", Game.handleInput("G"));
    }


    @org.junit.jupiter.api.Test
    void printStage() {
        Game.setGameState(FileOps.readArtFile()); // We need to read the file to have the data.
        assertEquals("", Game.printStage(-1));
        assertEquals("_ ___", Game.printStage(0));
        assertEquals(" |\n" + " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + "_|___", Game.printStage(1));
        assertEquals(" ___________\n" + " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + "_|___", Game.printStage(2));
        assertEquals(" ___________\n" + " |/\n" + " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + "_|___", Game.printStage(3));
        assertEquals(" ___________\n" + " |/      |\n" + " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + "_|___", Game.printStage(4));
        assertEquals(" ___________\n" + " |/      |\n" + " |      (_)\n" + " |\n" + " |\n" + " |\n" + " |\n" + "_|___\n", Game.printStage(5));
        assertEquals(" ___________\n" + " |/      |\n" + " |      (_)\n" + " |       |\n" + " |       |\n" + " |\n" + " |\n" + "_|___", Game.printStage(6));
        assertEquals(" ___________\n" + " |/      |\n" + " |      (_)\n" + " |       |\n" + " |       |\n" + " |      /\n" + " |\n" + "_|___", Game.printStage(7));
        assertEquals(" ___________\n" + " |/      |\n" + " |      (_)\n" + " |       |\n" + " |       |\n" + " |      / \\\n" + " |\n" + "_|___", Game.printStage(8));
        assertEquals(" ___________\n" + " |/      |\n" + " |      (_)\n" + " |      \\|\n" + " |       |\n" + " |      / \\\n" + " |\n" + "_|___", Game.printStage(9));
        assertEquals(" ___________\n" + " |/      |\n" + " |      (_)\n" + " |      \\|/\n" + " |       |\n" + " |      / \\\n" + " |\n" + "_|___", Game.printStage(10));
        assertEquals("", Game.printStage(11));
        assertEquals("", Game.printStage(20));
    }

    @org.junit.jupiter.api.Test
    void testRandomness() {
        // Check that randomness does in fact fall between 1 and 20. It should.
        int num = 0;
        for (int i = 0; i < 120; i++) {
            num = ThreadLocalRandom.current().nextInt(1, 20);
            assertTrue(num >= 1 && num <= 20);
        }
    }
}