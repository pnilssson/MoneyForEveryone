package test.unit_account;

import main.utils.AccountList;
import main.account.CreateAccount;
import main.enums.Role;
import org.junit.Assert;
import org.junit.Test;

public class CreateAccountTest {
    CreateAccount createAccount = new CreateAccount();

    @Test
    public void testCreateUserAccount() {
        Assert.assertEquals("Incorrect amount of account", 0, AccountList.accountArrayList.size());
        createAccount.createAccount(Role.USER, "user1", "test123");
        Assert.assertEquals("Incorrect amount of account", 1, AccountList.accountArrayList.size());

        AccountList.accountArrayList.clear();
    }

    @Test
    public void testCreateAdminAccount() {
        Assert.assertEquals("Incorrect amount of account", 0, AccountList.accountArrayList.size());
        createAccount.createAccount(Role.ADMIN, "admin1", "test123");
        Assert.assertEquals("Incorrect amount of account", 1, AccountList.accountArrayList.size());

        AccountList.accountArrayList.clear();
    }

    @Test
    public void testTakenUsername() {
        Assert.assertEquals("Incorrect amount of account", 0, AccountList.accountArrayList.size());
        createAccount.createAccount(Role.USER, "wictor1", "test123");
        Assert.assertEquals("Incorrect amount of account", 1, AccountList.accountArrayList.size());
        createAccount.createAccount(Role.USER, "wictor1", "test123");
        Assert.assertEquals("Incorrect amount of account", 1, AccountList.accountArrayList.size());

        AccountList.accountArrayList.clear();
    }
}
