package org.GSProject6.GUI;

import org.GSProject6.Game;
import org.GSProject6.Properties;
import org.GSProject6.World;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI {
    public static JTextArea consoleOutput = new JTextArea();
    static JScrollPane scroll = new JScrollPane(consoleOutput);
    public static JLabel[][] boxes;
    public static JProgressBar playerHP = new JProgressBar();

    public static JLabel playerHPText = new JLabel();

    private static final JButton up = new JButton("^");
    private static final JButton right = new JButton(">");
    private static final JButton down = new JButton("v");
    private static final JButton left = new JButton("<");

    public static void launchGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        boxes = new JLabel[15][15];
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Humans Versus Goblins - GUI Edition");

        JLabel playerHPLabel = new JLabel("Player HP: ");

        fillGridBoxes();

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBorder(new LineBorder(Color.black, 1, true));

        Color greyOne = new Color(200, 200, 200);

        JPanel mainPanel = new RoundedPanel(10, greyOne);

        ActionListener movementButtonEvent = ae -> {
            AbstractButton button = (AbstractButton) ae.getSource();
            String directionText = button.getText();

            switch (directionText) {
                case "^":
                    Game.movement("n");
                    break;
                case ">":
                    Game.movement("e");
                    break;
                case "v":
                    Game.movement("s");
                    break;
                case "<":
                    Game.movement("w");
                    break;
                default:
                    break;
            }
        };

        up.addActionListener(movementButtonEvent);
        right.addActionListener(movementButtonEvent);
        down.addActionListener(movementButtonEvent);
        left.addActionListener(movementButtonEvent);


        // setting positions and size of elements.
        mainPanel.setBounds(10, 10, 770, 350);
        playerHPLabel.setBounds(25, 380, 100, 25);
        playerHP.setBounds(100, 380, 175, 25);
        playerHPText.setBounds(150, 380, 100, 25);

        up.setBounds(525, 390, 50, 50);
        right.setBounds(580, 445, 50, 50);
        down.setBounds(525, 500, 50, 50);
        left.setBounds(470, 445, 50, 50);

        scroll.setBounds(350, 15, 420, 340);
        consoleOutput.setEditable( false);

        playerHP.setMaximum(Properties.playerHealth);
        playerHP.setValue(Properties.playerHealth);

        int x = 30;

        for (int i = 0; i < 15; i++) {
            boxes[0][i].setBounds(x, 20, 20, 20);
            boxes[1][i].setBounds(x, 40, 20, 20);
            boxes[2][i].setBounds(x, 60, 20, 20);
            boxes[3][i].setBounds(x, 80, 20, 20);
            boxes[4][i].setBounds(x, 100, 20, 20);
            boxes[5][i].setBounds(x, 120, 20, 20);
            boxes[6][i].setBounds(x, 140, 20, 20);
            boxes[7][i].setBounds(x, 160, 20, 20);
            boxes[8][i].setBounds(x, 180, 20, 20);
            boxes[9][i].setBounds(x, 200, 20, 20);
            boxes[10][i].setBounds(x, 220, 20, 20);
            boxes[11][i].setBounds(x, 240, 20, 20);
            boxes[12][i].setBounds(x, 260, 20, 20);
            boxes[13][i].setBounds(x, 280, 20, 20);
            boxes[14][i].setBounds(x, 300, 20, 20);

            for (int j = 0; j < 15; j++) {
                frame.add(boxes[i][j]);  //frame.add(boxes[j][i]);
            }
            x += 20;
        }

        World.placeGoblins();
        World.setPositions();

        //Adding elements to the window.
        frame.add(scroll);

        frame.add(playerHPLabel);
        frame.add(playerHPText);
        frame.add(playerHP);
        frame.add(up);
        frame.add(right);
        frame.add(down);
        frame.add(left);
        frame.add(mainPanel);

        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLayout(null);// using no layout managers
        frame.setVisible(true);// making the frame visible
    }



    public static void updateBoard(){
        boxes[Game.getPlayer().getX()][Game.getPlayer().getY()].setText("O");
    }

    public static void disableControls(){
        up.setEnabled(false);
        right.setEnabled(false);
        down.setEnabled(false);
        left.setEnabled(false);
    }

    public static void fillGridBoxes() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                boxes[i][j] = new JLabel("x");
            }
        }
    }
}
