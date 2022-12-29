import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;

public class Statistics extends JFrame {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    JPanel north; // picture
    JPanel cent; //time of playing
    JPanel south; //your score, highest score, how many, win rate

    JLabel time;
    JLabel time2;

    JLabel score;
    JLabel high;
    JLabel winRate;
    JLabel playTime;

    JLabel scorePoint;
    JLabel highPoint;
    JLabel winRatePoint;
    JLabel playCountePoint;

    Font f = new Font("Calibri",Font.BOLD,40);

    Color newGreen = new Color(107, 170, 100);
    ImageIcon icon = new ImageIcon("wordle1.png");
    JLabel image;

    public Statistics() {
        setSize(1200, 700);
        setTitle("Statistics");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        north = new JPanel();
        north.setBackground(Color.white);
        image = new JLabel(icon);
        north.add(image);
        add(north, BorderLayout.NORTH);

        cent = new JPanel(new GridLayout(2,1));
        cent.setBackground(Color.white);

        time = new JLabel("The Time Of Playing:");
        time.setHorizontalAlignment(JLabel.CENTER);
        time.setFont(f);
        time2 = new JLabel(calculatetime());
        time2.setHorizontalAlignment(JLabel.CENTER);
        time2.setFont(f);

        cent.add(time);
        cent.add(time2);

        add(cent, BorderLayout.CENTER);

        south = new JPanel(new GridLayout(4,2));
        south.setBackground(Color.white);

        score = new JLabel("Your Score:");
        high = new JLabel("Highest Score:");
        playTime = new JLabel("Play Count:");
        winRate = new JLabel("Win rate(%):");

        scorePoint = new JLabel(yourScoreCount()+"%");
        highPoint = new JLabel(highestScoreReplace()+"%");
        playCountePoint = new JLabel(playCountRep());
        winRatePoint = new JLabel(winRate()+"%");

        south.add(score);
        score.setHorizontalAlignment(JLabel.CENTER);
        score.setFont(f);

        south.add(high);
        high.setHorizontalAlignment(JLabel.CENTER);
        high.setFont(f);

        south.add(scorePoint);
        scorePoint.setHorizontalAlignment(JLabel.CENTER);
        scorePoint.setFont(f);

        south.add(highPoint);
        highPoint.setHorizontalAlignment(JLabel.CENTER);
        highPoint.setFont(f);

        south.add(playTime);
        playTime.setHorizontalAlignment(JLabel.CENTER);
        playTime.setFont(f);

        south.add(winRate);
        winRate.setHorizontalAlignment(JLabel.CENTER);
        winRate.setFont(f);

        playCountePoint.setHorizontalAlignment(JLabel.CENTER);
        playCountePoint.setFont(f);
        south.add(playCountePoint);

        south.add(winRatePoint);
        winRatePoint.setHorizontalAlignment(JLabel.CENTER);
        winRatePoint.setFont(f);


        add(south, BorderLayout.SOUTH);
    }

