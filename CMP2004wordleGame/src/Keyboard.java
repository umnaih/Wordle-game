import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Keyboard extends JFrame {


    public static long getStartTime() {
        return System.nanoTime();
    }


    public static int getCount1key() {
        return count1keyboard;
    }

    public static int getCount2key() {
        return count2keyboard;
    }


    public static int getPlayerCount() {
        return playerCount;
    }
 
    public static boolean isKeyboardopen() {
        return isKeyboardopen;
    }

    public static void setKeyboardopen(boolean isKeyboardopen) {
        isKeyboardopen = isKeyboardopen;
    }
    static long finishTime;
    static long startTime = getStartTime();
    static int count1keyboard = 0;
    static int count2keyboard = 0;
    static int playerCount = 1;
    boolean p1Turn = true;
    Color newGreen = new Color(107, 170, 100);
    WordBase wordBase = new WordBase();
    String target = wordBase.setWord();
    int player1Tries = 0;
    int player2Tries = 0;
    static boolean isKeyboardopen=false;

    public Keyboard(PlayerParent p1) {
        Checks check = new Checks(target, this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel[] attempt1 = new JLabel[5];
        JLabel[] attempt2 = new JLabel[5];
        JLabel[] attempt3 = new JLabel[5];
        JLabel[] attempt4 = new JLabel[5];
        JLabel[] attempt5 = new JLabel[5];
        JLabel title;
        isKeyboardopen=true;
        JPanel pnlButton; //for  buttons and text box
        JPanel game; //for the 25 labels
        JPanel left, right, north;

        JButton submit;
        JTextField txt;

        BorderLayout bl;

        System.out.println(target);
        setSize(700, 800);
        setTitle("Wordle Game");

        bl = new BorderLayout();
        setLayout(bl);

        pnlButton = new JPanel();
        pnlButton.setBackground(Color.white);

        txt = new JTextField();
        txt.setFont(new Font("Calibri", Font.BOLD, 40));
        txt.setHorizontalAlignment(JTextField.CENTER);

        submit = new JButton("Submit");
        submit.setBackground(newGreen);
        submit.setForeground(Color.white);
        submit.setPreferredSize(new Dimension(100, 50));

        pnlButton.add(txt);
        txt.setPreferredSize(new Dimension(400, 50));
        pnlButton.add(submit);

        add(pnlButton, BorderLayout.SOUTH);

        //Center Panel gui

        game = new JPanel(new GridLayout(6, 5));
        game.setBackground(Color.white);
        Border border = BorderFactory.createLineBorder(Color.white);
        for (int i = 0; i < attempt1.length; i++) {
            attempt1[i] = new JLabel();
            attempt1[i].setFont(new Font("Calibri", Font.BOLD, 40));
            attempt1[i].setOpaque(true);
            attempt1[i].setBorder(border);
            attempt1[i].setHorizontalAlignment(JLabel.CENTER);
            game.add(attempt1[i]);
        }

        for (int i = 0; i < attempt2.length; i++) {
            attempt2[i] = new JLabel();
            attempt2[i].setOpaque(true);
            attempt2[i].setBorder(border);
            attempt2[i].setHorizontalAlignment(JLabel.CENTER);
            attempt2[i].setFont(new Font("Calibri", Font.BOLD, 40));
            game.add(attempt2[i]);
        }

        for (int i = 0; i < attempt3.length; i++) {
            attempt3[i] = new JLabel();
            attempt3[i].setOpaque(true);
            attempt3[i].setBorder(border);
            attempt3[i].setHorizontalAlignment(JLabel.CENTER);
            attempt3[i].setFont(new Font("Calibri", Font.BOLD, 40));
            game.add(attempt3[i]);
        }

        for (int i = 0; i < attempt4.length; i++) {
            attempt4[i] = new JLabel();
            attempt4[i].setOpaque(true);
            attempt4[i].setBorder(border);
            attempt4[i].setHorizontalAlignment(JLabel.CENTER);
            attempt4[i].setFont(new Font("Calibri", Font.BOLD, 40));
            game.add(attempt4[i]);
        }

        for (int i = 0; i < attempt5.length; i++) {
            attempt5[i] = new JLabel();
            attempt5[i].setOpaque(true);
            attempt5[i].setBorder(border);
            attempt5[i].setHorizontalAlignment(JLabel.CENTER);
            attempt5[i].setFont(new Font("Calibri", Font.BOLD, 40));
            game.add(attempt5[i]);
        }

        left = new JPanel();
        left.setBackground(Color.white);
        right = new JPanel();
        right.setBackground(Color.white);

        title = new JLabel("Wordle Game");
        title.setFont(new Font("Calibri", Font.BOLD, 30));
        north = new JPanel();
        north.add(title);
        north.setBackground(Color.white);

        add(left, BorderLayout.WEST);
        add(right, BorderLayout.EAST);
        add(north, BorderLayout.NORTH);
        add(game, BorderLayout.CENTER);

        submit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (!(txt.getText().matches("[A-Za-z]{5}"))) { // Makes sure the guess is 5 letters only
                    JOptionPane.showMessageDialog(pnlButton, "please enter only 5 letters, no digits or spaces",
                            "Invalid word", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (wordBase.isMeaningful(txt.getText())) { // checks if guess is in our word database, this is missing in player 2 mouse listener
                        p1.setPlayerGuess(txt.getText());
                        if (e.getSource() == submit) {
                            count1keyboard++;
                            if (count1keyboard == 1) {
                                for (int m = 0; m < target.length(); m++) {
                                    attempt1[m].setText(String.valueOf(p1.getPlayerGuess().charAt(m)));
                                }
                                txt.setText("");
                                //System.out.println(getDuration()/1000000000);
                                check.checkWord(attempt1, p1.getPlayerGuess());
                                check.gameCheckKeyboard(p1.getPlayerGuess(), playerCount); // checks if the player guessed the correct word
                            } else if (count1keyboard == 2) {
                                for (int m = 0; m < target.length(); m++) {
                                    attempt2[m].setText(String.valueOf(p1.getPlayerGuess().charAt(m)));
                                }
                                txt.setText("");
                                check.checkWord(attempt2, p1.getPlayerGuess());
                                check.gameCheckKeyboard(p1.getPlayerGuess(), playerCount); // checks if the player guessed the correct word
                            } else if (count1keyboard == 3) {
                                for (int m = 0; m < target.length(); m++) {
                                    attempt3[m].setText(String.valueOf(p1.getPlayerGuess().charAt(m)));
                                }
                                txt.setText("");
                                check.checkWord(attempt3, p1.getPlayerGuess());
                                check.gameCheckKeyboard(p1.getPlayerGuess(), playerCount); // checks if the player guessed the correct word
                            } else if (count1keyboard == 4) {
                                for (int m = 0; m < target.length(); m++) {
                                    attempt4[m].setText(String.valueOf(p1.getPlayerGuess().charAt(m)));
                                }
                                txt.setText("");
                                check.checkWord(attempt4, p1.getPlayerGuess());
                                check.gameCheckKeyboard(p1.getPlayerGuess(), playerCount); // checks if the player guessed the correct word
                            } else if (count1keyboard == 5) {
                                for (int m = 0; m < target.length(); m++) {
                                    attempt5[m].setText(String.valueOf(p1.getPlayerGuess().charAt(m)));
                                }
                                txt.setText("");
                                check.checkWord(attempt5, p1.getPlayerGuess());
                               check.gameCheckKeyboard(p1.getPlayerGuess(), playerCount); // checks if the player guessed the correct word
                            }
                        }
                    }// if meaningful
                    else {
                        JOptionPane.showMessageDialog(pnlButton, "This word is not in our dictionary",
                                "Please try again", JOptionPane.ERROR_MESSAGE);
                        txt.setText("");
                    }
                }// big else end
            }
        });
    }



    public Keyboard(PlayerParent p1, PlayerParent p2) {
        Checks check = new Checks(target, this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playerCount = 2;
        System.out.println(target);
        BorderLayout bl = new BorderLayout();
        JPanel north;
        JPanel buttons;
        JPanel tables;
        JPanel left, right;
        isKeyboardopen=true;
        JTextField txt;
        JButton submit;

        JLabel turn;
        JLabel title;
        JLabel lspace;
        JLabel rspace;

        JLabel[] p11 = new JLabel[5];
        JLabel[] p12 = new JLabel[5];
        JLabel[] p13 = new JLabel[5];
        JLabel[] p14 = new JLabel[5];
        JLabel[] p15 = new JLabel[5];

        JLabel[] space = new JLabel[10]; //for making space between center and south panel

        JLabel[] p21 = new JLabel[5];
        JLabel[] p22 = new JLabel[5];
        JLabel[] p23 = new JLabel[5];
        JLabel[] p24 = new JLabel[5];
        JLabel[] p25 = new JLabel[5];

        JLabel[] space1 = new JLabel[5];

        WordBase wordBase = new WordBase();
        String target = wordBase.setWord();


        Color newGreen = new Color(107, 170, 100);
        Color orange = new Color(249, 231, 159);

        setSize(1400, 800);
        setTitle("Wordle Game");
        setLayout(bl);

        //North Panel
        north = new JPanel();
        north.setBackground(Color.white);
        title = new JLabel("Wordle Game");
        title.setFont(new Font("Calibri", Font.BOLD, 30));
        north.add(title);

        add(north, BorderLayout.NORTH);

        //Center Panel

        tables = new JPanel(new GridLayout(6, 11));
        tables.setBackground(Color.white);
        Border border = BorderFactory.createLineBorder(Color.white);
        for (int i = 0; i < p11.length; i++) {
            p11[i] = new JLabel();
            p11[i].setFont(new Font("Calibri", Font.BOLD, 40));
            p11[i].setOpaque(true);
            p11[i].setBorder(border);
            p11[i].setHorizontalAlignment(JLabel.CENTER);
            tables.add(p11[i]);
        }

        space1[0] = new JLabel();
        space1[0].setBorder(border);
        space1[0].setHorizontalAlignment(JLabel.CENTER);
        tables.add(space1[0]);

        for (int i = 0; i < p21.length; i++) {
            p21[i] = new JLabel();
            p21[i].setOpaque(true);
            p21[i].setBorder(border);
            p21[i].setHorizontalAlignment(JLabel.CENTER);
            p21[i].setFont(new Font("Calibri", Font.BOLD, 40));
            tables.add(p21[i]);
        }

        for (int i = 0; i < p12.length; i++) {
            p12[i] = new JLabel();
            p12[i].setOpaque(true);
            p12[i].setBorder(border);
            p12[i].setHorizontalAlignment(JLabel.CENTER);
            p12[i].setFont(new Font("Calibri", Font.BOLD, 40));
            tables.add(p12[i]);
        }
        space1[1] = new JLabel();
        space1[1].setBorder(border);
        space1[1].setHorizontalAlignment(JLabel.CENTER);
        tables.add(space1[1]);

        for (int i = 0; i < p22.length; i++) {
            p22[i] = new JLabel();
            p22[i].setOpaque(true);
            p22[i].setBorder(border);
            p22[i].setHorizontalAlignment(JLabel.CENTER);
            p22[i].setFont(new Font("Calibri", Font.BOLD, 40));
            tables.add(p22[i]);
        }
        for (int i = 0; i < p13.length; i++) {
            p13[i] = new JLabel();
            p13[i].setOpaque(true);
            p13[i].setBorder(border);
            p13[i].setHorizontalAlignment(JLabel.CENTER);
            p13[i].setFont(new Font("Calibri", Font.BOLD, 40));
            tables.add(p13[i]);
        }
        space1[2] = new JLabel();
        space1[2].setBorder(border);
        space1[2].setHorizontalAlignment(JLabel.CENTER);
        tables.add(space1[2]);

        for (int i = 0; i < p23.length; i++) {
            p23[i] = new JLabel();
            p23[i].setFont(new Font("Calibri", Font.BOLD, 40));
            p23[i].setOpaque(true);
            p23[i].setBorder(border);
            p23[i].setHorizontalAlignment(JLabel.CENTER);
            tables.add(p23[i]);
        }

        for (int i = 0; i < p14.length; i++) {
            p14[i] = new JLabel();
            p14[i].setOpaque(true);
            p14[i].setBorder(border);
            p14[i].setHorizontalAlignment(JLabel.CENTER);
            p14[i].setFont(new Font("Calibri", Font.BOLD, 40));
            tables.add(p14[i]);
        }
        space1[3] = new JLabel();
        space1[3].setBorder(border);
        space1[3].setHorizontalAlignment(JLabel.CENTER);
        tables.add(space1[3]);

        for (int i = 0; i < p24.length; i++) {
            p24[i] = new JLabel();
            p24[i].setOpaque(true);
            p24[i].setBorder(border);
            p24[i].setHorizontalAlignment(JLabel.CENTER);
            p24[i].setFont(new Font("Calibri", Font.BOLD, 40));
            tables.add(p24[i]);
        }

        for (int i = 0; i < p15.length; i++) {
            p15[i] = new JLabel();
            p15[i].setOpaque(true);
            p15[i].setBorder(border);
            p15[i].setHorizontalAlignment(JLabel.CENTER);
            p15[i].setFont(new Font("Calibri", Font.BOLD, 40));
            tables.add(p15[i]);
        }
        space1[4] = new JLabel();
        space1[4].setBorder(border);
        space1[4].setHorizontalAlignment(JLabel.CENTER);
        tables.add(space1[4]);

        for (int i = 0; i < p25.length; i++) {
            p25[i] = new JLabel();
            p25[i].setOpaque(true);
            p25[i].setBorder(border);
            p25[i].setHorizontalAlignment(JLabel.CENTER);
            p25[i].setFont(new Font("Calibri", Font.BOLD, 40));
            tables.add(p25[i]);
        }


        for (int i = 0; i < space.length; i++) {
            space[i] = new JLabel();
            space[i].setBackground(Color.white);
            space[i].setOpaque(true);
            space[i].setBorder(border);
            space[i].setHorizontalAlignment(JLabel.CENTER);
            space[i].setFont(new Font("Calibri", Font.BOLD, 40));
            tables.add(space[i]);
        } //making a space between center and south panel

        add(tables, BorderLayout.CENTER);


        //South panel

        buttons = new JPanel();
        buttons.setBackground(Color.white);
        turn = new JLabel("Player 1 is playing");
        turn.setForeground(Color.black);
        turn.setFont(new Font("Calibri", Font.BOLD, 35));


        txt = new JTextField();
        txt.setFont(new Font("Calibri", Font.BOLD, 30));
        txt.setPreferredSize(new Dimension(400, 45));
        txt.setHorizontalAlignment(JTextField.CENTER);
        submit = new JButton("submit");
        submit.setBackground(newGreen);
        submit.setForeground(Color.white);
        submit.setPreferredSize(new Dimension(100, 45));

        buttons.add(turn);
        buttons.add(txt);
        buttons.add(submit);

        add(buttons, BorderLayout.SOUTH);

        left = new JPanel();
        left.setBackground(Color.white);
        lspace = new JLabel("     ");
        lspace.setFont(new Font("Calibri", Font.BOLD, 70));
        left.add(lspace);
        right = new JPanel();
        right.setBackground(Color.white);
        rspace = new JLabel("     ");
        rspace.setFont(new Font("Calibri", Font.BOLD, 70));
        right.add(rspace);

        add(left, BorderLayout.WEST);
        add(right, BorderLayout.EAST);

        submit.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                if (!(txt.getText().matches("[A-Za-z]{5}"))) { // Makes sure the guess is 5 letters only
                    JOptionPane.showMessageDialog(buttons, "please enter only 5 letters, no digits or spaces",
                            "Invalid word", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (e.getSource() == submit) {
                        if (wordBase.isMeaningful(txt.getText())) {
                            count2keyboard++;
                            if (count2keyboard == 1 || count2keyboard == 2) {
                                if (p1Turn) {
                                    // player 1 1st attempt
                                    p1.setPlayerGuess(txt.getText());
                                    for (int m = 0; m < target.length(); m++) {
                                        p11[m].setText(String.valueOf(p1.getPlayerGuess().charAt(m)));
                                    }

                                    check.checkWord(p11, p1.getPlayerGuess());
                                    player1Tries++;
                                    
                                    check.gameCheckKeyboard(p1.getPlayerGuess(), playerCount); // checks if the player guessed the correct word
                                    p1Turn = false;
                                    txt.setText("");
                                    turn.setText("Player 2 is playing");
                                } else {
                                    // player 2 1st attempt
                                    p2.setPlayerGuess(txt.getText());
                                    for (int m = 0; m < target.length(); m++) {
                                        p21[m].setText(String.valueOf(p2.getPlayerGuess().charAt(m)));
                                    }
                                   check.checkWord(p21, p2.getPlayerGuess());
                                    player2Tries++;
                                    check.gameCheckKeyboard(p2.getPlayerGuess(), playerCount); // checks if the player guessed the correct word
                                    p1Turn = true;
                                    txt.setText("");
                                    turn.setText("Player 1 is playing");
                                }
                            }// end of count 1
                            //-------------------------------------------------------------------------
                            else if (count2keyboard == 3 || count2keyboard == 4) {
                                if (p1Turn) {
                                    // player 1 2nd attempt
                                    p1.setPlayerGuess(txt.getText());
                                    for (int m = 0; m < target.length(); m++) {
                                        p12[m].setText(String.valueOf(p1.getPlayerGuess().charAt(m)));
                                    }

                                    check.checkWord(p12, p1.getPlayerGuess());
                                    player1Tries++;
                                    check.gameCheckKeyboard(p1.getPlayerGuess(), playerCount); // checks if the player guessed the correct word
                                    p1Turn = false;
                                    txt.setText("");
                                    turn.setText("Player 2 is playing");
                                } else {
                                    // player 2 2nd attempt

                                    p2.setPlayerGuess(txt.getText());
                                    for (int m = 0; m < target.length(); m++) {
                                        p22[m].setText(String.valueOf(p2.getPlayerGuess().charAt(m)));
                                    }
                                    check.checkWord(p22, p2.getPlayerGuess());
                                    player2Tries++;
                                    check.gameCheckKeyboard(p2.getPlayerGuess(), playerCount); // checks if the player guessed the correct word
                                    p1Turn = true;
                                    txt.setText("");
                                    turn.setText("Player 1 is playing");
                                }
                            }// end of count 2
                            //-------------------------------------------------------------------------
                            else if (count2keyboard == 5 || count2keyboard == 6) {
                                if (p1Turn) {
                                    // player 1 3rd attempt

                                    p1.setPlayerGuess(txt.getText());
                                    for (int m = 0; m < target.length(); m++) {
                                        p13[m].setText(String.valueOf(p1.getPlayerGuess().charAt(m)));
                                    }
                                    check.checkWord(p13, p1.getPlayerGuess());
                                    player1Tries++;
                                   check.gameCheckKeyboard(p1.getPlayerGuess(), playerCount); // checks if the player guessed the correct word
                                    p1Turn = false;
                                    txt.setText("");
                                    turn.setText("Player 2 is playing");
                                } else {
                                    // player 2 3rd attempt

                                    p2.setPlayerGuess(txt.getText());
                                    for (int m = 0; m < target.length(); m++) {
                                        p23[m].setText(String.valueOf(p2.getPlayerGuess().charAt(m)));
                                    }
                                    check.checkWord(p23, p2.getPlayerGuess());
                                    player2Tries++;
                                    check.gameCheckKeyboard(p2.getPlayerGuess(), playerCount); // checks if the player guessed the correct word
                                    p1Turn = true;
                                    txt.setText("");
                                    turn.setText("Player 1 is playing");
                                }
                            }// end of count 3
                            //-------------------------------------------------------------------------
                            else if (count2keyboard == 7 || count2keyboard == 8) {
                                if (p1Turn) {
                                    // player 1 4th attempt
                                    p1.setPlayerGuess(txt.getText());
                                    for (int m = 0; m < target.length(); m++) {
                                        p14[m].setText(String.valueOf(p1.getPlayerGuess().charAt(m)));
                                    }

                                    check.checkWord(p14, p1.getPlayerGuess());
                                    player1Tries++;
                                    check.gameCheckKeyboard(p1.getPlayerGuess(), playerCount); // checks if the player guessed the correct word
                                    p1Turn = false;
                                    txt.setText("");
                                    turn.setText("Player 2 is playing");
                                } else {
                                    // player 2 4th attempt

                                    p2.setPlayerGuess(txt.getText());
                                    for (int m = 0; m < target.length(); m++) {
                                        p24[m].setText(String.valueOf(p2.getPlayerGuess().charAt(m)));
                                    }
                                    check.checkWord(p24, p2.getPlayerGuess());
                                    player2Tries++;
                                    check.gameCheckKeyboard(p2.getPlayerGuess(), playerCount); // checks if the player guessed the correct word
                                    p1Turn = true;
                                    txt.setText("");
                                    turn.setText("Player 1 is playing");
                                }
                            }// end of count 4
                            //-------------------------------------------------------------------------
                            else if (count2keyboard == 9 || count2keyboard == 10) {
                                if (p1Turn) {
                                    // player 1 5th attempt
                                    p1.setPlayerGuess(txt.getText());
                                    for (int m = 0; m < target.length(); m++) {
                                        p15[m].setText(String.valueOf(p1.getPlayerGuess().charAt(m)));
                                    }
                                    check.checkWord(p15, p1.getPlayerGuess());
                                    player1Tries++;
                                   check.gameCheckKeyboard(p1.getPlayerGuess(), playerCount); // checks if the player guessed the correct word
                                    p1Turn = false;
                                    txt.setText("");
                                    turn.setText("Player 2 is playing");
                                } else {
                                    // player 2 5th attempt
                                    p2.setPlayerGuess(txt.getText());
                                    for (int m = 0; m < target.length(); m++) {
                                        p25[m].setText(String.valueOf(p2.getPlayerGuess().charAt(m)));
                                    }
                                    check.checkWord(p25, p2.getPlayerGuess());
                                    player2Tries++;
                                   check.gameCheckKeyboard(p2.getPlayerGuess(), playerCount); // checks if the player guessed the correct word
                                    txt.setText("");

                                }// end of count 5
                            }
                        }// if meaningful
                        else {
                            JOptionPane.showMessageDialog(buttons, "This word is not in our dictionary",
                                    "Please try again", JOptionPane.ERROR_MESSAGE);
                            txt.setText("");
                        }
                    }

                }// big else end
            }
        });
    }
}