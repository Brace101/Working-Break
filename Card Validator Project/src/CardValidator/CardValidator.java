package CardValidator;

import java.util.Scanner;

public class CardValidator {

    static final String RESET = "\u001B[0m";
    static final String GREEN = "\u001B[32m";
    static final String RED = "\u001B[31m";
    static final String CYAN = "\u001B[36m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String PURPLE = "\u001B[35m";
    static final String BOLD = "\u001B[1m";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println(BLUE + "====================================================" + RESET);
        System.out.println(BOLD + CYAN + "              CARD VALIDATOR SYSTEM" + RESET);
        System.out.println(BLUE + "====================================================" + RESET);

        System.out.print(YELLOW + "Enter card details to verify: " + RESET);
        String cardDetails = input.nextLine();

        boolean digitOnly = true;

        if (cardDetails.length() < 13 || cardDetails.length() > 16) {
            System.out.println();
            System.out.println(RED + "Invalid card length" + RESET);
            System.out.println(BLUE + "====================================================" + RESET);
            return;
        }

        for (int index = 0; index < cardDetails.length(); index++) {

            if (!Character.isDigit(cardDetails.charAt(index))) {
                digitOnly = false;
                break;
            }
        }

        if (!digitOnly) {
            System.out.println();
            System.out.println(RED + "Card must contain only digits" + RESET);
            System.out.println(BLUE + "====================================================" + RESET);
            return;
        }

        String cardType;

        if (cardDetails.startsWith("4")) {
            cardType = "Visa Card";
        } else if (cardDetails.startsWith("5")) {
            cardType = "MasterCard";
        } else if (cardDetails.startsWith("34") || cardDetails.startsWith("37")) {
            cardType = "American Express";
        } else if (cardDetails.startsWith("6")) {
            cardType = "Discover Card";
        } else {
            cardType = "Unknown Card";
        }

        int sum = 0;
        boolean doubleDigit = false;

        for (int index = cardDetails.length() - 1; index >= 0; index--) {

            int digit = cardDetails.charAt(index) - '0';

            if (doubleDigit) {

                digit *= 2;

                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }

            sum += digit;

            doubleDigit = !doubleDigit;
        }

        boolean validCard = (sum % 10 == 0);

        System.out.println();
        System.out.println(PURPLE + "====================================================" + RESET);
        System.out.println(BOLD + "                CARD DETAILS" + RESET);
        System.out.println(PURPLE + "====================================================" + RESET);

        System.out.println(CYAN + "Card Type      : " + RESET + cardType);
        System.out.println(CYAN + "Card Length    : " + RESET + cardDetails.length());
        System.out.println(CYAN + "Validation Sum : " + RESET + sum);

        System.out.println(PURPLE + "----------------------------------------------------" + RESET);

    }

}