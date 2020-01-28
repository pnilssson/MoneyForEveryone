package test.unit_account;

import main.account.AccountList;
import main.account.CreateAccount;
import main.enums.Department;
import main.enums.Role;
import main.user.UserModel;
import org.junit.Assert;
import org.junit.Test;

public class CreateAccountTest {
    CreateAccount createAccount = new CreateAccount();
    UserModel user = new UserModel(10, 0, Role.USER, Department.DEVELOPER, "user1", "qwerty");

    @Test
    public void testCreateAccount() {
        Assert.assertEquals("Incorrect amount of account", AccountList.accountArrayList.size(), 0);
        createAccount.createAccount(Role.USER, "user123", "test123");
        Assert.assertEquals("Incorrect amount of account", AccountList.accountArrayList.size(), 1);
        createAccount.createAccount(Role.ADMIN, "admin123", "test123");
        Assert.assertEquals("Incorrect amount of account", AccountList.accountArrayList.size(), 2);
    }
}
