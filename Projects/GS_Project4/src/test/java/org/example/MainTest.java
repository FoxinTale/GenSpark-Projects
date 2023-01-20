package org.example;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void dragonGame() {
        assertEquals("Well that didn't go as planned.", Main.gameOutput("1"));
        assertEquals("Well that didn't go as planned.", Main.gameOutput("1"));

        assertEquals("Hey, I'm rich and friends with a freaking dragon.", Main.gameOutput("2"));
        assertEquals("Hey, I'm rich and friends with a freaking dragon.", Main.gameOutput("2"));

        assertEquals("", Main.gameOutput("3"));
        assertEquals("", Main.gameOutput("aaa"));
        assertEquals("", Main.gameOutput("6789"));
        assertEquals("", Main.gameOutput("\n"));
    }

    @org.junit.jupiter.api.Test
    void numberGame(){
        /*
        Test randomness.

         */
        // Check that randomness does in fact fall between 1 and 20. It should.
        int num = 0;
        for(int i = 0; i < 120; i ++){
            num = Main.randomNumber();
            assertTrue(num >= 1 && num <= 20);
        }


        // Out of range in the less than one tests.
        assertEquals(Main.outOfRange, Main.validateInput(-14));
        assertEquals(Main.outOfRange, Main.validateInput(0));
        assertEquals(Main.outOfRange, Main.validateInput(-101));
        assertEquals(Main.outOfRange, Main.validateInput(-23142));
        assertEquals(Main.outOfRange, Main.validateInput(-1));

        // Out of range in the grater than 20 tests.
        assertEquals(Main.outOfRange, Main.validateInput(6387));
        assertEquals(Main.outOfRange, Main.validateInput(500));
        assertEquals(Main.outOfRange, Main.validateInput(26));
        assertEquals(Main.outOfRange, Main.validateInput(325234));
        assertEquals(Main.outOfRange, Main.validateInput(42));

        // In range tests.
        assertEquals("", Main.validateInput(15));
        assertEquals("", Main.validateInput(1));
        assertEquals("", Main.validateInput(6));
        assertEquals("", Main.validateInput(8));
        assertEquals("", Main.validateInput(20));

        // Non numeric input tests.
        try {
            assertEquals(Main.notANumber, Main.validateInput(Integer.parseInt("aaaa")));
            assertEquals(Main.notANumber, Main.validateInput(Integer.parseInt("\n")));
            assertEquals(Main.notANumber, Main.validateInput(Integer.parseInt("*")));
            assertEquals(Main.notANumber, Main.validateInput(Integer.parseInt("&")));
            assertEquals(Main.notANumber, Main.validateInput(Integer.parseInt(";")));
        } catch (NumberFormatException nfe) {

        }

        // I'd consider input validation significantly tested now.


        // Number checking:  Correct answer.
        assertEquals(Main.valueCheck(20, 20),  Main.correctAnswer);
        assertEquals(Main.valueCheck(15, 15),  Main.correctAnswer);
        assertEquals(Main.valueCheck(1, 1),  Main.correctAnswer);
        assertEquals(Main.valueCheck(4, 4),  Main.correctAnswer);
        assertEquals(Main.valueCheck(13, 13),  Main.correctAnswer);

        // Number Checking:  Input too low.
        assertEquals(Main.valueCheck(12, 20), Main.answerTooLow);
        assertEquals(Main.valueCheck(5, 15), Main.answerTooLow);
        assertEquals(Main.valueCheck(1, 7), Main.answerTooLow);
        assertEquals(Main.valueCheck(3, 13), Main.answerTooLow);
        assertEquals(Main.valueCheck(2, 7), Main.answerTooLow);

        // Number checking: Answer too high.
        assertEquals(Main.valueCheck(5, 1), Main.answerTooHigh);
        assertEquals(Main.valueCheck(20, 12), Main.answerTooHigh);
        assertEquals(Main.valueCheck(6, 2), Main.answerTooHigh);
        assertEquals(Main.valueCheck(15, 10), Main.answerTooHigh);
        assertEquals(Main.valueCheck(18, 17), Main.answerTooHigh);
    }
}