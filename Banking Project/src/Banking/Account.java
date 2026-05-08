package Banking;

public class Account {

    private String name;
    private int balance;
    private String pin;
    private int number;

    public Account(String name, String pin, int number) {
        this.name = name;
        this.pin = pin;
        this.number = number;
        this.balance = 0;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero");
        }

        balance += amount;
    }

    public void withdraw(int amount, String pin) {
        validatePin(pin);

        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        balance -= amount;
    }

    public int checkBalance(String pin) {
        validatePin(pin);
        return balance;
    }

    private void validatePin(String pin) {
        if (!this.pin.equals(pin)) {
            throw new InvalidPinException("Invalid pin");
        }
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
