import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;

public class DragAndDrop extends JFrame {

    public static long getStartTime() {
        return System.nanoTime();
    }


    public static int getCount1key() {
        return count1drop;
    }

    public static int getCount2key() {
        return count2drop;
    }
    public static int getPlayerCount() {
        return playerCount;
    }

  
    JLabel[] trie1 = new JLabel[5];
    JLabel[] trie2 = new JLabel[5];
    JLabel[] trie3 = new JLabel[5];
    JLabel[] trie4 = new JLabel[5];
    JLabel[] trie5 = new JLabel[5];
    JPanel nort;
    JPanel cent;
    JPanel sou;
    JLabel lblText;
    JPanel rgt,lft;
    ImageIcon imgA = new ImageIcon("A.png");
    ImageIcon imgB = new ImageIcon("B.png");
    ImageIcon imgC = new ImageIcon("C.png");
    ImageIcon imgD = new ImageIcon("D.png");
    ImageIcon imgE = new ImageIcon("E.png");
    ImageIcon imgF = new ImageIcon("F.png");
    ImageIcon imgG = new ImageIcon("G.png");
    ImageIcon imgH = new ImageIcon("H.png");
    ImageIcon imgI = new ImageIcon("I.png");
    ImageIcon imgJ = new ImageIcon("J.png");
    ImageIcon imgK = new ImageIcon("K.png");
    ImageIcon imgL= new ImageIcon("L.png");
    ImageIcon imgM = new ImageIcon("M.png");
    ImageIcon imgN = new ImageIcon("N.png");
    ImageIcon imgO = new ImageIcon("O.png");
    ImageIcon imgP = new ImageIcon("P.png");
    ImageIcon imgQ = new ImageIcon("Q.png");
    ImageIcon imgR = new ImageIcon("R.png");
    ImageIcon imgS = new ImageIcon("S.png");
    ImageIcon imgT = new ImageIcon("T.png");
    ImageIcon imgU = new ImageIcon("U.png");
    ImageIcon imgV = new ImageIcon("V.png");
    ImageIcon imgw = new ImageIcon("WW.png");
    ImageIcon imgX = new ImageIcon("X.png");
    ImageIcon imgY = new ImageIcon("Y.png");
    ImageIcon imgZ = new ImageIcon("Z.png");

    Color orange = new Color(239,228,176);
    Font font = new Font("Calibri", Font.BOLD, 30);

    JLabel lblA = new JLabel(imgA);
    JLabel lblB = new JLabel(imgB);
    JLabel lblC = new JLabel(imgC);
    JLabel lblD = new JLabel(imgD);
    JLabel lblE = new JLabel(imgE);
    JLabel lblF = new JLabel(imgF);
    JLabel lblG = new JLabel(imgG);
    JLabel lblH = new JLabel(imgH);
    JLabel lblI = new JLabel(imgI);
    JLabel lblJ = new JLabel(imgJ);
    JLabel lblK = new JLabel(imgK);
    JLabel lblL = new JLabel(imgL);
    JLabel lblM = new JLabel(imgM);
    JLabel lblN = new JLabel(imgN);
    JLabel lblO = new JLabel(imgO);
    JLabel lblP = new JLabel(imgP);
    JLabel lblQ = new JLabel(imgQ);
    JLabel lblR = new JLabel(imgR);
    JLabel lblS = new JLabel(imgS);
    JLabel lblT = new JLabel(imgT);
    JLabel lblU = new JLabel(imgU);
    JLabel lblV = new JLabel(imgV);
    JLabel lblW = new JLabel(imgw);
    JLabel lblX = new JLabel(imgX);
    JLabel lblY = new JLabel(imgY);
    JLabel lblZ = new JLabel(imgZ);
    JButton submit= new JButton("submit");
    static int playerCount = 1;
    Color newGreen = new Color(107, 170, 100);
    static long finishTime;
    static long startTime = getStartTime();
    static int count1drop = 0;
    static int count2drop = 0;
    WordBase wordBase = new WordBase();
    String target = wordBase.setWord();
    int player1Tries = 0;
    int player2Tries = 0;
    boolean p1Turn = true;
    Keyboard k;

    private static void setLabelDisable(JLabel trie[]) {
        for (int i = 0; i < trie.length; i++) {
            trie[i].setEnabled(false);
        }
    }
    private static void setLabelEnable(JLabel trie[]) {
        for (int i = 0; i < trie.length; i++) {
            trie[i].setEnabled(true);
        }
    }
    private static void clearJlabel(JLabel trie[]) {
        for (int i = 0; i < trie.length; i++) {
            trie[i].setText("");
        }
    }
    private static boolean isEmpty(JLabel lbl[]) {
        for (int i = 0; i < lbl.length; i++) {
            if(lbl[i].getText() == "") {
                return true;
            }
        }
        return false;
    }


    private static String getWord(JLabel trie[]) {
        String txt="";
        for (int i = 0; i < trie.length; i++) {
            txt+=trie[i].getText().toLowerCase();
        }
        return txt;
    }

