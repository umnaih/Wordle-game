import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WelcomePage extends JFrame implements ActionListener {
    JPanel panelChoice;
    JPanel panelLabel;
    JPanel panelLabel2;

    static boolean  keyPressed = false;
    static boolean  dragPressed = false;

    public static boolean isKeyPressed() {
        return keyPressed;
    }

    public static boolean isDragPressed() {
        return dragPressed;
    }

    JLabel lbl1;
    JLabel lbl2;
    JLabel img;

    JButton butKeyboard;
    JButton butDrag;
    BorderLayout bl;

    Color newGreen = new Color(107,170,100);
    final long startTime;
    public WelcomePage() {
        pack();
        setLocationRelativeTo(null);
        startTime = System.nanoTime();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setTitle("Wordle Game");
        this.setBackground(Color.WHITE);
        bl = new BorderLayout();
        setLayout(bl);


        panelChoice = new JPanel(); //South buttons new GridLayout(1,2)
        panelLabel = new JPanel(); //North image
        panelLabel2 = new JPanel(new GridLayout(2,1)); //Center labels

        ImageIcon icon = new ImageIcon("wordle1.png");
        img = new JLabel(icon);

        panelLabel.add(img);
        panelLabel.setBackground(Color.white);
        add(panelLabel, BorderLayout.NORTH);

        lbl1 = new JLabel("Welcome to the wordle game!");
        lbl1.setFont(new Font("Calibri",Font.BOLD,50));
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl2 = new JLabel("Would you like to continue with:");
        lbl2.setFont(new Font("Calibri",Font.BOLD,50));
        lbl2.setHorizontalAlignment(JLabel.CENTER);


        panelLabel2.add(lbl1);
        panelLabel2.setBackground(Color.white);
        panelLabel2.add(lbl2);

        add(panelLabel2, BorderLayout.CENTER);


        butKeyboard = new JButton("Keyboard");
        butKeyboard.setBackground(newGreen);
        butKeyboard.setPreferredSize(new Dimension(250,80));
        butKeyboard.setFont(new Font("Calibri",Font.BOLD,40));
        butKeyboard.setForeground(Color.white);

        butKeyboard.addActionListener(this);


        butDrag = new JButton("Drag and Drop");
        butDrag.setBackground(newGreen); //created a new color
        butDrag.setPreferredSize(new Dimension(250,80));
        butDrag.setFont(new Font("Calibri",Font.BOLD,30));
        butDrag.setForeground(Color.white);

        butDrag.addActionListener(this);

        panelChoice.add(butKeyboard);
        panelChoice.add(Box.createRigidArea(new Dimension(30, 0)));
        panelChoice.add(butDrag);

        add(panelChoice, BorderLayout.SOUTH);

        panelChoice.setBackground(Color.white);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == butKeyboard) {
            keyPressed = true;
            Player p = new Player();
            p.setVisible(true);
            this.dispose();
        }
        else if(e.getSource() == butDrag) {
            dragPressed = true;
            Player p = new Player();
            p.setVisible(true);
            this.dispose();
        }


    }

}
