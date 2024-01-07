import java.io.*;

public class BruteForce {
    private static final String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static char bruteForce(char letter, int shift) throws IOException {

        if (alphabet.indexOf(letter) != -1) {
            return alphabet.charAt((alphabet.indexOf(letter) + shift) % alphabet.length());
        } else {
            return letter;
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("/home/maysa/Desktop/JRU_Projekt/com.javarush.cryptoanalyzer.atayeva/src/BruteForce_In.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("/home/maysa/Desktop/JRU_Projekt/com.javarush.cryptoanalyzer.atayeva/src/BruteForce_Out.txt"))) {

            String str = reader.readLine();
           // while (str != null) {
                str = str.toLowerCase();

                for (int i = 0; i <= alphabet.length(); ++i) {
                    for (int j = 0; j < str.length(); ++j) {

                        String bfMsg;
                        bfMsg = Character.toString(bruteForce(str.charAt(j), i));

                        System.out.print(bfMsg);
                        writer.write(bfMsg);
                        writer.flush();
                    }
                    System.out.println();
                    }
                }
            }
        }






