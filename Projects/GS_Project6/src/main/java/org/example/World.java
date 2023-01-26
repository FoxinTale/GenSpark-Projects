package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class World extends Game {
    public static char[][] mainBoard = new char[15][15];
    public static Goblin[] goblins = new Goblin[3];
    public static ArrayList<Goblin> goblinList = new ArrayList<>();

    public static void setBoardPosition(int x, int y, char c) {
        mainBoard[x][y] = c;
    }

    public static void setupBoard() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                mainBoard[i][j] = 'x';
            }
        }
    }


    public static Goblin findGoblinAtPlayerPosition() {
        Goblin g;

        for(int i =0; i < goblinList.size(); i++){
            g = goblinList.get(i);

            if (g.getX() == player.getX() && g.getY() == player.getY()) {
                return goblinList.get(i);
            }
        }

        /*
        for (int i = 0; i < goblins.length; i++) {
            g = goblins[i];
            if (g.getX() == player.getX() && g.getY() == player.getY()) {
                return goblins[i];
            }
        }
         */
        return null;
    }

    public static void placeGoblins() {
        int x = Game.rollFifteen();
        int y = Game.rollFifteen();


        for (int i = 0; i < 3; i++) {
            if (x != 7 && y != 7) {
                goblinList.add(new Goblin(8, 11, 7, x, y));
                //               goblins[i] = new Goblin(8, 11, 7, x, y);
            } else {
                i = -1;
            }
            x = Game.rollFifteen();
            y = Game.rollFifteen();
        }
    }

    public static void removeGoblin(Goblin g/*int x, int y */){
        goblinList.remove(g);
        /*
        Goblin g;
        for(int i =0; i < goblinList.size(); i++){
            g = goblinList.get(i);

            if (g.getX() == x && g.getY() ==y) {
                goblinList.remove(i);
            }
        }

         */
    }

    public static void setPositions() {
     //   goblinList.
        playerGoblinCheck();
        mainBoard[player.getX()][player.getY()] = 'O';

        for (int i = 0; i < goblinList.size(); i++) {
            //           mainBoard[goblins[i].getX()][goblins[i].getY()] = 'G';
            mainBoard[goblinList.get(i).getX()][goblinList.get(i).getY()] = 'G';
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

    @Override
    public String toString() {
        return "The entire world itself!";
    }
}
