package NumberHunting;

import java.util.Random;
import java.util.Scanner;

public class NumberHunter {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String indent = "\t\t";
        String indentOne = "\t";
        String userResponse;

        String BLINK = "\u001B[5m";
        String GREEN = "\u001B[32m";
        String RED = "\u001B[31m";
        String YELLOW = "\u001B[33m";
        String RESET = "\u001B[0m";
        String PURPLE = "\u001B[35m";
        String CYAN = "\u001B[36m";
        String WHITE = "\u001B[37m";
        String BOLD = "\u001B[1m";
        String ITALIC = "\u001B[3m";

        System.out.println(GREEN + BLINK + "   = = =          //=\\      !!=\\      //=!!     = = = =   !!           = = =       //=\\        = = =   = = = = !!  = == =  !!=\\      !!    = = =   " + RESET);
        System.out.println(GREEN + BLINK + " !!     !!       //   \\     !!  \\    //  !!   !!          !!         !!     !!    //   \\     !!     !! !!       !!   !!    !!  \\     !!  !!     !! " + RESET);
        System.out.println(GREEN + BLINK + " !!             //     \\    !!   \\  //   !!   !!= = =     !!         !!     !!   //     \\    !!     !! !!       !!   !!    !!   \\    !!  !!        " + RESET);
        System.out.println(GREEN + BLINK + " !!   = !!     //= = = =\\   !!    \\=//   !!   !!          !!         !!     !!  //= = = =\\   !!     !! !!       !!   !!    !!    \\   !!  !!   = !! " + RESET);
        System.out.println(GREEN + BLINK + " !!     !!    //         \\  !!            !!   !!          !!         !!     !! //         \\  !!     !! !!       !!   !!    !!     \\  !!  !!     !! " + RESET);
        System.out.println(GREEN + BLINK + "   = = =     //           \\ !!            !!     = = = =     = = = =    = = =  //           \\   = = =   = = = = !!  = == =  !!      \\=!!    = = =   " + RESET);

        System.out.println(CYAN + BOLD + ITALIC + indentOne + "SESSION LOADING..............................................." + RESET);

        System.out.println(WHITE + BOLD + ITALIC + indent + "Hello, Kindly enter your name" + "\n" + RESET);
        String userName = input.nextLine();

        String playAgain = "yes";

        while (playAgain.equalsIgnoreCase("yes")) {

            System.out.println(GREEN + BOLD + indentOne + "=======================================" + RESET);
            System.out.println(PURPLE + BOLD + indent + ITALIC + "??NUMBER HUNTER GAME??" + RESET);
            System.out.println(GREEN + BOLD + indentOne + "=======================================" + RESET);
            System.out.println(CYAN + indent + ITALIC + "Welcome, " + userName + "!!!" + RESET);
            System.out.println(GREEN + BOLD + indentOne + "---------------------------------------" + "\n" + RESET);

            System.out.print(indent + BOLD + CYAN + BLINK + "Choose a mode to play" + "\n" + RESET);

            System.out.println("\n" + YELLOW + indentOne + "1.?? Chill Mode" + RESET);
            System.out.println("\n" + YELLOW + indentOne + "2.?? Focus Mode" + RESET);
            System.out.println("\n" + YELLOW + indentOne + "3.?? Beast Mode" + RESET);

            System.out.print("\n" + CYAN + indent + BOLD + "Enter choice('1-3'): " + RESET);

            int choice;

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();
            } else {
                input.nextLine();
                System.out.println(RED + indent + "Invalid input!" + RESET);
                continue;
            }

            if (choice < 1 || choice > 3) {
                System.out.println(RED + indent + "Invalid choice! Please enter 1, 2, or 3." + RESET);
                continue;
            }

            int secretNumber;
            int attempts;
            int maxAttempts;

            if (choice == 1) {
                secretNumber = random.nextInt(50) + 1;
                attempts = 0;
                maxAttempts = 10;

                System.out.println("\n" + CYAN + ITALIC + indent + "Chill Mode loading..." + RESET);

            } else if (choice == 2) {
                secretNumber = random.nextInt(100) + 1;
                attempts = 0;
                maxAttempts = 7;

                System.out.println("\n" + CYAN + ITALIC + indent + "Focus Mode loading..." + RESET);

            } else {
                secretNumber = random.nextInt(200) + 1;
                attempts = 0;
                maxAttempts = 5;

                System.out.println("\n" + CYAN + ITALIC + indent + "Beast Mode loading..." + RESET);
            }

            System.out.print(CYAN + indent + "Type 'OK' to start: " + RESET);

            userResponse = "";
            while (!userResponse.equalsIgnoreCase("OK")) {
                userResponse = input.nextLine();
            }

            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {

                System.out.println("\n" + CYAN + indent + "Attempt " + (attempts + 1) + " of " + maxAttempts + RESET);
                System.out.print(WHITE + indent + "Enter your guess > " + RESET);

                if (!input.hasNextInt()) {
                    System.out.println(RED + indent + "Please enter a valid number!" + RESET);
                    input.nextLine();
                    continue;
                }

                int userGuess = input.nextInt();
                input.nextLine();

                attempts++;

                if (userGuess == secretNumber) {
                    guessedCorrectly = true;
                    System.out.println(GREEN + BOLD + indent + " CORRECT! " + RESET);
                    System.out.println(GREEN + indent + "You guessed it in " + attempts + " attempts.\n" + RESET);
                    break;

                } else if (userGuess < secretNumber) {
                    System.out.println(YELLOW + indent + " Too low!\n" + RESET);

                } else {
                    System.out.println(YELLOW + indent + " Too high!\n" + RESET);
                }
            }

            if (!guessedCorrectly) {
                System.out.println(RED + BOLD + indent + " GAME OVER " + RESET);
                System.out.println(RED + indent + "The correct number was: " + secretNumber + "\n" + RESET);
            }

            input.nextLine(); // clear buffer before play again prompt

            System.out.print("\n" + CYAN + indent + BOLD + "Play again? (Yes/No): " + RESET);
            playAgain = input.nextLine();
        }

        System.out.println("\n" + GREEN + BOLD + indent +
                "Thanks for playing, " + userName + "! See you next time ?" + "\n" + RESET);
    }
}