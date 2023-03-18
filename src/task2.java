import java.io.*;
public class task2 {
    static void Create(String file, String text) throws Exception{
        FileWriter writer = new FileWriter(file, false);
        writer.write(text);
        writer.flush();
    }
    static String Read(String file) throws  Exception {
        String text = "";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s;
        while ((s = br.readLine()) != null) {
            text += s + '\n';
        }
        return text;
    }
    static String NewText(String[] t) {
        String text = "";
        for (int i = 0; i < t.length-3; i++) {
            text += t[i];
            if (i != t.length-3) {
                text += "\n";
            }
        }
        return text;
    }
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt"))) {
            String text;
            System.out.println("Napishite bolshe 3 predlojeni i vveidte stop\n");
            String file = "text.txt";
            while (!(text = br.readLine()).equals("stop")) {
                bw.write(text + "\n");
                bw.flush();
            }
            text = Read(file);
            String[] Text = text.split("\n");
            if(Text.length<3){
                throw new Exception("Slishkom malo predlojeni");
            }
            text = NewText(Text);
            Create(file, text);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
