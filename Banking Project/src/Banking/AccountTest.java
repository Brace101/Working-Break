package Banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testDeposit() {
        Account account = new Account("Lekan", "1234", 1);

        account.deposit(5000);

        assertEquals(5000, account.checkBalance("1234"));
    }

    @Test
    public void testWithdraw() {
        Account account = new Account("Lekan", "1234", 1);

        account.deposit(5000);
        account.withdraw(2000, "1234");

        assertEquals(3000, account.checkBalance("1234"));
    }

    @Test
    public void testInvalidPin() {
        Account account = new Account("Lekan", "1234", 1);

        assertThrows(InvalidPinException.class,
                () -> account.checkBalance("0000"));
    }

    @Test
    public void testInsufficientFunds() {
        Account account = new Account("Lekan", "1234", 1);

        assertThrows(InsufficientFundsException.class,
                () -> account.withdraw(1000, "1234"));
    }
}
