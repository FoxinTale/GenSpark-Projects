package org.GSProject6;

import org.GSProject6.GUI.CustomOutputStream;
import org.GSProject6.GUI.GUI;

import java.io.PrintStream;

/*
This appears to be a text based humans versus goblins "game", and the word for word description is as follows:
Key: [x] = complete || [~] = not implemented or cut || [-] = in progress.
-[x] Everything needs to be an object. Land, Humans, Goblins
-[x] The toString of each object must be over-ridden to represent each object. (?)
-[x] A grid of the game world must be created.
-[x] UTF characters must be used to represent the player(s), goblins and land.
-[x] The game is turn based moves (N/S/E/W)
-[x] Once a human and goblin collide (are on the same square / grid space) combat initiates.
        (collision detection is implemented, combat in progress)
-[x] Combat uses math.random. [Well, sort of. It uses ThreadLocalRandom which is so much better]

- Extras:
-[ ]  Humans have an inventory system.
-[~]  Goblins have drops.
-[ ]  Stats can be modified by equipment.
-[~]  "Map gen random treasure chest after each round of combat".
-[~]  Goblins pursue player.

- And of course, unit testing is required.
 */

/*
I wrote this as a simplified, text based version of Dungeons and Dragons more or less. So, I utilise rules and mechanics from D&D 5th edition.

To do for minimum functionality:
- [x] Combat System:
    -[x] Track which goblin is being attacked, or figure it out.
    -[x] Goblin hp zero or less detection, during combat.
    -[x] Figure out how to remove a dead goblin from the map.
    -[x] Along those lines, figure out how to handle player death (hp zero or less). Game will end, but how would we detect this.
    -[x] Human combat system implementation (It's pretty similar to goblin combat).
    -[x] Loop the combat system so that it occurs til one or the other dies.

- [] Other (Not essential, but adds to the game)
    -[-] Goblins randomly move around the map every turn, make it look like they are roaming around. We're not doing "hunt down the player",
            As roaming goblins seems enough of a challenge to me.
    -[o] Handle goblin-goblin collision. (ideally prevent it).
    -[] Make sure only one goblin at a time can attack. Keep multiple ones away from the player.


"Map gen random treasure chest after each round of combat" and "Goblins have drops."
    I decided not to do these because that just is not how D&D works, which is how I built this to function like.
    You don't get rewarded to the extreme for minor combat, only major boss encounters. And these are goblins, not a boss dragon at the end of its cave.
    So, the best reward you're getting out of this is experience points (XP) and any minor loot they may have on them...which since they're low level enemies, isn't much.

 */
public class Main {

    private static PrintStream standardOut; // This sets the outputs.

    public static void main(String[] args) {
        // Casually re-directing all System.out calls to the GUI text window.
  //      PrintStream printStream = new PrintStream(new CustomOutputStream(GUI.consoleOutput));
  //      standardOut = System.out;
  //      System.setOut(printStream);
   //     System.setErr(printStream);

        GUI.launchGUI();
        System.out.println(" Welcome to a rudimentary, text based version of D & D.");
        System.out.println(" An x represents an open space, a G represents a Goblin, \n   and an O represents your character.");
        System.out.println(" Use the arrow buttons below to move around.");
        System.out.println();
        System.out.println(" Combat is majorly automatic here.");

        boolean runGame = true;


        while(runGame){
            if (Game.getPlayer().isDead() || World.isBoardCleared()) {
                System.out.println(" The game is now over.");
                GUI.disableControls();
                runGame = false;
            }
        }



        /*
        boolean runGame = true;

        World.setupBoard();

     //   Scanner sc = new Scanner(System.in);

        while (runGame) {
            String result = Game.handleInput(sc.next());
            if (result.length() == 1) {
                if (Game.doMovement(result, Game.player)) {
                    if (!World.playerGoblinCheck()) {
                        World.moveGoblins();
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

        }

         */
    }
}