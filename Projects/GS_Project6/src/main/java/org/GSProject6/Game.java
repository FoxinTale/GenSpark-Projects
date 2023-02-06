package org.GSProject6;

import java.util.concurrent.ThreadLocalRandom;

public class Game {
    static Human player = new Human(10, 10, Properties.playerHealth, 7, 7);

    public static void initiateCombat() {
        boolean continueCombat = true;
        Goblin enemy = World.findGoblinAtPlayerPosition();

        // Sanity check. Should never happen, but y'know, handle it anyways.
        if (enemy == null) {
            System.out.println("Combat failed due to there not being a goblin at this position.");
            return;
        }

        int[] initiative = rollInitiative();
        System.out.println(initiativeResult(initiative));

        while (continueCombat) {
            if (initiative[0] > initiative[1]) {
                System.out.println(enemy.attack(player));
                System.out.println(player.attack(enemy));
            } else {
                System.out.println(player.attack(enemy));
                System.out.println(enemy.attack(player));
            }
            if (player.isDead() || enemy.isDead()) {
                if (enemy.isDead()) {
                    System.out.println("The goblin has been slain.");

                    System.out.println(); // Separator.
                    if (!World.isBoardCleared()) {
                        World.removeGoblin(enemy);
                        World.printMainBoard();
                    } else {
                        System.out.println("You have cleared all the goblins from the map. Good job, exterminator.");
                    }
                }
                if (player.isDead()) {
                    System.out.println();
                    System.out.println("You have been slain, and the game is now over.");
                }
                continueCombat = false;
            }
        }
    }

    public static String initiativeResult(int[] initiative) {
        if (initiative[0] > initiative[1]) {
            return "Goblin rolled higher, therefore they attack first.";
        } else {
            return "You rolled higher initiative, therefore you go first.";
        }
    }

    public static int[] rollInitiative() {
        // To initiate combat, we first roll "initiative", and whoever is highest, goes first for the entire combat.

        int goblinInitiative = rollTwenty();
        int humanInitiative = rollTwenty();

        /*
            Usually, a dexterity bonus would be applied here but that was cut for simplification purposes, so we'll just roll again til they aren't equal.
            This is in a while instead of a single if due to there is a chance, even if it's a tiny chance that multiple rolls could be the same numbers.
            So we just keep going until they are not the same.
         */
        while (goblinInitiative == humanInitiative) {
            goblinInitiative = rollTwenty();
            humanInitiative = rollTwenty();
        }
        return new int[]{goblinInitiative, humanInitiative};
    }

    public static boolean validDirection(char c) {
        switch (c) {
            case 'n':
            case 'N':
            case 'e':
            case 'E':
            case 's':
            case 'S':
            case 'w':
            case 'W':
                return true;
            default:
                return false;
        }
    }

    // Re-wrote this to allow generic entity movement, so I can also move goblins with this method.
    public static boolean doMovement(String s, Entity e) {
        int entityX = e.getX();
        int entityY = e.getY();

        World.resetCharacter(entityX, entityY);

        switch (s) {
            case "n":
                if (moveCheck(entityX - 1)) {
                    e.setX(entityX - 1);
                    return true;
                }
                return false;
            case "e":
                if (moveCheck(entityY + 1)) {
                    e.setY(entityY + 1);
                    return true;
                }
                return false;
            case "s":
                if (moveCheck(entityX + 1)) {
                    e.setX(entityX + 1);
                    return true;
                }
                return false;
            case "w":
                if (moveCheck(entityY - 1)) {
                    e.setY(entityY - 1);
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public static boolean moveCheck(int newPos) {
        return newPos < 15 && newPos > -1;
    }

    public static String handleInput(String s) {
        String specialChars = "~`!@#$%^&*()_-+=[]{}|\\:;\"'<,.>?/";

        if (s.isEmpty() || s.isBlank()) {
            return "That's an empty space.";
        }
        try {
            if (Integer.parseInt(s) >= 0 || Integer.parseInt(s) <= 0) {
                return "That's a number, not a letter.";
            }
        } catch (NumberFormatException NFE) {
            if (s.length() > 1) {
                return "That has more than one character.";
            } else if (specialChars.contains(s)) {
                return "Special characters aren't a valid option here, sorry.";
            } else {
                if (validDirection(s.charAt(0))) {
                    return s;
                } else {
                    return "That's not a valid direction to go.";
                }
            }
        }
        return "Something went wrong.";
    }

    public static int rollFifteen() {
        return ThreadLocalRandom.current().nextInt(0, 15);
    }

    public static int rollTwenty() {
        return ThreadLocalRandom.current().nextInt(1, 20);
    }

    public static int rollEight() {
        return ThreadLocalRandom.current().nextInt(1, 8);
    }

    public static int rollSix() {
        return ThreadLocalRandom.current().nextInt(1, 6);
    }

    public static int rollFour() {
        return ThreadLocalRandom.current().nextInt(1, 4);
    }
}
