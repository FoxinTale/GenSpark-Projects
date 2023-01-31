package org.GSProject6;

import java.util.ArrayList;
import java.util.Arrays;

public class World extends Game {
    private static char[][] mainBoard = new char[15][15];
    private static ArrayList<Goblin> goblinList = new ArrayList<>();

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

        for (int i = 0; i < goblinList.size(); i++) {
            g = goblinList.get(i);

            if (g.getX() == player.getX() && g.getY() == player.getY()) {
                return goblinList.get(i);
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

    public static boolean goblinCollisionCheck(int x, int y){
        return mainBoard[x][y] == 'G';
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
        return "The entire world itself!";
    }
}
