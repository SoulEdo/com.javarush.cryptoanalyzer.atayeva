
import java.io.*;
import java.util.Scanner;


public class Encryption {
    public static void encrypt() throws IOException, FileNotFoundException {

        try (BufferedReader reader = new BufferedReader(new FileReader("/home/maysa/Desktop/JRU_Projekt/com.javarush.cryptoanalyzer.atayeva/src/OriginalText.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("/home/maysa/Desktop/JRU_Projekt/com.javarush.cryptoanalyzer.atayeva/src/Encryption_Out.txt"))) {

            String str;
            while ((str = reader.readLine()) != null) {

                String encrypMsg = "";
                int key = 5;

                for (int i = 0; i < str.length(); i++) {
                    // again casting
                    if ((int) str.charAt(i) == 32) {
                        encrypMsg += (char) 32; // ignoring space, casting int to char

                    } else if ((int) str.charAt(i) + key > 122) {
                        int temp = ((int) str.charAt(i) + key) - 122;
                        encrypMsg += (char) (96 + temp);

                    } else if ((int) str.charAt(i) + key > 90 && (int) str.charAt(i) < 96) {
                        int temp = ((int) str.charAt(i) + key) - 90;
                        encrypMsg += (char) (64 + temp);

                    } else {
                        encrypMsg += (char) ((int) str.charAt(i) + key);
                    }
                }
                System.out.println(encrypMsg);

                writer.write(encrypMsg + "\n");
                writer.flush();
            }
        }
    }
}


















