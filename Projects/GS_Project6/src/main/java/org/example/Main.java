package org.example;

import java.util.Arrays;
import java.util.Scanner;

/*
This appears to be a text based humans versus goblins "game".

-[x] Everything needs to be an object. Land, Humans, Goblins
-[x] The toString of each object must be over-ridden to represent each object. (?)
-[x] A grid of the game world must be created.
-[x] UTF characters must be used to represent the player(s), goblins and land.
-[x] The game is turn based moves (N/S/E/W)
-[x] Once a human and goblin collide (are on the same square / grid space) combat initiates.
        (collision detection is implemented, combat in progress)
-[x] Combat uses math.random.

- Extras:
-[ ]  Humans have an inventory system.
-[ ]  Goblins have drops.
-[ ]  Stats can be modified by equipment.
-[ ]  "Map gen random treasure chest after each round of combat".
-[ ]  Goblins pursue player.

- And of course, unit testing is required.
 */

/*
To do for minimum functionality:
- [x] Combat System:
    -[x] Track which goblin is being attacked, or figure it out.
    -[x] Goblin hp zero or less detection, during combat.
    -[x] Figure out how to remove a dead goblin from the map.
    -[x] Along those lines, figure out how to handle player death (hp zero or less). Game will end, but how would we detect this.
    -[x] Human combat system implementation (It's pretty similar to goblin combat).
    -[x] Loop the combat system so that it occurs til one or the other dies.

- [] Other
    -[] Goblins randomly move around the map every turn, make it look like they are roaming around. We're not doing "hunt down the player".
    -[] Handle goblin-goblin collision. (ideally prevent it).
    -[] Make sure only one goblin at a time can attack. Keep multiple ones away from the player.


 */
public class Main {
    public static void main(String[] args) {
        boolean runGame = true;
        System.out.println("Welcome to a rudimentary, text based version of D & D.");
        System.out.println("An x represents an open space, a G represents a Goblin, and an O represents your character.");
        System.out.println("Type n, s, e, or w (case insensitive) to move around.");
        System.out.println();
        World.setupBoard();

        Scanner sc = new Scanner(System.in);

        while(runGame){
            String result = Game.handleInput(sc.next());
            if(result.length() == 1){
                if(Game.playerMoves(result)){
                    if(!World.playerGoblinCheck()){
                        World.printMainBoard();
                    } else {
                        System.out.println("Combat initiate!");
                        Game.initiateCombat();
                    }
                } else {
                    System.out.println("You cannot go any further.");
                }
            } else {
                System.out.println(result);
            }
            if(Game.player.getHitPoints() <= 0){
                runGame = false;
            }
        }
    }
}