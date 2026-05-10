package TransactionLog;

import java.util.ArrayList;
import java.util.Scanner;

public class TransactionLog {

    static String indent = "\t\t";
    static String indentOne = "\t";

    static String GREEN = "\u001B[32m";
    static String RED = "\u001B[31m";
    static String YELLOW = "\u001B[33m";
    static String RESET = "\u001B[0m";
    static String PURPLE = "\u001B[35m";
    static String CYAN = "\u001B[36m";
    static String BOLD = "\u001B[1m";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double balance = 0;
        int pin = 1234;

        ArrayList<String> transactions = new ArrayList<>();

        boolean running = true;

        while (running) {

            System.out.println(indent + BOLD + GREEN + "===== TRANSACTION LOG APP =====" + RESET);

            System.out.println(indentOne + CYAN + "1. Deposit funds" + RESET);
            System.out.println(indentOne + CYAN + "2. Withdraw funds" + RESET);
            System.out.println(indentOne + CYAN + "3. Transaction history" + RESET);
            System.out.println(indentOne + CYAN + "4. Exit" + RESET);

            System.out.print(indent + YELLOW + BOLD + "Choose an option: " + RESET);

            int option;

            try {
                option = input.nextInt();
            } catch (Exception e) {
                System.out.println(indent + RED + "Invalid input\n" + RESET);
                input.nextLine();
                continue;
            }

            try {

                switch (option) {

                    case 1 -> {

                        System.out.println("\n" + indent + PURPLE + "===== DEPOSIT =====" + RESET);

                        System.out.print(indentOne + CYAN + "Enter amount: " + RESET);
                        double deposit = input.nextDouble();

                        System.out.print(indentOne + CYAN + "Enter PIN: " + RESET);
                        int transPin = input.nextInt();

                        if (transPin == pin) {

                            balance += deposit;
                            transactions.add("Deposited " + deposit);

                            System.out.println("\n" + indent + GREEN + BOLD +
                                    "Deposit successful" + RESET);
                            System.out.println(indent + YELLOW +
                                    "Balance: " + balance + RESET + "\n");

                        } else {
                            System.out.println(indent + RED + "Incorrect PIN\n" + RESET);
                        }
                    }

                    case 2 -> {

                        System.out.println("\n" + indent + PURPLE + "===== WITHDRAW =====" + RESET);

                        System.out.print(indentOne + CYAN + "Enter amount: " + RESET);
                        double withdrawal = input.nextDouble();

                        System.out.print(indentOne + CYAN + "Enter PIN: " + RESET);
                        int transPin = input.nextInt();

                        if (transPin != pin) {

                            System.out.println(indent + RED + "Incorrect PIN\n" + RESET);

                        } else if (withdrawal > balance) {

                            System.out.println(indent + RED + "Insufficient balance\n" + RESET);

                        } else {

                            balance -= withdrawal;
                            transactions.add("Withdrew " + withdrawal);

                            System.out.println("\n" + indent + GREEN + BOLD +
                                    "Withdrawal successful" + RESET);
                            System.out.println(indent + YELLOW +
                                    "Balance: " + balance + RESET + "\n");
                        }
                    }

                    case 3 -> {

                        System.out.println("\n" + indent + PURPLE + "===== TRANSACTION HISTORY =====" + RESET);

                        input.nextLine(); // clear buffer

                        System.out.print(indentOne + CYAN +
                                "View transaction history? (yes/no): " + RESET);

                        String choice = input.nextLine();

                        if (!choice.equalsIgnoreCase("yes")) {

                            System.out.println(indent + RED + "Cancelled\n" + RESET);
                            break;
                        }

                        if (transactions.isEmpty()) {

                            System.out.println(indent + YELLOW +
                                    "No transactions yet\n" + RESET);

                        } else {

                            System.out.println("\n" + indent + BOLD + GREEN +
                                    "===== HISTORY =====" + RESET);

                            for (int i = 0; i < transactions.size(); i++) {
                                System.out.println(indent + (i + 1) + ". " + transactions.get(i));
                            }

                            System.out.println();
                        }
                    }

                    case 4 -> {

                        running = false;

                        System.out.println("\n" + indent + GREEN + BOLD +
                                "Thank you for using Transaction Log App" + RESET + "\n");
                    }

                    default -> System.out.println(indent + RED + "Invalid option\n" + RESET);
                }

                if (option != 4) {

                    System.out.print(indent + YELLOW +
                            "Do you want another transaction? (yes/no): " + RESET);

                    String answer = input.next();

                    if (!answer.equalsIgnoreCase("yes")) {

                        running = false;

                        System.out.println("\n" + indent + GREEN + BOLD +
                                "Thank you for using Transaction Log App" + RESET + "\n");
                    }
                }

            } catch (Exception e) {

                System.out.println(indent + RED + BOLD +
                        e.getMessage() + RESET + "\n");

            }
        }
    }
}
