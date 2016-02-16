/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betterpasswords;

import java.util.Random;

/**
 *
 * @author martin
 */
public class BetterPassword {
    public String getBetterPassword() {
        RandomWordWithMinMaxLengthFromFile rff = new RandomWordWithMinMaxLengthFromFile();
        rff.setWordMinLength(3);
        rff.setWordMaxLength(4);

        
        while (true){
            // try until we can ensure a "good quality" password
            // with all character classes.
            
            // Get a random number
            Random rnd = new Random();
            String number = String.format("%03d", rnd.nextInt(1000));

            // Pick a special character
            String[] specialChars = {"-", "+", ".", ",", "*", "_", "$"};
            int numCharsAvailable = specialChars.length;
            int randomIndex = rnd.nextInt(numCharsAvailable);
            String randomChar = specialChars[randomIndex];

            // Randomly swap order of number and special character
            String firstMiddlePart = number;
            String secondMiddlePart = randomChar;
            if (rnd.nextBoolean() == false) {
                firstMiddlePart = randomChar;
                secondMiddlePart = number;
            }

            String readyPw = String.format("%s%s%s%s", 
                    rff.getRandomWord(), firstMiddlePart, secondMiddlePart, rff.getRandomWord());
            
            // Last resort quality control to check we have upper- and lowercase letters
            if (readyPw.matches(".*[a-z].*")) {
                if (readyPw.matches(".*[A-Z].*")) {
                    return(readyPw);
                }
            }
        }
    }
}
