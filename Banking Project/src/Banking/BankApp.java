package Banking;

import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Bank bank = new Bank("Semicolon Bank");

        boolean running = true;

        while (running) {

            System.out.println("\n===== SEMICOLON BANK =====");
            System.out.println("1. Register Customer");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer Money");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = input.nextInt();

            try {
                switch (option) {

                    case 1:
                        input.nextLine();

                        System.out.print("Enter name: ");
                        String name = input.nextLine();

                        System.out.print("Enter pin: ");
                        String pin = input.nextLine();

                        System.out.print("Enter account number: ");
                        int accountNumber = input.nextInt();

                        bank.registerCustomer(name, pin, accountNumber);

                        System.out.println("Customer registered successfully");
                        break;

                    case 2:
                        System.out.print("Enter account number: ");
                        int depositAccount = input.nextInt();

                        System.out.print("Enter amount: ");
                        int depositAmount = input.nextInt();

                        bank.deposit(depositAmount, depositAccount);

                        System.out.println("Deposit successful");
                        break;

                    case 3:
                        System.out.print("Enter account number: ");
                        int withdrawAccount = input.nextInt();

                        System.out.print("Enter amount: ");
                        int withdrawAmount = input.nextInt();

                        System.out.print("Enter pin: ");
                        String withdrawPin = input.next();

                        bank.withdraw(withdrawAmount, withdrawAccount, withdrawPin);

                        System.out.println("Withdrawal successful");
                        break;

                    case 4:
                        System.out.print("Enter account number: ");
                        int balanceAccount = input.nextInt();

                        System.out.print("Enter pin: ");
                        String balancePin = input.next();

                        int balance = bank.checkBalance(balanceAccount, balancePin);

                        System.out.println("Your balance is: " + balance);
                        break;

                    case 5:
                        System.out.print("Enter sender account number: ");
                        int sender = input.nextInt();

                        System.out.print("Enter receiver account number: ");
                        int receiver = input.nextInt();

                        System.out.print("Enter amount: ");
                        int transferAmount = input.nextInt();

                        System.out.print("Enter sender pin: ");
                        String transferPin = input.next();

                        bank.transfer(sender, receiver, transferAmount, transferPin);

                        System.out.println("Transfer successful");
                        break;

                    case 6:
                        running = false;
                        System.out.println("Thank you for banking with us");
                        break;

                    default:
                        System.out.println("Invalid option");
                }

            } catch (Exception error) {
                System.out.println(error.getMessage());
            }
        }

    }
}