    public static String yourScoreCount() {
        if(Keyboard.isKeyboardopen) {
            double count1= Keyboard.getCount1key();
            double count2= Keyboard.getCount2key();
            double playercount= Keyboard.getPlayerCount();

            if(playercount==1) {
                if(count1/5== 0.2) {
                    return "100";
                }else if (count1/5==0.4) {
                    return "80";
                }else if(count1/5==0.6) {
                    return "60";
                }else if(count1/5==0.8) {
                    return "40";
                }else if(count1/5==1) {
                    return "20";
                }

            }else if(playercount==2) {
                if(count2/10== 0.1) {
                    return "100";
                }else if (count2/10== 0.2) {
                    return "90";
                }else if(count2/10== 0.3) {
                    return "80";
                }else if(count2/10== 0.4) {
                    return "70";
                }else if(count2/10== 0.5) {
                    return "60";
                }else if (count2/10== 0.6) {
                    return "50";
                }else if(count2/10== 0.7) {
                    return "40";
                }else if(count2/10== 0.8) {
                    return "30";
                }else if(count2/10== 0.9) {
                    return "20";
                }else if(count2/10== 1) {
                    return "10";
                }
            }
        }//keyboard
        else {
            double count1= DragAndDrop.getCount1key();
            double count2= DragAndDrop.getCount2key();
            double playercount= DragAndDrop.getPlayerCount();

            if(playercount==1) {
                if(count1/5== 0.2) {
                    return "100";
                }else if (count1/5==0.4) {
                    return "80";
                }else if(count1/5==0.6) {
                    return "60";
                }else if(count1/5==0.8) {
                    return "40";
                }else if(count1/5==1) {
                    return "20";
                }

            }else if(playercount==2) {
                if(count2/10== 0.1) {
                    return "100";
                }else if (count2/10== 0.2) {
                    return "90";
                }else if(count2/10== 0.3) {
                    return "80";
                }else if(count2/10== 0.4) {
                    return "70";
                }else if(count2/10== 0.5) {
                    return "60";
                }else if (count2/10== 0.6) {
                    return "50";
                }else if(count2/10== 0.7) {
                    return "40";
                }else if(count2/10== 0.8) {
                    return "30";
                }else if(count2/10== 0.9) {
                    return "20";
                }else if(count2/10== 1) {
                    return "10";
                }
            }
        }//dragDrop

        return "0";
    }



    public static String calculatetime() {
        long s;
        if(Keyboard.isKeyboardopen) {
            s=Checks.getCalculatetime();
          
        }else {
            s=Checks.getCalculatetime();
        }

        long sec = s % 60;
        long min = (s / 60)%60;
        long hours = (s/60)/60;

        String strSec=(sec<10)?"0"+Integer.toString((int) sec):Integer.toString((int) sec);
        String strmin=(min<10)?"0"+Integer.toString((int) min):Integer.toString((int) min);
        String strHours=(hours<10)?"0"+Integer.toString((int) hours):Integer.toString((int) hours);
        return strHours + ":" + strmin + ":" + strSec;

    }

    public static String highestScoreReplace() {
        String highestScore="";
        String replaceHighetScore=yourScoreCount();
        String h;
        File hadi= new File("HighestScore.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(hadi));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String st="";
            st = br.readLine();
            while (st != null) {
                if(st.contains("Highest Score:") ) {
                    highestScore+=st.substring(14);
                }
                break;
            }

            if(Integer.parseInt(replaceHighetScore) > Integer.parseInt(highestScore)) {
                st = st.replace(highestScore, replaceHighetScore);
                highestScore=st.substring(14);
            }


            FileWriter fw = new FileWriter(hadi);
            fw.write(st);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return highestScore;

    }

    public static String playCountRep() {
        String playCount="";
        int playCountint = 0;
        File hadi= new File("playCountScore.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(hadi));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String st=br.readLine();
            while (st  != null) {

                if(st.contains("Play Count:")) {
                    playCount+=st.substring(11);
                    playCountint=Integer.parseInt(playCount);
                    playCountint++;
                    break;

                }
            }
            if(true) {
                st = st.replaceAll(playCount,playCountint+"");
                playCount=st.substring(11);
            }

            FileWriter fw = new FileWriter(hadi);
            fw.write(st);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return playCount;

    }

    public static String winCountRep() {
        String winCount="";
        int win = 0;
        boolean v;
        if(Keyboard.isKeyboardopen) {
            v=Checks.isVictory();
        }else {
            v=Checks.isVictory();
        }

        File hadi= new File("winCount.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(hadi));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String st=br.readLine();
            while (st != null) {
                if(st.contains("Win Count:")) {
                    winCount+=st.substring(10);
                    win=Integer.parseInt(winCount);
                    if(v) {
                        win++;
                    }

                }
                break;
            }
            if(true) {
                st = st.replaceAll(winCount,win+"");
                winCount=st.substring(10);
            }
            FileWriter fw = new FileWriter(hadi);
            fw.write(st);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return winCount;

    }

    public String winRate() {
        double win = Double.parseDouble(winCountRep());
        double playCount = Double.parseDouble(playCountRep());

        double result=win/playCount*100;
        String s=String.valueOf( df.format(result));
        return s;

    }


}

