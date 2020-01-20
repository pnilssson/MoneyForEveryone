package test.unit_account;

import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {

    AccountTestClass atc = new AccountTestClass();

    @Test
    public void testBalance() {
        assertEquals(atc.checkBalance("Hej"), "Hej");
    }

    @Test
    public void testSalary() {
        assertEquals(atc.checkBalance("Hej"), "Hej");
    }
    @Test
    public void testRole() {
        assertEquals(atc.checkBalance("Hej"), "Hej");
    }
    @Test
    public void testLogin() {
        assertEquals(atc.checkBalance("Hej"), "Hej");
    }
    @Test
    public void testRemoveAccount() {
        assertEquals(atc.checkBalance("Hej"), "Hej");
    }

}
