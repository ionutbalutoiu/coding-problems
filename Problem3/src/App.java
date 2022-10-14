import java.util.Scanner;
import java.util.Stack;

public class App {

    public boolean isValid(String input) {
        String openingBrackets = "([{";
        String closingBrackets = ")]}";
        Stack<Integer> openedBracketsIndexes = new Stack<Integer>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (openedBracketsIndexes.empty() && closingBrackets.indexOf(c) != -1) {
                System.out.println("found close bracket before any opening one");
                return false;
            }
            int openBracketIndex = openingBrackets.indexOf(c);
            if(openBracketIndex != -1) {
                // found opening bracket{}
                openedBracketsIndexes.push(Integer.valueOf(openBracketIndex));
                continue;
            }
            int closingBracketIndex = closingBrackets.indexOf(c);
            if (closingBracketIndex == -1) {
                // character is not closing bracket. skipping"
                continue;
            }
            if(closingBracketIndex != openedBracketsIndexes.pop().intValue()) {
                System.out.println("closing bracket doesn't match the last open");
                return false;
            }
        }
        if(!openedBracketsIndexes.isEmpty()) {
            System.out.println("found brackets not closed");
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner stdin = new Scanner(System.in);
        System.out.print("Input: ");
        String input = stdin.nextLine();
        stdin.close();

        App app = new App();
        if (app.isValid(input)) {
            System.out.println("Input is valid.");
        } else {
            System.out.println("Input is NOT valid!");
        }
    }
}
