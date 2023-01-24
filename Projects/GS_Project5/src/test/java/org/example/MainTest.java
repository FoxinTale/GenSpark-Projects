package org.example;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @org.junit.jupiter.api.Test
    void checkWin() {
        // I wrote this with my cat on my lap...That was the inspiration.
        // This is for if the words equal each other
        assertTrue(Main.checkWin(new char[]{'d', 'o', 'i', 'n', 'g'}, new char[]{'d', 'o', 'i', 'n', 'g'}));
        assertTrue(Main.checkWin(new char[]{'u', 'n', 'i', 't'}, new char[]{'u', 'n', 'i', 't'}));
        assertTrue(Main.checkWin(new char[]{'t', 'e', 's', 't', 'i', 'n', 'g'}, new char[]{'t', 'e', 's', 't', 'i', 'n', 'g'}));
        assertTrue(Main.checkWin(new char[]{'w', 'i', 't', 'h'}, new char[]{'w', 'i', 't', 'h'}));
        assertTrue(Main.checkWin(new char[]{'c', 'a', 't'}, new char[]{'c', 'a', 't'}));

        // This is for if the words do not equal each other.
        assertFalse(Main.checkWin(new char[]{'a'}, new char[]{'u'}));
        assertFalse(Main.checkWin(new char[]{'s', 't', 'u', 'f', 'f'}, new char[]{'t', 'h', 'i', 'n', 'g', 's'}));
        assertFalse(Main.checkWin(new char[]{'w', 'h', 'a', 't'}, new char[]{'w', 'h', 'e', 'r', 'e'}));
        assertFalse(Main.checkWin(new char[]{'w', 'h', 'o'}, new char[]{'w', 'h', 'y'}));
        assertFalse(Main.checkWin(new char[]{'='}, new char[]{'-'}));
    }


    @org.junit.jupiter.api.Test
        // This one is more or less making sure that we do have a word to use, and it's not just an empty string.
    void generateWord() {
        for (int i = 0; i < 20; i++) {
            assertNotEquals("", Main.generateWord());
        }
    }


    @org.junit.jupiter.api.Test
    void printStage() {
        assertEquals("", Main.printStage(-1));
        assertEquals("_ ___", Main.printStage(0));
        assertEquals(" |\n" + " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + "_|___", Main.printStage(1));
        assertEquals(" ___________\n" + " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + "_|___", Main.printStage(2));
        assertEquals(" ___________\n" + " |/\n" + " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + "_|___", Main.printStage(3));
        assertEquals(" ___________\n" + " |/      |\n" + " |\n" + " |\n" + " |\n" + " |\n" + " |\n" + "_|___", Main.printStage(4));
        assertEquals(" ___________\n" + " |/      |\n" + " |      (_)\n" + " |\n" + " |\n" + " |\n" + " |\n" + "_|___\n", Main.printStage(5));
        assertEquals(" ___________\n" + " |/      |\n" + " |      (_)\n" + " |       |\n" + " |       |\n" + " |\n" + " |\n" + "_|___", Main.printStage(6));
        assertEquals(" ___________\n" + " |/      |\n" + " |      (_)\n" + " |       |\n" + " |       |\n" + " |      /\n" + " |\n" + "_|___", Main.printStage(7));
        assertEquals(" ___________\n" + " |/      |\n" + " |      (_)\n" + " |       |\n" + " |       |\n" + " |      / \\\n" + " |\n" + "_|___", Main.printStage(8));
        assertEquals(" ___________\n" + " |/      |\n" + " |      (_)\n" + " |      \\|\n" + " |       |\n" + " |      / \\\n" + " |\n" + "_|___", Main.printStage(9));
        assertEquals(" ___________\n" + " |/      |\n" + " |      (_)\n" + " |      \\|/\n" + " |       |\n" + " |      / \\\n" + " |\n" + "_|___", Main.printStage(10));
        assertEquals("", Main.printStage(11));
        assertEquals("", Main.printStage(20));
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