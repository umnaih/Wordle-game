import javax.swing.*;
import java.util.*;
import java.io.*;

public class WordBase {
    protected String[] words = new String[1000];
    protected Random random = new Random();
    protected int choice = random.nextInt(1000);

    protected WordBase(){
        String line;
        int i = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Words.txt"));
            while ((line = reader.readLine()) != null){
                words[i] = line;
                i++;
            }
        }catch (FileNotFoundException f){
            f.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    void printWord(){
        System.out.print(words[choice]);
    }
    String setWord(){
        return words[choice];
    }
    boolean isMeaningful(String word){
        List<String> list = Arrays.asList(words);
        return list.contains(word);
    }
}
