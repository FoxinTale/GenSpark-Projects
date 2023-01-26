package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Game {
    static Human player = new Human(10, 10, 12, 7, 7);

    public static void initiateCombat() {
        boolean continueCombat = true;
        // To initiate combat, we first roll "initiative", and whoever is highest, goes first for the entire combat.
        int goblinInitiative = rollTwenty();
        int humanInitiative = rollTwenty();
        int damage = 0;

        Goblin enemy = World.findGoblinAtPlayerPosition();

        // Sanity check. Should never happen, but y'know, handle it anyways.
        if (enemy == null) {
            System.out.println("Combat failed due to there not being a goblin at this position.");
            return;
        }
        /*
            Usually, a dexterity bonus would be applied here but that was cut for simplification purposes, so we'll just roll again.
            This is in a while instead of a single if due to there is a chance, even if it's a tiny chance that multiple rolls could be the same numbers.
            So we just keep going until they are not the same.
         */
        while (goblinInitiative == humanInitiative) {
            goblinInitiative = rollTwenty();
            humanInitiative = rollTwenty();
        }
//        System.out.println(humanInitiative + "  ||  " + goblinInitiative);
        while (continueCombat) {
            if (goblinInitiative > humanInitiative) {
                // Goblin goes first.
                if (rollTwenty() < player.getArmourClass()) {
                    /*
                    D & D has this mechanic called "Armour Class" (AC). At its most basic level, this is determined by the type of armour the character is wearing.
                    Bonuses, can of course be applied as well. How this works, is when an attack is made, a d20 is rolled. If the number is lower than the entity's AC,
                    the attack fails. If it is equal to or greater than the AC, the attack lands and a damage roll is done which the amount is weapon-dependent.
                     */
                    System.out.println("The goblin attacked, but it did no damage.");
                } else {
                    // Goblin attacks.
                    damage = rollFour(); // this is based off of a wooden club, which does 1d4 damage, hence the rollFour()

                    if(damage == 1){
                        System.out.println("The goblin attacked for one whole damage.");
                    } else {
                        System.out.println("The goblin attacked for " + damage + " damage.");
                    }
                    player.setHitPoints(player.getHitPoints() - damage);
                    int playerHP = player.getHitPoints();
                    if(playerHP > 0){
                        System.out.println("You now have " + playerHP + " hit points.");
                    } else {
                        System.out.println("You now have 0 hit points.");
                    }
                }
            } else {
                // Human goes first.
                if (rollTwenty() < enemy.getArmourClass()) {
                    System.out.println("You attacked the goblin, but it did no damage.");
                } else {
                    // Player attacks.
                    damage = rollSix(); // This is based off a Rapier, which does 1d6 damage.
                    if(damage == 1){
                        System.out.println("You attacked the goblin for one whole damage.");
                    } else {
                        System.out.println("You attacked for " + damage + " damage.");
                    }
                    enemy.setHitPoints(enemy.getHitPoints() - damage);
                }
            }
            if (player.getHitPoints() <= 0 || enemy.getHitPoints() <= 0) {
                if (enemy.getHitPoints() <= 0) {
                    System.out.println("The goblin has been slain.");

                    System.out.println();
                //    World.removeGoblin(enemy.getX(), enemy.getY());
                    World.removeGoblin(enemy);
  //                  World.setBoardPosition(enemy.getX(), enemy.getY(), 'x');
                    World.printMainBoard();
                }

                if(player.getHitPoints() <= 0){
                    System.out.println();
                    System.out.println("You have been slain, and the game is now over.");
                }
                continueCombat = false;
            }
        }
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

    public static boolean playerMoves(String s) {
        int playerX = player.getX();
        int playerY = player.getY();
        World.resetCharacter(playerX, playerY);

        switch (s) {
            case "n":
                if (moveCheck(playerX - 1)) {
                    player.setX(playerX - 1);
                    return true;
                }
                return false;
            case "e":
                if (moveCheck(playerY + 1)) {
                    player.setY(playerY + 1);
                    return true;
                }
                return false;
            case "s":
                if (moveCheck(playerX + 1)) {
                    player.setX(playerX + 1);
                    return true;
                }
                return false;
            case "w":
                if (moveCheck(playerY - 1)) {
                    player.setY(playerY - 1);
                    return true;
                }
                return false;
            default:
                return false;
        }

    }

    public static boolean moveCheck(int newPos) {
        if (newPos < 15 && newPos > -1) {
            return true;
        }
        return false;
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
