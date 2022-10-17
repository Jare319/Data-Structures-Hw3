import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        Scanner scnr = new Scanner(file);
        while (scnr.hasNextLine()) {
            System.out.println(scnr.nextLine());
        }
        scnr.close();
    }
}
