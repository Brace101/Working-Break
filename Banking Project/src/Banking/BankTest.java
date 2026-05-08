package Banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    public void testRegisterCustomer() {
        Bank bank = new Bank("MyBank");

        Account account = bank.registerCustomer("John", "1234", 1);

        assertNotNull(account);
    }

    @Test
    public void testDeposit() {
        Bank bank = new Bank("MyBank");

        bank.registerCustomer("John", "1234", 1);
        bank.deposit(4000, 1);

        assertEquals(4000, bank.checkBalance(1, "1234"));
    }

    @Test
    public void testTransfer() {
        Bank bank = new Bank("MyBank");

        bank.registerCustomer("John", "1234", 1);
        bank.registerCustomer("Mary", "4321", 2);

        bank.deposit(5000, 1);

        bank.transfer(1, 2, 2000, "1234");

        assertEquals(3000, bank.checkBalance(1, "1234"));
        assertEquals(2000, bank.checkBalance(2, "4321"));
    }
}
