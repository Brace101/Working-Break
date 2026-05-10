package Banking;

import java.util.Scanner;

public class BankApp {

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

        Bank bank = new Bank("Semicolon Bank");

        boolean running = true;

        while (running) {

            System.out.println(indent + BOLD + GREEN + "===== SEMICOLON BANK =====" + RESET);

            System.out.println(indentOne + CYAN + "1. Register Customer" + RESET);
            System.out.println(indentOne + CYAN + "2. Deposit" + RESET);
            System.out.println(indentOne + CYAN + "3. Withdraw" + RESET);
            System.out.println(indentOne + CYAN + "4. Check Balance" + RESET);
            System.out.println(indentOne + CYAN + "5. Transfer Money" + RESET);
            System.out.println(indentOne + CYAN + "6. Exit" + RESET);

            System.out.print(indent + YELLOW + BOLD + "Choose an option: " + RESET);
            int option = input.nextInt();

            try {

                switch (option) {

                    case 1:

                        input.nextLine();

                        System.out.println("\n" + indent + PURPLE + "===== CUSTOMER REGISTRATION =====" + RESET);

                        System.out.print(indentOne + CYAN + "Enter name: " + RESET);
                        String name = input.nextLine();

                        System.out.print(indentOne + CYAN + "Enter pin: " + RESET);
                        String pin = input.nextLine();

                        System.out.print(indentOne + CYAN + "Enter account number: " + RESET);
                        int accountNumber = input.nextInt();

                        bank.registerCustomer(name, pin, accountNumber);

                        System.out.println("\n" + indent + GREEN + BOLD +
                                "Customer registered successfully" + RESET + "\n");
                        break;

                    case 2:

                        System.out.println("\n" + indent + PURPLE + "===== DEPOSIT MONEY =====" + RESET);

                        System.out.print(indentOne + CYAN + "Enter account number: " + RESET);
                        int depositAccount = input.nextInt();

                        System.out.print(indentOne + CYAN + "Enter amount: " + RESET);
                        int depositAmount = input.nextInt();

                        bank.deposit(depositAmount, depositAccount);

                        System.out.println("\n" + indent + GREEN + BOLD +
                                "Deposit successful" + RESET + "\n");
                        break;

                    case 3:

                        System.out.println("\n" + indent + PURPLE + "===== WITHDRAW MONEY =====" + RESET);

                        System.out.print(indentOne + CYAN + "Enter account number: " + RESET);
                        int withdrawAccount = input.nextInt();

                        System.out.print(indentOne + CYAN + "Enter amount: " + RESET);
                        int withdrawAmount = input.nextInt();

                        System.out.print(indentOne + CYAN + "Enter pin: " + RESET);
                        String withdrawPin = input.next();

                        bank.withdraw(withdrawAmount, withdrawAccount, withdrawPin);

                        System.out.println("\n" + indent + GREEN + BOLD +
                                "Withdrawal successful" + RESET + "\n");
                        break;

                    case 4:

                        System.out.println("\n" + indent + PURPLE + "===== CHECK BALANCE =====" + RESET);

                        System.out.print(indentOne + CYAN + "Enter account number: " + RESET);
                        int balanceAccount = input.nextInt();

                        System.out.print(indentOne + CYAN + "Enter pin: " + RESET);
                        String balancePin = input.next();

                        int balance = bank.checkBalance(balanceAccount, balancePin);

                        System.out.println("\n" + indent + YELLOW + BOLD +
                                "Your balance is: " + balance + RESET + "\n");
                        break;

                    case 5:

                        System.out.println("\n" + indent + PURPLE + "===== TRANSFER MONEY =====" + RESET);

                        System.out.print(indentOne + CYAN + "Enter sender account number: " + RESET);
                        int sender = input.nextInt();

                        System.out.print(indentOne + CYAN + "Enter receiver account number: " + RESET);
                        int receiver = input.nextInt();

                        System.out.print(indentOne + CYAN + "Enter amount: " + RESET);
                        int transferAmount = input.nextInt();

                        System.out.print(indentOne + CYAN + "Enter sender pin: " + RESET);
                        String transferPin = input.next();

                        bank.transfer(sender, receiver, transferAmount, transferPin);

                        System.out.println("\n" + indent + GREEN + BOLD +
                                "Transfer successful" + RESET + "\n");
                        break;

                    case 6:

                        running = false;

                        System.out.println("\n" + indent + RED + BOLD +
                                "Thank you for banking with us" + RESET + "\n");
                        continue;

                    default:

                        System.out.println("\n" + indent + RED + BOLD +
                                "Invalid option" + RESET + "\n");
                }

                System.out.print(indent + YELLOW + "Do you want another transaction? (yes/no): ");
                String answer = input.next();

                if (!answer.equalsIgnoreCase("yes")) {

                    running = false;

                    System.out.println("\n" + indent + GREEN + BOLD +
                            "Thank you for banking with us 🙏" + RESET + "\n");
                }

            } catch (Exception error) {

                System.out.println("\n" + indent + RED + BOLD +
                        error.getMessage() + RESET + "\n");
            }
        }
    }
}