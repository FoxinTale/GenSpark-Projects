package org.GSProject6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/*
[ ] Goblin movement:
   [x] - Randomly generate or pick a direction.
   [x] - Check if that is a valid direction to move.
   [x] - Check if there is another goblin at that position.
   [ ] - Check if there is a player at that position, if so initiate combat.
   [ ] - If these checks pass (no goblin, and no player) then the goblins' position updates on the board.
   [x] - Actually update the goblins' position on the board.
*/
public class World extends Game {
    private static char[][] mainBoard = new char[15][15];
    private static ArrayList<Goblin> goblinList = new ArrayList<>();

    public static String pickDirection() {
        String[] directions = new String[]{"n", "e", "s", "w"};
        int choice = ThreadLocalRandom.current().nextInt(0, directions.length);

        return directions[choice];
    }

    public static void moveGoblins() {
        if (Properties.goblinsMove) {
            Goblin g;
            for (int i = 0; i < goblinList.size(); i++) {
                g = goblinList.get(i);
                //             System.out.println("Goblin position: " + g.getX() + " || " + g.getY() + " || " + i);
                //            System.out.println(goblinCollisionCheck(g.getX(), g.getY()));
                collisionCheck(g.getX(), g.getY());
           //     if (!goblinCollisionCheck(g.getX(), g.getY())) {
                    Game.doMovement(pickDirection(), g);
           //     }
            }
        }
    }

    public static void setupBoard() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                mainBoard[i][j] = 'x';
            }
        }
        placeGoblins();
        printMainBoard();
    }

    public static Goblin findGoblinAtPlayerPosition() {
        Goblin g;

        for (Goblin goblin : goblinList) {
            g = goblin;

            if (g.getX() == player.getX() && g.getY() == player.getY()) {
                return goblin;
            }
        }
        return null;
    }

    public static boolean isBoardCleared() {
        return goblinList.size() <= 1;
    }

    public static void placeGoblins() {
        int x = Game.rollFifteen();
        int y = Game.rollFifteen();

        for (int i = 0; i < Properties.goblinCount; i++) {
            if (x != 7 && y != 7) {
                goblinList.add(new Goblin(8, 11, 7, x, y));
            } else {
                i = -1;
            }
            x = Game.rollFifteen();
            y = Game.rollFifteen();
        }
    }

    public static void collisionCheck(int x, int y) {
        if (Game.moveCheck(x + 1) && mainBoard[x + 1][y] == 'G') {
            System.out.println("Goblin not clear to the east");
        }

        if (Game.moveCheck(x - 1) && mainBoard[x - 1][y] == 'G') {
            System.out.println("Goblin not clear to the north");
        }

        if (Game.moveCheck(y + 1) && mainBoard[x][y + 1] == 'G') {
            System.out.println("Goblin not clear to the north");
        }

        if (Game.moveCheck(y - 1) && mainBoard[x][y - 1] == 'G') {
            System.out.println("Goblin not clear to the south");
        }
    }

    public static boolean goblinCollisionCheck(int x, int y) {
        boolean xClear = true;
        boolean yClear = true;
        if (Game.moveCheck(x)) {
            if (mainBoard[x + 1][y] == 'G' || mainBoard[x - 1][y] == 'G') {
                xClear = false;
            }

        }

        if (Game.moveCheck(y)) {
            if (mainBoard[x][y + 1] == 'G' || mainBoard[x][y - 1] == 'G') {
                yClear = false;
            }
        }


        if (xClear && yClear) {
            return false;
        } else {
            return true;
        }
    }

    public static void removeGoblin(Goblin g) {
        goblinList.remove(g);
    }

    public static void setPositions() {
        playerGoblinCheck();
        mainBoard[player.getX()][player.getY()] = 'O';

        for (Goblin goblin : goblinList) {
            mainBoard[goblin.getX()][goblin.getY()] = 'G';
        }
    }

    public static boolean playerGoblinCheck() {
        return mainBoard[player.getX()][player.getY()] == 'G';
    }

    public static void resetCharacter(int x, int y) {
        mainBoard[x][y] = 'x';
    }

    public static void printMainBoard() {
        setPositions();
        for (int i = 0; i < 15; i++) {
            System.out.println(Arrays.toString(mainBoard[i]).replace(",", ""));
        }
    }

    @Override // I can't exactly return the world as it is a 2d array. Look at the function above.
    public String toString() {
        StringBuilder worldSB = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            worldSB.append(Arrays.toString(mainBoard[i]).replace(",", "") + "\n");
        }
        return worldSB.toString();
    }
}
