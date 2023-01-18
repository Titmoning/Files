import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        try (FileReader reader = new FileReader("E://text.txt")) {
            char[] buf = new char[9999];
            int c;
            while ((c = reader.read(buf)) > 0) {

                if (c < 9999) {
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
                System.out.println("\n");
            }
            String seq = String.valueOf(buf);
            String[] split = seq.toLowerCase().split(" ");
            Arrays.sort(split);

            count(split);
        }
    }
    public static void count(String[] split){

        int x = split.length;
        String word = "", maxWord = "";
        int count = 1, maxCount = 0;

        for (String s : split) {
            if (s.equals(word)) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    maxWord = word;
                }
                word = s;
                count = 1;
            }
        }
        if (count > maxCount) {
            maxCount = count;
            maxWord = word;
        }
        System.out.println("Most frequently word is: " + maxWord + " (used " + maxCount + " times)");
    }
}