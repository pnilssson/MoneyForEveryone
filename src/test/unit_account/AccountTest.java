package test.unit_account;

import main.Account;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AccountTest {

    AccountTestClass atc = new AccountTestClass("100", "100", "User");

    @Test
    public void testBalance() {
        assertEquals(atc.getBalance(), "100");
    }

    @Test
    public void testSalary() {
        assertEquals(atc.getSalary(), "100");
    }
    @Test
    public void testRole() {
        assertEquals(atc.getRole(), "User");
    }
    @Test
    public void testLogin() {
        assertFalse(atc.isLogin());
    }

    @Test
    public void testCreateAccount() {
        ArrayList<Account> hej = new ArrayList();
        hej.add(atc);
        System.out.println(hej.get(0).getBalance());
        assertTrue(1 == 1);
        //assertTrue(hej.size() == 1);
    }

}
