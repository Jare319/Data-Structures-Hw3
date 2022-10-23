import java.io.File;
import java.util.Scanner;

// Author: Jarrett Crump
// Email: jarrett.crump@okstate.edu
// Date: 10/23/2022
// Description: Checks the contents of an HTML file to ensure that all of the tags are balanced.

class App {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Please run: \"java App <input_file_path>\"");
        } else {
            File file = new File(args[0]);
            Scanner scnr = new Scanner(file);
            Stack stack = new Stack();
            String[] lnArr;
            String line;
            int lnCount = 1;
            while (scnr.hasNextLine()) {
                line = scnr.nextLine().trim(); //Get next line of input file and trim ending whitespace
                lnArr = line.split("(?=<)"); // Splits up line into multiple strings using < as regex
                for (int i = 0; i < lnArr.length; i++) {
                    if (lnArr[i].contains("<")) { // For every string that starts with a tag
                        lnArr[i] = lnArr[i].split("(?<=>)")[0]; // Removes any extraneous text following the closing ">"
                        if (lnArr[i].contains(" ")) {
                            lnArr[i] = lnArr[i].split(" ")[0].concat(">"); // Removes any params that are entered with the tag
                        }
                        // lnArr[i] will now just equal a single tag with no parameters
                        if (!lnArr[i].equals("<hr>") && !lnArr[i].equals("<br>") && !lnArr[i].startsWith("<!")) {
                            // Removes any hr, br, or comment tags
                            if (!lnArr[i].startsWith("</")) { // If the tag isn't a closing tag, push it onto stack
                                stack.push(new Node(lnArr[i]));
                            } 
                            else if (!lnArr[i].equals("</" + stack.pop().getTag().substring(1))) {
                                // If the tag is a closing tag, and it doesn't match the topmost tag on the stack, gives an error
                                System.out.println("Oops... There is a problem...");
                                System.out.println("The " + lnArr[i] + " tag at line #" + lnCount + " does not meet the tag rules...");
                                scnr.close();
                                System.exit(0);
                            }
                        }
                    }
                }
                lnCount++; // Increments the line count for displaying the line that had the mistake
            }
            System.out.println("Congratulations...");
            System.out.println("The given HTML file meets all the tag rules...");
            scnr.close();
        }
    }
}
