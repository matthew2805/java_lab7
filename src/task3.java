import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class task3 {
    public static void main(String[] args) {
        try {
            File file = new File("students.txt");
            Scanner in = new Scanner(System.in);
            FileWriter writer = new FileWriter(file);
            System.out.print("Add 1 more info? YES or NO?\n");
            String answer = in.nextLine();
            answer = answer.toUpperCase();
            writer.write("Yakubchik Egor Andreevich" + " " + "Group 211" + " " + "Ocenki: [10,9,10,9,9]");
            if (answer.equals("YES")) {
                do {
                    String a = Input();
                    writer.write("\n" + a);
                    System.out.print("Add 1 more info? YES or NO?\n");
                    answer = in.nextLine();
                    answer = answer.toUpperCase();
                }
                while (answer.equals("YES"));
            }
            writer.flush();
            BufferedReader brr = new BufferedReader(new FileReader(file));
            String s;
            while ((s = brr.readLine()) != null)
                System.out.println(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            main(args);
        }
    }
    public static String Input() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("FIO: ");
        String FIO = in.nextLine();
        String[] f =FIO.split("\\s+");
        if(f.length<3)
            throw new Exception("Nevernoe FIO");
        System.out.print("Group: ");
        int group = Integer.parseInt(in.nextLine());
        System.out.print("Vvedite 5 ocenok: \n");
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0;i<5 ;i++){
            int x = in.nextInt();
            if(x<0 || x>10){
                throw new Exception("Vvedite chislo ot 1 do 10:)");
            }
            nums.add((x));
        }
        return (FIO+" "+"Group: "+group+" "+"Ocenki: "+nums);
    }
}

