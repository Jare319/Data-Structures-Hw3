import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Please run: \"java App <input_file_path>\"");
        } else {
            File file = new File(args[0]);
            Scanner scnr = new Scanner(file);
            Stack stack = new Stack();
            String line;
            String[] lnArr;
            while (scnr.hasNextLine()) {
                line = scnr.nextLine();
                if (line.contains("<")) {
                    lnArr = line.split("<", 0);
                    for (int i = 0; i < lnArr.length; i++) {
                        System.out.println(lnArr[i]);
                    }
                    
                }
            }
            scnr.close();
        }
    }
}
