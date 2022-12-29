import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Checks{
    public static long getCalculatetime() {
		return calculatetime;
	}
    
	public static int getCount1drop() {
		return count1drop;
	}
	public static int getCount2drop() {
		return count2drop;
	}

	public static boolean isPlayed() {
		return isPlayed;
	}

	public static boolean isVictory() {
		return victory;
	}

	public static boolean isPlayer1isTheWinner() {
		return isPlayer1isTheWinner;
	}
    public static long getFinishTime() {
        return System.nanoTime();
    }

    public static long getDurationKey() {
        return getFinishTime()-  Keyboard.startTime;
    }
    
    public static long getDurationDrag() {
        return getFinishTime()-  Keyboard.startTime;
    }
	String target;
	static boolean isPlayed = false;
    static boolean victory = false;
    static boolean isPlayer1isTheWinner = false;
    long finishTime;
     int player1Tries;
    int player2Tries;
    static int count1drop = 0;
    static int count2drop = 0;
    Keyboard k;
    DragAndDrop d;
    File log = new File("Log");
    Color newGreen = new Color(107, 170, 100);
    static long calculatetime;


	public Checks(String trgt, Keyboard k){ // constructor for Keyboard
        target = trgt;
        this.k = k;
    }
    public Checks(String trgt, DragAndDrop d){ // constructor for DragnDrop
        target = trgt;
        this.d = d;
    }

    public void gameCheckKeyboard(String playerGuess, int playerCount) {
        if (playerCount == 1) {
            if(playerGuess.equals(target)){// if the player wins we will show the animation
                isPlayed=true;
                victory = true;
                try {
                    score();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                 calculatetime = getDurationKey()/1000000000;
     
                k.dispose();
                AnimationFram f=new AnimationFram();
                f.setVisible(true);
            }
            if (Keyboard.count1keyboard == 5) {// if the user did not win, we open statistic
                isPlayed=true;
                calculatetime = getDurationKey()/1000000000;
                k.dispose();
                Statistics sc= new Statistics();
                sc.setVisible(true);
            }
        }else {
            if (playerGuess.equals(target)) {
                isPlayed=true;
                victory = true;
                try {
                    scoreTwoPlayers();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (Keyboard.count2keyboard ==1 || Keyboard.count2keyboard==3 ||Keyboard.count2keyboard ==5 || Keyboard.count2keyboard==7 ||Keyboard.count2keyboard ==9) {
                    isPlayer1isTheWinner=true;
                }else {
                    isPlayer1isTheWinner=false;
                }
                calculatetime = getDurationKey()/1000000000;
                k.dispose();
                AnimationFram f=new AnimationFram();
            }
            if(Keyboard.count2keyboard == 10){
                isPlayed=true;
                calculatetime = getDurationKey()/1000000000;
                k.dispose();
                Statistics sc= new Statistics();
                sc.setVisible(true);

            }
        }
    }
    public void gameCheckDnD(String playerGuess, int playerCount) {
        if (playerCount == 1) {
            if (playerGuess.equals(target)) {// if the player wins we will show the animation
                isPlayed = true;
                victory = true;
                try {
                    score();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                calculatetime = getDurationDrag()/1000000000;
                d.dispose();
                AnimationFram f = new AnimationFram();
            }
            if (DragAndDrop.count1drop == 5) {// if the user did not win, we open statistic
                isPlayed = true;
                calculatetime = getDurationDrag()/1000000000;
                Statistics sc = new Statistics();
                d.dispose();
                sc.setVisible(true);
            }
        } else {
            if (playerGuess.equals(target)) {
                isPlayed = true;
                victory = true;
                try {
                    scoreTwoPlayers();
                } catch (IOException e) {
                    //  TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (DragAndDrop.count2drop == 1 || DragAndDrop.count2drop == 3 || DragAndDrop.count2drop == 5 || DragAndDrop.count2drop == 7 || DragAndDrop.count2drop == 9) {
                    isPlayer1isTheWinner = true;
                } else {
                    isPlayer1isTheWinner = false;
                }
                calculatetime = getDurationDrag()/1000000000;
                d.dispose();
                AnimationFram f = new AnimationFram();
            }
            if (DragAndDrop.count2drop == 10) {
                isPlayed = true;
                calculatetime = getDurationDrag()/1000000000;
                Statistics sc = new Statistics();
                d.dispose();
                sc.setVisible(true);

            }
        }
    }

    private void score() throws IOException { // Keeps a log of the player's previous attempts
        BufferedWriter writer = new BufferedWriter(new FileWriter(log, true));
        writer.write("(One Player Game!)\n");
        if (victory) {
            writer.write("\nGOT IT!" + "\nYou got it in " + Keyboard.count1keyboard + " tries!\n" + "The word was: " + target +
                    "______________________________________\n");
        } else {
            writer.write("\nUnfortunately, you didn't get it. The word was: " + target + "\nBetter luck tomorrow!\n" +
                    "______________________________________\n");
        }
        writer.close();
    }

    private void scoreTwoPlayers() throws IOException { // Keeps a log of the player's previous attempts
        BufferedWriter writer = new BufferedWriter(new FileWriter(log, true));
        writer.write("(Two Player Game!)\n");
        if (victory && (player1Tries > player2Tries)) {
            writer.write("\nPLAYER 1 GOT IT!" + "\nGuessed in " + player1Tries + " tries!\n" + "The word was: " + target +
                    "\n______________________________________\n");
        }else if(victory){
            writer.write("\nPLAYER 2 GOT IT!" + "\nGuessed in " + player2Tries + " tries!\n" + "The word was: " + target +
                    "\n______________________________________\n");
        }else {
            writer.write("\nUnfortunately, neither of you got it. The word was: " + target + "\nBetter luck tomorrow!\n" +
                    "\n______________________________________\n");
        }
        writer.close();
    }

    public boolean isYellow(char letter, String targetWord) { // Check if the right letter is in a wrong position
        for (int index = 0; index < targetWord.length(); index++) {
            if (targetWord.charAt(index) == letter) {
                return true;
            }
        }
        return false;
    }

    public void checkWord(JLabel[] trial, String guess) { // checks if the right letter is in the correct position
        for (int j = 0; j < target.length(); j++) {
            if (trial[j].getText().equals(target.charAt(j) + "")) {
                trial[j].setBackground(newGreen);
            } else if (isYellow(guess.charAt(j), target)) {
                trial[j].setBackground(Color.yellow);
            } else {
                trial[j].setBackground(Color.gray);
            }
        }
    }
}
