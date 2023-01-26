package org.example;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @org.junit.jupiter.api.Test
    void handleInput() {
        //Empty spaces
        assertEquals("That's an empty space.", Game.handleInput(""));
        assertEquals("That's an empty space.", Game.handleInput("\t"));
        assertEquals("That's an empty space.", Game.handleInput("\n"));
        assertEquals("That's an empty space.", Game.handleInput(" "));
        assertEquals("That's an empty space.", Game.handleInput("           "));

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
        assertEquals("Special characters aren't a valid option here, sorry.", Game.handleInput("!"));
        assertEquals("Special characters aren't a valid option here, sorry.", Game.handleInput("&"));
        assertEquals("Special characters aren't a valid option here, sorry.", Game.handleInput("\\"));
        assertEquals("Special characters aren't a valid option here, sorry.", Game.handleInput("?"));
        assertEquals("Special characters aren't a valid option here, sorry.", Game.handleInput(","));

        assertEquals("That's not a valid direction to go.", Game.handleInput("a"));
        assertEquals("That's not a valid direction to go.", Game.handleInput("d"));

        // Valid inputs.
        assertEquals("n", Game.handleInput("n"));
        assertEquals("N", Game.handleInput("N"));
        assertEquals("e", Game.handleInput("e"));
        assertEquals("E", Game.handleInput("E"));
        assertEquals("s", Game.handleInput("s"));
        assertEquals("S", Game.handleInput("S"));
        assertEquals("w", Game.handleInput("w"));
        assertEquals("W", Game.handleInput("W"));

    }

    @org.junit.jupiter.api.Test
    void moveCheck(){
        // Valid values.
        for(int i =0; i < 15; i++){
            assertTrue(Game.moveCheck(i));
        }

        assertFalse(Game.moveCheck(-10128));
        assertFalse(Game.moveCheck(-10));
        assertFalse(Game.moveCheck(-1));

        assertFalse(Game.moveCheck(16));
        assertFalse(Game.moveCheck(245));
        assertFalse(Game.moveCheck(23456));
    }

    // While this function is in fact part of the previous function, "handleInput", but it doesn't hurt to test this on its own.
    @org.junit.jupiter.api.Test
    void validDirection(){
        assertTrue(Game.validDirection('n'));
        assertTrue(Game.validDirection('N'));
        assertTrue(Game.validDirection('e'));
        assertTrue(Game.validDirection('E'));
        assertTrue(Game.validDirection('s'));
        assertTrue(Game.validDirection('S'));
        assertTrue(Game.validDirection('w'));
        assertTrue(Game.validDirection('W'));

        assertFalse(Game.validDirection('a'));
        assertFalse(Game.validDirection('A'));
        assertFalse(Game.validDirection('b'));
        assertFalse(Game.validDirection('B'));

        //Now, these should never happen as they are already checked for in the "handleInput()", but better be safe and check it anyways.
        assertFalse(Game.validDirection('\n'));
        assertFalse(Game.validDirection('^'));
        assertFalse(Game.validDirection('#'));
        assertFalse(Game.validDirection('1'));
        assertFalse(Game.validDirection('\t'));
        assertFalse(Game.validDirection(' '));
        assertFalse(Game.validDirection('6'));
    }


    // Checking that randomness, is in fact random and will fall within the range we need.
    @org.junit.jupiter.api.Test
    void rollFifteen() {
        int num = 0;
        for (int i = 0; i < 120; i++) {
            num = Game.rollFifteen();
            assertTrue(num >= 0 && num <= 15);
        }
    }

    @org.junit.jupiter.api.Test
    void rollFour() {
        int num = 0;
        for (int i = 0; i < 120; i++) {
            num = Game.rollFour();
            assertTrue(num >= 1 && num <= 4);
        }
    }

    @org.junit.jupiter.api.Test
    void rollTwenty() {
        int num = 0;
        for (int i = 0; i < 120; i++) {
            num = Game.rollTwenty();
            assertTrue(num >= 1 && num <= 20);
        }
    }

    @org.junit.jupiter.api.Test
    void rollSix() {
        int num = 0;
        for (int i = 0; i < 120; i++) {
            num = Game.rollSix();
            assertTrue(num >= 1 && num <= 6);
        }
    }

    @org.junit.jupiter.api.Test
    void rollEight() {
        int num = 0;
        for (int i = 0; i < 120; i++) {
            num = Game.rollEight();
            assertTrue(num >= 1 && num <= 8);
        }
    }
}
