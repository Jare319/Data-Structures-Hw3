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
            String[] lnArr;
            String line;
            int lnCount = 0;
            while (scnr.hasNextLine()) {
                line = scnr.nextLine().trim();
                lnArr = line.split("(?=<)"); // Splits up line, while still leaving "<" at begining of tag
                for (int i = 0; i < lnArr.length; i++) {
                    if (lnArr[i].contains("<")) {
                        lnArr[i] = lnArr[i].split("(?<=>)")[0]; // Removes any extraneous text following the closing ">"
                        if (lnArr[i].contains(" ")) {
                            lnArr[i] = lnArr[i].split(" ")[0].concat(">"); // Removes any params that are entered with the tag
                        }
                        // lnArr[i] will now just equal a single tag with no parameters
                        if (!lnArr[i].equals("<hr>") && !lnArr[i].equals("<br>") && !lnArr[i].startsWith("<!")) {
                            if (!lnArr[i].startsWith("</")) {
                                stack.push(new Node(lnArr[i]));
                            } 
                            else if (!lnArr[i].equals("</" + stack.pop().getTag().substring(1))) {
                                System.out.println("Oops... There is a problem...");
                                System.out.println("The " + lnArr[i] + " tag at line #" + lnCount + " does not meet the tag rules...");
                                scnr.close();
                                System.exit(0);
                            }
                        }
                    }
                }
                lnCount++;
            }
            System.out.println("Congratulations...");
            System.out.println("The given HTML file meets all the tag rules...");
            scnr.close();
        }
    }
}
