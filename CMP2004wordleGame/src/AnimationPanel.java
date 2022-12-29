import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class AnimationPanel extends JPanel implements ActionListener{
    Image face;
    Image anim;
    Timer timer;
    int xVelocity=2;
    int yVelocity=1;
    int x=0;
    int y=0;
    String txt1="YOU WIN  !!";
    String txt21="Player 1 is the winner !!";
    String txt22="Player 2 is the winner !!";
    String  textField="Get Statistics";
    Rectangle2D.Double shape2 = new Rectangle2D.Double(310, 317, 7, 7);
    Font f= new Font("Calibri",Font.BOLD,20);

    public AnimationPanel() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500,500));
        face= new ImageIcon("face.png").getImage();
        anim= new ImageIcon("party.png").getImage();
        timer= new Timer(10, this);
        timer.start();
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton()==1 && shape2.contains(e.getX(), e.getY())) {
                    Statistics f2 = new Statistics();
                    setVisible(false);
                    f2.setVisible(true);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(Keyboard.isKeyboardopen) {
            boolean isPlayer1key=Checks.isPlayer1isTheWinner();
            int countkey= Keyboard.getPlayerCount();
            super.paintComponent(g);
            Graphics2D g2D= (Graphics2D)g;
            if (countkey ==1) {
                g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2D.drawImage(anim, x, y,null);
                g2D.drawImage(face, 200, 170,null);
                this.setFont(f);
                g2D.drawString(txt1, 200, 280);
                g2D.fill(shape2);
                g2D.drawString(textField, 200, 325);
            }
            else {
                g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2D.drawImage(anim, x, y,null);
                g2D.drawImage(face, 200, 170,null);
                this.setFont(f);
                if(isPlayer1key) {
                    g2D.drawString(txt21, 150, 280);
                }
                else {
                    g2D.drawString(txt22, 150, 280);
                }
                g2D.fill(shape2);
                g2D.drawString(textField, 200, 325);
            }
        }else {
            boolean isPlayer1drag=Checks.isPlayer1isTheWinner();
            int countdrag= DragAndDrop.getPlayerCount();
            super.paintComponent(g);
            Graphics2D g2D= (Graphics2D)g;
            if (countdrag ==1) {
                g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2D.drawImage(anim, x, y,null);
                g2D.drawImage(face, 200, 170,null);
                this.setFont(f);
                g2D.drawString(txt1, 200, 280);
                g2D.fill(shape2);
                g2D.drawString(textField, 200, 325);
            }else {
                g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2D.drawImage(anim, x, y,null);
                g2D.drawImage(face, 200, 170,null);
                this.setFont(f);
                if(isPlayer1drag) {
                    g2D.drawString(txt21, 150, 280);
                }else {
                    g2D.drawString(txt22, 150, 280);
                }
                g2D.fill(shape2);
                g2D.drawString(textField, 200, 325);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( x >= 500 - anim.getWidth(null) || x<0) {
            xVelocity= xVelocity *-1;
        }
        x+=xVelocity;
        if( y >= 500 - anim.getHeight(null) || y<0) {
            yVelocity= yVelocity *-1;
        }
        y+=yVelocity;
        repaint();


    }
}