    public DragAndDrop(PlayerParent p1) {
        Checks check = new Checks(target, this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,800);
        setTitle("Wordle Game");
        System.out.println(target);
        k.setKeyboardopen(false);

        nort = new JPanel();
        nort.setBackground(Color.white);

        lblText = new JLabel("Wordle Game");
        lblText.setFont(font);
        nort.add(lblText);
        add(nort, BorderLayout.NORTH);

        rgt = new JPanel();
        rgt.setBackground(Color.white);
        add(rgt, BorderLayout.EAST);

        lft = new JPanel();
        lft.setBackground(Color.white);
        add(lft, BorderLayout.WEST);

        cent = new JPanel(new GridLayout(5,5));
        cent.setBackground(Color.white);
        Border border = BorderFactory.createLineBorder(Color.white);
        for (int i = 0; i < trie1.length; i++) {
            trie1[i] = new JLabel();
            trie1[i].setBackground(Color.lightGray);
            trie1[i].setFont(new Font("Calibri", Font.BOLD, 40));
            trie1[i].setTransferHandler(new ImportHandler());
            trie1[i].setBounds(110+(92*i), 70, 90, 90);
            trie1[i].setOpaque(true);
            trie1[i].setBorder(border);
            trie1[i].setHorizontalAlignment(JLabel.CENTER);
            cent.add(trie1[i]);
        }

        for (int i = 0; i < trie2.length; i++) {
            trie2[i] = new JLabel();
            trie2[i].setBackground(Color.lightGray);
            trie2[i].setOpaque(true);
            trie2[i].setTransferHandler(new ImportHandler());
            trie2[i].setBorder(border);
            trie2[i].setHorizontalAlignment(JLabel.CENTER);
            trie2[i].setBounds(110+(92*i),162,90,90);
            trie2[i].setFont(new Font("Calibri", Font.BOLD, 40));
            cent.add(trie2[i]);
        }

        for (int i = 0; i < trie3.length; i++) {
            trie3[i] = new JLabel();
            trie3[i].setBackground(Color.lightGray);
            trie3[i].setOpaque(true);
            trie3[i].setTransferHandler(new ImportHandler());
            trie3[i].setBorder(border);
            trie3[i].setHorizontalAlignment(JLabel.CENTER);
            trie3[i].setBounds(110+(92*i),254,90,90);
            trie3[i].setFont(new Font("Calibri", Font.BOLD, 40));
            cent.add(trie3[i]);
        }
        for (int i = 0; i < trie4.length; i++) {
            trie4[i] = new JLabel();
            trie4[i].setBackground(Color.lightGray);
            trie4[i].setOpaque(true);
            trie4[i].setTransferHandler(new ImportHandler());
            trie4[i].setBorder(border);
            trie4[i].setHorizontalAlignment(JLabel.CENTER);
            trie4[i].setBounds(110+(92*i),346,90,90);
            trie4[i].setFont(new Font("Calibri", Font.BOLD, 40));
            cent.add(trie4[i]);
        }
        for (int i = 0; i < trie5.length; i++) {
            trie5[i] = new JLabel();
            trie5[i].setBackground(Color.lightGray);
            trie5[i].setOpaque(true);
            trie5[i].setTransferHandler(new ImportHandler());
            trie5[i].setBorder(border);
            trie5[i].setHorizontalAlignment(JLabel.CENTER);
            trie5[i].setBounds(110+(92*i),438,90,90);
            trie5[i].setFont(new Font("Calibri", Font.BOLD, 40));
            cent.add(trie5[i]);
        }

        add(cent, BorderLayout.CENTER);

        sou = new JPanel(new GridLayout(3,9));
        sou.setBackground(orange);
        sou.add(lblA);
        lblA.setTransferHandler(new ExportHandler('A'));
        lblA.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblB);
        add(sou, BorderLayout.SOUTH);
        lblB.setTransferHandler(new ExportHandler('B'));
        lblB.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblC);
        add(sou, BorderLayout.SOUTH);
        lblC.setTransferHandler(new ExportHandler('C'));
        lblC.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblD);
        add(sou, BorderLayout.SOUTH);
        lblD.setTransferHandler(new ExportHandler('D'));
        lblD.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblE);
        add(sou, BorderLayout.SOUTH);
        lblE.setTransferHandler(new ExportHandler('E'));
        lblE.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblF);
        add(sou, BorderLayout.SOUTH);
        lblF.setTransferHandler(new ExportHandler('F'));
        lblF.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblG);
        add(sou, BorderLayout.SOUTH);
        lblG.setTransferHandler(new ExportHandler('G'));
        lblG.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblH);
        add(sou, BorderLayout.SOUTH);
        lblH.setTransferHandler(new ExportHandler('H'));
        lblH.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblI);
        add(sou, BorderLayout.SOUTH);
        lblI.setTransferHandler(new ExportHandler('I'));
        lblI.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblJ);
        add(sou, BorderLayout.SOUTH);
        lblJ.setTransferHandler(new ExportHandler('J'));
        lblJ.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblK);
        add(sou, BorderLayout.SOUTH);
        lblK.setTransferHandler(new ExportHandler('K'));
        lblK.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblL);
        add(sou, BorderLayout.SOUTH);
        lblL.setTransferHandler(new ExportHandler('L'));
        lblL.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblM);
        add(sou, BorderLayout.SOUTH);
        lblM.setTransferHandler(new ExportHandler('M'));
        lblM.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblN);
        add(sou, BorderLayout.SOUTH);
        lblN.setTransferHandler(new ExportHandler('N'));
        lblN.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblO);
        add(sou, BorderLayout.SOUTH);
        lblO.setTransferHandler(new ExportHandler('O'));
        lblO.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblP);
        add(sou, BorderLayout.SOUTH);
        lblP.setTransferHandler(new ExportHandler('P'));
        lblP.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblQ);
        add(sou, BorderLayout.SOUTH);
        lblQ.setTransferHandler(new ExportHandler('Q'));
        lblQ.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblR);
        add(sou, BorderLayout.SOUTH);
        lblR.setTransferHandler(new ExportHandler('R'));
        lblR.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblS);
        add(sou, BorderLayout.SOUTH);
        lblS.setTransferHandler(new ExportHandler('S'));
        lblS.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblT);
        add(sou, BorderLayout.SOUTH);
        lblT.setTransferHandler(new ExportHandler('T'));
        lblT.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblU);
        add(sou, BorderLayout.SOUTH);
        lblU.setTransferHandler(new ExportHandler('U'));
        lblU.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblV);
        add(sou, BorderLayout.SOUTH);
        lblV.setTransferHandler(new ExportHandler('V'));
        lblV.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblW);
        add(sou, BorderLayout.SOUTH);
        lblW.setTransferHandler(new ExportHandler('W'));
        lblW.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblX);
        add(sou, BorderLayout.SOUTH);
        lblX.setTransferHandler(new ExportHandler('X'));
        lblX.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblY);
        add(sou, BorderLayout.SOUTH);
        lblY.setTransferHandler(new ExportHandler('Y'));
        lblY.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblZ);
        add(sou, BorderLayout.SOUTH);
        lblZ.setTransferHandler(new ExportHandler('Z'));
        lblZ.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        submit.setBackground(Color.LIGHT_GRAY);
        submit.setFont(new Font("Calibri", Font.BOLD, 14));
        sou.add(submit);
        add(sou,BorderLayout.SOUTH);
        if(count1drop==0) {
            setLabelDisable(trie2);
            setLabelDisable(trie3);
            setLabelDisable(trie4);
            setLabelDisable(trie5);
        }
        submit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String txt="";
                String txt2="";
                String txt3="";
                String txt4="";
                String txt5="";
                if(isEmpty(trie1)) {
                    JOptionPane.showMessageDialog(sou, "please drag 5 letters",
                            "Invalid word", JOptionPane.ERROR_MESSAGE);
                }

                else {// if try1
                    txt= getWord(trie1);
                    txt2= getWord(trie2);
                    txt3=getWord(trie3);
                    txt4= getWord(trie4);
                    txt5=getWord(trie5);
                    if (e.getSource() == submit) {
                        count1drop++;
                        if(count1drop ==1) {
                            if (wordBase.isMeaningful(txt)) {
                                p1.setPlayerGuess(txt);
                                check.checkWord(trie1, p1.getPlayerGuess());
                                check.gameCheckDnD(p1.getPlayerGuess(),playerCount); // checks if the player guessed the correct word
                                setLabelDisable(trie1);
                                setLabelDisable(trie3);
                                setLabelDisable(trie4);
                                setLabelDisable(trie5);
                                setLabelEnable(trie2);
                                txt="";
                            }else {
                                JOptionPane.showMessageDialog(sou, "This word is not in our dictionary",
                                        "Please try again", JOptionPane.ERROR_MESSAGE);
                                if(count1drop==1) {
                                    clearJlabel(trie1);
                                    count1drop--;
                                    txt="";
                                }
                            }
                        }
                        else if(count1drop ==2) {
                            if(isEmpty(trie2)) {
                                JOptionPane.showMessageDialog(sou, "please drag 5 letters",
                                        "Invalid word", JOptionPane.ERROR_MESSAGE);
                                count1drop--;
                            }
                            else if (wordBase.isMeaningful(txt2)) {
                                p1.setPlayerGuess(txt2);
                                check.checkWord(trie2, p1.getPlayerGuess());
                                check.gameCheckDnD(p1.getPlayerGuess(),playerCount); // checks if the player guessed the correct word
                                setLabelDisable(trie1);
                                setLabelDisable(trie2);
                                setLabelDisable(trie4);
                                setLabelDisable(trie5);
                                setLabelEnable(trie3);
                                txt="";
                            }else {
                                JOptionPane.showMessageDialog(sou, "This word is not in our dictionary",
                                        "Please try again", JOptionPane.ERROR_MESSAGE);
                                if(count1drop==2) {
                                    clearJlabel(trie2);
                                    count1drop--;
                                    txt="";
                                }
                            }
                        }// count==2
                        else if(count1drop ==3) {
                            if(isEmpty(trie3)) {
                                JOptionPane.showMessageDialog(sou, "please drag 5 letters",
                                        "Invalid word", JOptionPane.ERROR_MESSAGE);
                                count1drop--;
                            }
                            else if (wordBase.isMeaningful(txt3)) {
                                p1.setPlayerGuess(txt3);
                                check.checkWord(trie3, p1.getPlayerGuess());
                                check.gameCheckDnD(p1.getPlayerGuess(),playerCount); // checks if the player guessed the correct word
                                setLabelDisable(trie1);
                                setLabelDisable(trie2);
                                setLabelDisable(trie3);
                                setLabelDisable(trie5);
                                setLabelEnable(trie4);
                                txt="";
                            }else {
                                JOptionPane.showMessageDialog(sou, "This word is not in our dictionary",
                                        "Please try again", JOptionPane.ERROR_MESSAGE);
                                if(count1drop==3) {
                                    clearJlabel(trie3);
                                    count1drop--;
                                    txt="";
                                }
                            }
                        }// count==3
                        else if(count1drop ==4) {
                            if(isEmpty(trie4)) {
                                JOptionPane.showMessageDialog(sou, "please drag 5 letters",
                                        "Invalid word", JOptionPane.ERROR_MESSAGE);
                                count1drop--;
                            }
                            else if (wordBase.isMeaningful(txt4)) {
                                p1.setPlayerGuess(txt4);
                                check.checkWord(trie4, p1.getPlayerGuess());
                                check.gameCheckDnD(p1.getPlayerGuess(),playerCount); // checks if the player guessed the correct word
                                setLabelDisable(trie1);
                                setLabelDisable(trie2);
                                setLabelDisable(trie3);
                                setLabelDisable(trie4);
                                setLabelEnable(trie5);
                                txt="";
                            }else {
                                JOptionPane.showMessageDialog(sou, "This word is not in our dictionary",
                                        "Please try again", JOptionPane.ERROR_MESSAGE);
                                if(count1drop==4) {
                                    clearJlabel(trie4);
                                    count1drop--;
                                    txt="";
                                }
                            }
                        }// count==4
                        else if(count1drop ==5) {
                            if(isEmpty(trie5)) {
                                JOptionPane.showMessageDialog(sou, "please drag 5 letters",
                                        "Invalid word", JOptionPane.ERROR_MESSAGE);
                                count1drop--;
                            }
                            else if (wordBase.isMeaningful(txt5)) {
                                p1.setPlayerGuess(txt5);
                                check.checkWord(trie5, p1.getPlayerGuess());
                                check.gameCheckDnD(p1.getPlayerGuess(),playerCount); // checks if the player guessed the correct word
                                setLabelDisable(trie1);
                                setLabelDisable(trie2);
                                setLabelDisable(trie3);
                                setLabelDisable(trie4);
                                setLabelDisable(trie5);
                                txt="";
                            }else {
                                JOptionPane.showMessageDialog(sou, "This word is not in our dictionary",
                                        "Please try again", JOptionPane.ERROR_MESSAGE);
                                if(count1drop==5) {
                                    clearJlabel(trie5);
                                    count1drop--;
                                    txt="";
                                }
                            }
                        }// count==4

                    }// e.getSource

                }// big else

            }
        });



    }

    //Drag And Drop Player2 Constructor
    public DragAndDrop(PlayerParent p1, PlayerParent p2) {
        Checks check = new Checks(target, this );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout bl = new BorderLayout();
        JPanel north;
        JPanel sou;
        JPanel tables;
        JPanel left, right;
        k.setKeyboardopen(false);
        playerCount = 2;

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
        JButton submit= new JButton("submit");

        setSize(1400, 800);
        setTitle("Wordle Game");
        setLayout(bl);

        //North Panel
        north = new JPanel();
        north.setBackground(Color.white);
        title = new JLabel("Wordle Game");
        title.setFont(new Font("Calibri", Font.BOLD, 30));
        north.add(title);
        System.out.println(target);
        add(north, BorderLayout.NORTH);

        //Center Panel

        tables = new JPanel(new GridLayout(6, 11));
        tables.setBackground(Color.white);
        Border border = BorderFactory.createLineBorder(Color.white);
        for (int i = 0; i < p11.length; i++) {
            p11[i] = new JLabel();
            p11[i].setFont(new Font("Calibri", Font.BOLD, 40));
            p11[i].setOpaque(true);
            p11[i].setTransferHandler(new ImportHandler());
            p11[i].setBorder(border);
            p11[i].setHorizontalAlignment(JLabel.CENTER);
            tables.add(p11[i]);
        }

        space1[0] = new JLabel();
        space1[0].setBorder(border);
        space1[0].setHorizontalAlignment(JLabel.CENTER);
        tables.add(space1[0]);

        for (int i = 0; i < p12.length; i++) {
            p12[i] = new JLabel();
            p12[i].setOpaque(true);
            p12[i].setTransferHandler(new ImportHandler());
            p12[i].setBorder(border);
            p12[i].setHorizontalAlignment(JLabel.CENTER);
            p12[i].setFont(new Font("Calibri", Font.BOLD, 40));
            tables.add(p12[i]);
        }
        for (int i = 0; i < p21.length; i++) {
            p21[i] = new JLabel();
            p21[i].setOpaque(true);
            p21[i].setTransferHandler(new ImportHandler());
            p21[i].setBorder(border);
            p21[i].setHorizontalAlignment(JLabel.CENTER);
            p21[i].setFont(new Font("Calibri", Font.BOLD, 40));
            tables.add(p21[i]);
        }
        space1[1] = new JLabel();
        space1[1].setBorder(border);
        space1[1].setHorizontalAlignment(JLabel.CENTER);
        tables.add(space1[1]);

        for (int i = 0; i < p22.length; i++) {
            p22[i] = new JLabel();
            p22[i].setOpaque(true);
            p22[i].setTransferHandler(new ImportHandler());
            p22[i].setBorder(border);
            p22[i].setHorizontalAlignment(JLabel.CENTER);
            p22[i].setFont(new Font("Calibri", Font.BOLD, 40));
            tables.add(p22[i]);
        }
        for (int i = 0; i < p13.length; i++) {
            p13[i] = new JLabel();
            p13[i].setOpaque(true);
            p13[i].setTransferHandler(new ImportHandler());
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
            p23[i].setTransferHandler(new ImportHandler());
            p23[i].setOpaque(true);
            p23[i].setBorder(border);
            p23[i].setHorizontalAlignment(JLabel.CENTER);
            tables.add(p23[i]);
        }

        for (int i = 0; i < p14.length; i++) {
            p14[i] = new JLabel();
            p14[i].setOpaque(true);
            p14[i].setTransferHandler(new ImportHandler());
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
            p24[i].setTransferHandler(new ImportHandler());
            p24[i].setBorder(border);
            p24[i].setHorizontalAlignment(JLabel.CENTER);
            p24[i].setFont(new Font("Calibri", Font.BOLD, 40));
            tables.add(p24[i]);
        }

        for (int i = 0; i < p15.length; i++) {
            p15[i] = new JLabel();
            p15[i].setOpaque(true);
            p15[i].setBorder(border);
            p15[i].setTransferHandler(new ImportHandler());
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
            p25[i].setTransferHandler(new ImportHandler());
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
        space[4].setText("Player 1");
        space[4].setFont(new Font("Calibri", Font.BOLD, 27));
        space[5].setText("is playing");
        space[5].setFont(new Font("Calibri", Font.BOLD, 27));

        add(tables, BorderLayout.CENTER);


        //South panel
        sou = new JPanel(new GridLayout(3,9));
        sou.setBackground(orange);
        sou.add(lblA);
        lblA.setTransferHandler(new ExportHandler('A'));
        lblA.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblB);
        submit.setFont(new Font("Calibri", Font.BOLD, 18));
        add(sou, BorderLayout.SOUTH);
        lblB.setTransferHandler(new ExportHandler('B'));
        lblB.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblC);
        add(sou, BorderLayout.SOUTH);
        lblC.setTransferHandler(new ExportHandler('C'));
        lblC.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblD);
        add(sou, BorderLayout.SOUTH);
        lblD.setTransferHandler(new ExportHandler('D'));
        lblD.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblE);
        add(sou, BorderLayout.SOUTH);
        lblE.setTransferHandler(new ExportHandler('E'));
        lblE.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblF);
        add(sou, BorderLayout.SOUTH);
        lblF.setTransferHandler(new ExportHandler('F'));
        lblF.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblG);
        add(sou, BorderLayout.SOUTH);
        lblG.setTransferHandler(new ExportHandler('G'));
        lblG.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblH);
        add(sou, BorderLayout.SOUTH);
        lblH.setTransferHandler(new ExportHandler('H'));
        lblH.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblI);
        add(sou, BorderLayout.SOUTH);
        lblI.setTransferHandler(new ExportHandler('I'));
        lblI.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblJ);
        add(sou, BorderLayout.SOUTH);
        lblJ.setTransferHandler(new ExportHandler('J'));
        lblJ.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblK);
        add(sou, BorderLayout.SOUTH);
        lblK.setTransferHandler(new ExportHandler('K'));
        lblK.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblL);
        add(sou, BorderLayout.SOUTH);
        lblL.setTransferHandler(new ExportHandler('L'));
        lblL.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblM);
        add(sou, BorderLayout.SOUTH);
        lblM.setTransferHandler(new ExportHandler('M'));
        lblM.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblN);
        add(sou, BorderLayout.SOUTH);
        lblN.setTransferHandler(new ExportHandler('N'));
        lblN.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblO);
        add(sou, BorderLayout.SOUTH);
        lblO.setTransferHandler(new ExportHandler('O'));
        lblO.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblP);
        add(sou, BorderLayout.SOUTH);
        lblP.setTransferHandler(new ExportHandler('P'));
        lblP.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblQ);
        add(sou, BorderLayout.SOUTH);
        lblQ.setTransferHandler(new ExportHandler('Q'));
        lblQ.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblR);
        add(sou, BorderLayout.SOUTH);
        lblR.setTransferHandler(new ExportHandler('R'));
        lblR.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblS);
        add(sou, BorderLayout.SOUTH);
        lblS.setTransferHandler(new ExportHandler('S'));
        lblS.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblT);
        add(sou, BorderLayout.SOUTH);
        lblT.setTransferHandler(new ExportHandler('T'));
        lblT.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblU);
        add(sou, BorderLayout.SOUTH);
        lblU.setTransferHandler(new ExportHandler('U'));
        lblU.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblV);
        add(sou, BorderLayout.SOUTH);
        lblV.setTransferHandler(new ExportHandler('V'));
        lblV.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblW);
        add(sou, BorderLayout.SOUTH);
        lblW.setTransferHandler(new ExportHandler('W'));
        lblW.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblX);
        add(sou, BorderLayout.SOUTH);
        lblX.setTransferHandler(new ExportHandler('X'));
        lblX.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblY);
        add(sou, BorderLayout.SOUTH);
        lblY.setTransferHandler(new ExportHandler('Y'));
        lblY.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        sou.add(lblZ);
        add(sou, BorderLayout.SOUTH);
        lblZ.setTransferHandler(new ExportHandler('Z'));
        lblZ.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                JLabel lbl = (JLabel)e.getSource();
                TransferHandler handle = lbl.getTransferHandler();
                handle.exportAsDrag(lbl, e, TransferHandler.COPY);
            }
        });
        if(count2drop==0) {
            setLabelDisable(p12);
            setLabelDisable(p21);
            setLabelDisable(p22);
            setLabelDisable(p13);
            setLabelDisable(p23);
            setLabelDisable(p14);
            setLabelDisable(p24);
            setLabelDisable(p15);
            setLabelDisable(p25);
        }
        submit.setBackground(Color.LIGHT_GRAY);
        sou.add(submit);
        add(sou, BorderLayout.SOUTH);

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
                String txt="";
                String txt2="";
                String txt3="";
                String txt4="";
                String txt5="";
                String txt6="";
                String txt7="";
                String txt8="";
                String txt9="";
                String txt10="";
                if(isEmpty(p11)) {
                    JOptionPane.showMessageDialog(sou, "please drag 5 letters",
                            "Invalid word", JOptionPane.ERROR_MESSAGE);
                }

                else {// if it is not empty
                    txt= getWord(p11);
                    txt2= getWord(p12);
                    txt3=getWord(p21);
                    txt4= getWord(p22);
                    txt5=getWord(p13);
                    txt6= getWord(p23);
                    txt7=getWord(p14);
                    txt8= getWord(p24);
                    txt9=getWord(p15);
                    txt10=getWord(p25);
                    if (e.getSource() == submit) {
                        count2drop++;
                        if(count2drop ==1 || count2drop==2) {
                            if (wordBase.isMeaningful(txt) && p1Turn) {// player 1 turn
                                p1.setPlayerGuess(txt);
                                check.checkWord(p11, p1.getPlayerGuess());
                                player1Tries++;
                                check.gameCheckDnD(p1.getPlayerGuess(),playerCount); // checks if the player guessed the correct word
                                p1Turn=false;
                                space[4].setText("Player 2");
                                setLabelDisable(p11);
                                setLabelEnable(p21);
                                setLabelDisable(p22);
                                setLabelDisable(p13);
                                setLabelDisable(p23);
                                setLabelDisable(p14);
                                setLabelDisable(p24);
                                setLabelDisable(p15);
                                setLabelDisable(p25);
                                setLabelEnable(p12);
                            }
                            else if(isEmpty(p12)) {
                                JOptionPane.showMessageDialog(sou, "please drag 5 letters",
                                        "Invalid word", JOptionPane.ERROR_MESSAGE);
                                count2drop--;
                            }
                            else if (wordBase.isMeaningful(txt2) && !(p1Turn)) {// player 2 turn
                                p2.setPlayerGuess(txt2);
                                check.checkWord(p12, p2.getPlayerGuess());
                                player2Tries++;
                                check.gameCheckDnD(p2.getPlayerGuess(),playerCount); // checks if the player guessed the correct word
                                p1Turn = true;
                                space[4].setText("Player 1");
                                setLabelDisable(p12);
                                setLabelDisable(p11);
                                setLabelDisable(p22);
                                setLabelDisable(p13);
                                setLabelDisable(p23);
                                setLabelDisable(p14);
                                setLabelDisable(p24);
                                setLabelDisable(p15);
                                setLabelDisable(p25);
                                setLabelEnable(p21);
                                txt="";
                            }
                            else {// if it is not meaningful
                                JOptionPane.showMessageDialog(sou, "This word is not in our dictionary",
                                        "Please try again", JOptionPane.ERROR_MESSAGE);
                                if(count2drop==1) {
                                    clearJlabel(p11);
                                    count2drop--;
                                    txt="";
                                }else if(count2drop==2) {
                                    clearJlabel(p12);
                                    count2drop--;
                                    txt="";
                                }
                            }
                        }
                        else if(count2drop ==3 || count2drop==4) {
                            if(isEmpty(p21)) {
                                JOptionPane.showMessageDialog(sou, "please drag 5 letters",
                                        "Invalid word", JOptionPane.ERROR_MESSAGE);
                                count2drop--;
                            }
                            else if (wordBase.isMeaningful(txt3) && p1Turn) {// player 1 turn
                                p1.setPlayerGuess(txt3);
                                check.checkWord(p21, p1.getPlayerGuess());
                                player1Tries++;
                                check.gameCheckDnD(p1.getPlayerGuess(),playerCount); // checks if the player guessed the correct word
                                p1Turn=false;
                                space[4].setText("Player 2");
                                setLabelDisable(p11);
                                setLabelDisable(p12);
                                setLabelDisable(p21);
                                setLabelDisable(p13);
                                setLabelDisable(p23);
                                setLabelDisable(p14);
                                setLabelDisable(p24);
                                setLabelDisable(p15);
                                setLabelDisable(p25);
                                setLabelEnable(p22);
                            }
                            else if(isEmpty(p22)) {
                                JOptionPane.showMessageDialog(sou, "please drag 5 letters",
                                        "Invalid word", JOptionPane.ERROR_MESSAGE);
                                count2drop--;
                            }
                            else if (wordBase.isMeaningful(txt4) && !(p1Turn)) {// player 2 turn
                                p2.setPlayerGuess(txt4);
                                check.checkWord(p22, p2.getPlayerGuess());
                                player2Tries++;
                                check.gameCheckDnD(p2.getPlayerGuess(),playerCount); // checks if the player guessed the correct word
                                p1Turn = true;
                                space[4].setText("Player 1");
                                setLabelDisable(p11);
                                setLabelDisable(p21);
                                setLabelDisable(p12);
                                setLabelDisable(p22);
                                setLabelDisable(p23);
                                setLabelDisable(p14);
                                setLabelDisable(p24);
                                setLabelDisable(p15);
                                setLabelDisable(p25);
                                setLabelEnable(p13);
                                txt="";
                            }else {// if it is not meaningful
                                JOptionPane.showMessageDialog(sou, "This word is not in our dictionary",
                                        "Please try again", JOptionPane.ERROR_MESSAGE);
                                if(count2drop==3) {
                                    clearJlabel(p21);
                                    count2drop--;
                                    txt="";
                                }else if(count2drop==4) {
                                    clearJlabel(p22);
                                    count2drop--;
                                    txt="";
                                }
                            }
                        }
                        else if(count2drop ==5 || count2drop==6) {
                            if(isEmpty(p13)) {
                                JOptionPane.showMessageDialog(sou, "please drag 5 letters",
                                        "Invalid word", JOptionPane.ERROR_MESSAGE);
                                count2drop--;
                            }
                            else if (wordBase.isMeaningful(txt5) && p1Turn) {// player 1 turn
                                p1.setPlayerGuess(txt5);
                                check.checkWord(p13, p1.getPlayerGuess());
                                player1Tries++;
                                check.gameCheckDnD(p1.getPlayerGuess(),playerCount); // checks if the player guessed the correct word
                                p1Turn=false;
                                space[4].setText("Player 2");
                                setLabelDisable(p11);
                                setLabelDisable(p21);
                                setLabelDisable(p12);
                                setLabelDisable(p22);
                                setLabelDisable(p13);
                                setLabelDisable(p14);
                                setLabelDisable(p24);
                                setLabelDisable(p15);
                                setLabelDisable(p25);
                                setLabelEnable(p23);
                            }
                            else if(isEmpty(p23)) {
                                JOptionPane.showMessageDialog(sou, "please drag 5 letters",
                                        "Invalid word", JOptionPane.ERROR_MESSAGE);
                                count2drop--;
                            }
                            else if (wordBase.isMeaningful(txt6) && !(p1Turn)) {// player 2 turn
                                p2.setPlayerGuess(txt6);
                                check.checkWord(p23, p2.getPlayerGuess());
                                player2Tries++;
                                check.gameCheckDnD(p2.getPlayerGuess(),playerCount); // checks if the player guessed the correct word
                                p1Turn = true;
                                space[4].setText("Player 1");
                                setLabelDisable(p11);
                                setLabelDisable(p21);
                                setLabelDisable(p12);
                                setLabelDisable(p22);
                                setLabelDisable(p13);
                                setLabelDisable(p23);
                                setLabelDisable(p15);
                                setLabelDisable(p25);
                                setLabelDisable(p24);
                                setLabelEnable(p14);
                                txt="";
                            }else {// if it is not meaningful
                                JOptionPane.showMessageDialog(sou, "This word is not in our dictionary",
                                        "Please try again", JOptionPane.ERROR_MESSAGE);
                                if(count2drop==5) {
                                    clearJlabel(p13);
                                    count2drop--;
                                    txt="";
                                }else if(count2drop==6) {
                                    clearJlabel(p23);
                                    count2drop--;
                                    txt="";
                                }
                            }
                        }
                        else if(count2drop ==7 || count2drop==8) {
                            if(isEmpty(p14)) {
                                JOptionPane.showMessageDialog(sou, "please drag 5 letters",
                                        "Invalid word", JOptionPane.ERROR_MESSAGE);
                                count2drop--;
                            }
                            else if (wordBase.isMeaningful(txt7) && p1Turn) {// player 1 turn
                                p1.setPlayerGuess(txt7);
                                check.checkWord(p14, p1.getPlayerGuess());
                                player1Tries++;
                                check.gameCheckDnD(p1.getPlayerGuess(),playerCount); // checks if the player guessed the correct word
                                p1Turn=false;
                                space[4].setText("Player 2");
                                setLabelDisable(p11);
                                setLabelDisable(p21);
                                setLabelDisable(p12);
                                setLabelDisable(p22);
                                setLabelDisable(p13);
                                setLabelDisable(p23);
                                setLabelDisable(p15);
                                setLabelDisable(p25);
                                setLabelDisable(p14);
                                setLabelEnable(p24);
                            }
                            else if(isEmpty(p24)) {
                                JOptionPane.showMessageDialog(sou, "please drag 5 letters",
                                        "Invalid word", JOptionPane.ERROR_MESSAGE);
                                count2drop--;
                            }
                            else if (wordBase.isMeaningful(txt8) && !(p1Turn)) {// player 2 turn
                                p2.setPlayerGuess(txt8);
                                check.checkWord(p24, p2.getPlayerGuess());
                                player2Tries++;
                                check.gameCheckDnD(p2.getPlayerGuess(),playerCount); // checks if the player guessed the correct word
                                p1Turn = true;
                                space[4].setText("Player 1");
                                setLabelDisable(p11);
                                setLabelDisable(p21);
                                setLabelDisable(p12);
                                setLabelDisable(p22);
                                setLabelDisable(p13);
                                setLabelDisable(p23);
                                setLabelDisable(p14);
                                setLabelDisable(p25);
                                setLabelDisable(p24);
                                setLabelEnable(p15);
                                txt="";
                            }else {// if it is not meaningful
                                JOptionPane.showMessageDialog(sou, "This word is not in our dictionary",
                                        "Please try again", JOptionPane.ERROR_MESSAGE);
                                if(count2drop==7) {
                                    clearJlabel(p14);
                                    count2drop--;
                                    txt="";
                                }else if(count2drop==8) {
                                    clearJlabel(p24);
                                    count2drop--;
                                    txt="";
                                }
                            }
                        }
                        else if(count2drop ==9 || count2drop==10) {
                            if(isEmpty(p15)) {
                                JOptionPane.showMessageDialog(sou, "please drag 5 letters",
                                        "Invalid word", JOptionPane.ERROR_MESSAGE);
                                count2drop--;
                            }
                            else if (wordBase.isMeaningful(txt9) && p1Turn) {// player 1 turn
                                p1.setPlayerGuess(txt9);
                                check.checkWord(p15, p1.getPlayerGuess());
                                player1Tries++;
                                check.gameCheckDnD(p1.getPlayerGuess(),playerCount); // checks if the player guessed the correct word
                                p1Turn=false;
                                space[4].setText("Player 2");
                                setLabelDisable(p11);
                                setLabelDisable(p21);
                                setLabelDisable(p12);
                                setLabelDisable(p22);
                                setLabelDisable(p13);
                                setLabelDisable(p23);
                                setLabelDisable(p15);
                                setLabelDisable(p14);
                                setLabelDisable(p24);
                                setLabelEnable(p25);
                            }
                            else if(isEmpty(p25)) {
                                JOptionPane.showMessageDialog(sou, "please drag 5 letters",
                                        "Invalid word", JOptionPane.ERROR_MESSAGE);
                                count2drop--;
                            }
                            else if (wordBase.isMeaningful(txt10) && !(p1Turn)) {// player 2 turn
                                p2.setPlayerGuess(txt10);
                                check.checkWord(p25, p2.getPlayerGuess());
                                player2Tries++;
                                check.gameCheckDnD(p2.getPlayerGuess(),playerCount); // checks if the player guessed the correct word
                                p1Turn = true;
                                space[4].setText("Player 1");
                                setLabelDisable(p11);
                                setLabelDisable(p21);
                                setLabelDisable(p12);
                                setLabelDisable(p22);
                                setLabelDisable(p13);
                                setLabelDisable(p23);
                                setLabelDisable(p15);
                                setLabelDisable(p14);
                                setLabelDisable(p24);
                                setLabelDisable(p25);

                                txt="";
                            }else {// if it is not meaningful
                                JOptionPane.showMessageDialog(sou, "This word is not in our dictionary",
                                        "Please try again", JOptionPane.ERROR_MESSAGE);
                                if(count2drop==9) {
                                    clearJlabel(p15);
                                    count2drop--;
                                    txt="";
                                }else if(count2drop==10) {
                                    clearJlabel(p25);
                                    count2drop--;
                                    txt="";
                                }
                            }
                        }

                    }
                }
            }
        });

    }


    public static class ExportHandler extends TransferHandler {
        public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;
        private char ch;

        public ExportHandler(char ch) {
            this.ch = ch;
        }

        public String getChar() {
            return String.valueOf(ch);
        }

        @Override
        public int getSourceActions(JComponent c) {
            return DnDConstants.ACTION_COPY_OR_MOVE;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            Transferable tf = new StringSelection(getChar());
            return tf;
        }

        @Override
        protected void exportDone(JComponent jc, Transferable tf, int a) {
            super.exportDone(jc, tf, a);

        }
    }

    public static class ImportHandler extends TransferHandler {
        public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;

        public ImportHandler() {
        }
        @Override
        public boolean canImport(TransferHandler.TransferSupport s) {
            return s.isDataFlavorSupported(SUPPORTED_DATE_FLAVOR);
        }
        @Override
        public boolean importData(TransferHandler.TransferSupport s) {
            boolean flag = false;
            if (canImport(s)) {
                try {
                    Transferable tf = s.getTransferable();
                    Object data = tf.getTransferData(SUPPORTED_DATE_FLAVOR);
                    if (data instanceof String) {
                        Component component = s.getComponent();
                        if (component instanceof JLabel) {
                            ((JLabel) component).setText(data.toString());
                            flag = true;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return flag;
        }
    }
}
