package org.GSProject6;
// Basic game options. In case someone wishes to change the properties, or when it's GUI time, an options menu.
// I could also put these into a file that is read as well, but for this project, this way works just fine for now.

public class Properties {
    public static int goblinCount = 3; // Amount of goblins to spawn. Default is 3.
    public static int playerHealth = 12; // Player's starting HP. Default is 12.
    public static boolean goblinsMove = true; // Whether goblins move around between turns (free-roaming), or stand still.
        // Note, this will move all the active goblins, and not just one or a few.

}
