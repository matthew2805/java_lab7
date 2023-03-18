

import java.io.*;

public class task1 {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter("notes5.txt"))) {
            // чтение построчно
            String text;
            while(!(text=br.readLine()).equals("END")){
                bw.write(text + "\n");
                bw.flush();
            }
        }
        catch(IOException ex){ System.out.println(ex.getMessage()); }
    }
}

