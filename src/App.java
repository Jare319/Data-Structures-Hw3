import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Please run: \"java App <input_file_path>\"");
        } else {
            File file = new File(args[0]);
            Scanner scnr = new Scanner(file);
            while (scnr.hasNextLine()) {
                
            }
            scnr.close();
        }
    }
}
