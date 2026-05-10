import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String indent = "\t\t";
        String indentOne = "\t";

        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";
        String RESET = "\u001B[0m";
        String PURPLE = "\u001B[35m";
        String CYAN = "\u001B[36m";
        String BOLD = "\u001B[1m";

        String newWord = "";

        System.out.println(indent + BOLD + GREEN + "===== CIPHER ENCRYPTION APP =====" + RESET);

        System.out.println("\n" + indentOne + CYAN + "Welcome! Let’s encrypt your message 🔐" + RESET + "\n");

        System.out.println("Enter a word: ");
        String word = input.nextLine();

        System.out.println("Enter number: ");
        int number = input.nextInt();

        for (int index = 0; index < word.length(); index++) {
            char eachWord = word.charAt(index);
            int figNum = eachWord + number;
            char finalfig = (char) figNum;
            newWord = newWord + finalfig;
        }

        System.out.println(newWord);

        System.out.print(indentOne + CYAN + "Would you like to encrypt more words? (yes/no): " + RESET);
        String response = input.next();

        if (response.equalsIgnoreCase("no")) {
            System.out.println("\n" + indent + GREEN + BOLD +
                    "Thank you for using Cipher App 🔐 Goodbye!" + RESET + "\n");
        }
    }
}