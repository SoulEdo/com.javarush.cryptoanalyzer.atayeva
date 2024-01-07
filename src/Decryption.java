import java.io.*;
import java.util.Locale;

public class Decryption {
    public static void decrypt() throws FileNotFoundException, IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader("/home/maysa/Desktop/JRU_Projekt/com.javarush.cryptoanalyzer.atayeva/src/Encryption_Out.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("/home/maysa/Desktop/JRU_Projekt/com.javarush.cryptoanalyzer.atayeva/src/Decryption_Out.txt"))) {

            String str;
            while ((str = reader.readLine()) != null) {

                String decrypMsg = "";
                int dcyptkey = 5;

                for (int i = 0; i < str.length(); i++) {
                    // now type casting
                    if ((int) str.charAt(i) == 32) {
                        decrypMsg += (char) 32;
                    } else if (((int) str.charAt(i) - dcyptkey) < 97 && ((int) str.charAt(i) - dcyptkey) > 90) {
                        //lower case
                        int temp = ((int) str.charAt(i) - dcyptkey) + 26;
                        decrypMsg += (char) temp;
                    } else if ((str.charAt(i) - dcyptkey) < 65) {
                        // upper case
                        int temp = ((int) str.charAt(i) - dcyptkey) + 26;
                        decrypMsg += (char) temp;
                    } else {
                        decrypMsg += (char) ((int) str.charAt(i) - dcyptkey);
                    }
                }
                System.out.println(decrypMsg);

                writer.write(decrypMsg + "\n");
                writer.flush();
            }
        }
    }
}


