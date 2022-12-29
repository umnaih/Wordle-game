import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Player extends JFrame implements ActionListener{

    JButton player1;
    JButton player2;

    JPanel pnl1; //for the img
    JPanel pnl2; //for the Buttons
    JPanel pnl3; //for lbl in the middle

    JLabel img;
    JLabel info;

    Color newGreen = new Color(107,170,100);

    public Player() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1070,700);
        setTitle("Wordle Game");

        pnl1 = new JPanel();
        pnl1.setBackground(Color.white);
        img = new JLabel(new ImageIcon("wordle2.3.png"));
        pnl1.add(img);
        add(pnl1, BorderLayout.NORTH);

        pnl3 = new JPanel();
        pnl3.setBackground(Color.white);

        info = new JLabel("How many players will play the game?");
        info.setFont(new Font("Calibri", Font.BOLD,50));
        info.setHorizontalAlignment(JLabel.CENTER);

        pnl3.add(info);
        add(pnl3, BorderLayout.CENTER);

        pnl2 = new JPanel();
        pnl2.setBackground(Color.white);

        player1 = new JButton("1 Player");
        player1.setFont(new Font("Calibri", Font.BOLD,40));
        player1.setBackground(newGreen);
        player1.setForeground(Color.white);
        player1.addActionListener(this);

        player2 = new JButton("2 Players");
        player2.setFont(new Font("Calibri", Font.BOLD,40));
        player2.setBackground(newGreen);
        player2.setForeground(Color.white);
        player2.addActionListener(this);

        pnl2.add(player1);
        pnl2.add(Box.createRigidArea(new Dimension(90, 0)));
        pnl2.add(player2);
        //player1 player2 drag and drop frame



        add(pnl2, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WelcomePage w = new WelcomePage();
        if(e.getSource() == player1 && w.isKeyPressed()) {
            PlayerParent p1 = new PlayerParent("player 1");
            Keyboard k = new Keyboard(p1);
            k.setVisible(true);
            this.dispose();
        }
        else if(e.getSource() == player1 && w.isDragPressed()) {
            PlayerParent p1 = new PlayerParent("player 1");
            DragAndDrop d = new DragAndDrop(p1);
            d.setVisible(true);
            this.dispose();
        }
        else if(e.getSource() == player2 && w.isKeyPressed()) {
            PlayerParent p1 = new PlayerParent("player 1");
            PlayerParent p2 = new PlayerParent("player 2");
            Keyboard k = new Keyboard(p1, p2);
            k.setVisible(true);
            this.dispose();
        }
        else if(e.getSource() == player2 && w.isDragPressed()) {
            PlayerParent p1 = new PlayerParent("player 1");
            PlayerParent p2 = new PlayerParent("player 2");
            DragAndDrop d = new DragAndDrop(p1,p2);
            d.setVisible(true);
            this.dispose();
        }


    }
}
