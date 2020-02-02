package test.unit_account;

import main.admin.AdminModel;
import main.user.UserModel;
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
    public void testCreateUser() {
        UserModel user2 = createAccount.createUser("user2", "qwerty1");
        AccountList.accountArrayList.add(user2);
        Assert.assertTrue("User is not added to account list", AccountList.accountArrayList.contains(user2));


        AccountList.accountArrayList.clear();
    }

    @Test
    public void testCreateAdmin() {
        AdminModel user2 = createAccount.createAdmin("user2", "qwerty1");
        AccountList.accountArrayList.add(user2);
        Assert.assertTrue("User is not added to account list", AccountList.accountArrayList.contains(user2));

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
