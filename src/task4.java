import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class task4 {

    public static void main(String[] args) throws IOException {
        int count = 0;
        String filename = "text.txt";
        Scanner sc = new Scanner(new File(filename));
        String file = "text2.txt";
        FileWriter writer = new FileWriter(file);
        String lines = sc.nextLine();
        char[] chars = lines.toCharArray();
        for (int i = 0; i < chars.length - 2; i++) {
            if (chars[i] == '.') {
                char[] newChar = Character.toString(chars[i + 2]).toUpperCase(Locale.ROOT).toCharArray();
                char[] newChar1 = Character.toString(chars[0]).toUpperCase(Locale.ROOT).toCharArray();
                for (int j = 0; j < newChar.length; j++) {
                    chars[0]=newChar1[0];
                    chars[i + 2] = newChar[j];
                }
            }
        }
        for (int i = 0; i < chars.length; i++) {
            writer.write(chars[i]);
            if (chars[i] == '.') {
                count++;
                if (count % 5 == 0) {
                    writer.write("\n");
                }
            }
        }
        writer.flush();
        writer.close();
    }
}

