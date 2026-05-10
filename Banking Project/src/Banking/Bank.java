package Banking;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;

    private List<Account> accounts = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public void deposit(int amount, int accountNumber) {

        Account account = findAccount(accountNumber);

        account.deposit(amount);
    }

    public void withdraw(int amount,
                         int accountNumber,
                         String pin) {

        Account account = findAccount(accountNumber);

        account.withdraw(amount, pin);
    }

    public void transfer(int senderAccountNumber,
                         int receiverAccountNumber,
                         int amount,
                         String pin) {

        Account sender = findAccount(senderAccountNumber);

        Account receiver = findAccount(receiverAccountNumber);

        sender.withdraw(amount, pin);

        receiver.deposit(amount);
    }

    public int checkBalance(int accountNumber,
                            String pin) {

        Account account = findAccount(accountNumber);

        return account.checkBalance(pin);
    }

    public Account registerCustomer(String name,
                                    String pin,
                                    int accountNumber) {

        for (Account account : accounts) {

            if (account.getNumber() == accountNumber) {

                throw new IllegalArgumentException(
                        "Account number already exists"
                );
            }
        }

        Account account = new Account(
                name,
                pin,
                accountNumber
        );

        accounts.add(account);

        return account;
    }

    public void removeAccount(int accountNumber,
                              String pin) {

        Account account = findAccount(accountNumber);

        account.checkBalance(pin);

        accounts.remove(account);
    }

    public Account findAccount(int accountNumber) {

        for (Account account : accounts) {

            if (account.getNumber() == accountNumber) {

                return account;
            }
        }

        throw new RuntimeException("Account not found");
    }
}