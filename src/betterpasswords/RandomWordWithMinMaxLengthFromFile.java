/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betterpasswords;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author martin
 */
public class RandomWordWithMinMaxLengthFromFile {
    int wordMinLength = 3;
    int wordMaxLength = 5;
    Random rnd = new Random();
    String wordlistFile = "/resource/words";
    URL wordlistResource = this.getClass().getResource(wordlistFile);
    ArrayList<String> allTheWords = new ArrayList<>();
    int wordCount;

    public RandomWordWithMinMaxLengthFromFile() {
        try {
            InputStream inputStream = wordlistResource.openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                allTheWords.add(line);
            }
            wordCount = allTheWords.size();
        } catch (IOException ioe) {
            System.err.println("Irgendwas mit der Wordlist ging nicht.");
        }
    }
    
    public String getResourceURL() {
        return wordlistResource.toString();
    }

    public void setWordMaxLength(int wordMaxLength) {
        this.wordMaxLength = wordMaxLength;
    }

    public void setWordMinLength(int wordMinLength) {
        this.wordMinLength = wordMinLength;
    }
    
    public int getWordCount() {
        return wordCount;
    }
    public String getRandomWord() {
        while(true){
            int randomIndex = rnd.nextInt(wordCount);
            String tryWord = allTheWords.get(randomIndex);
            if ((tryWord.length() <= wordMaxLength) && tryWord.length() >= wordMinLength){
                return(tryWord);
            }
        }
    }
}
