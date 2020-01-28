package test.unit_account;

import main.account.Account;
import main.account.AccountList;
import main.account.CreateAccount;
import main.account.RemoveAccount;
import main.admin.AdminModel;
import main.enums.Role;
import main.user.UserModel;
import org.junit.Assert;
import org.junit.Test;

public class RemoveAccountTest {
    RemoveAccount removeAccount = new RemoveAccount();

    UserModel user = new UserModel("user123", "test123");
    AdminModel admin = new AdminModel("admin123", "test123");

    @Test
    public void testUserRemoveAccount() {
        AccountList.accountArrayList.add(user);

        Assert.assertTrue("User not added to account list", AccountList.accountArrayList.contains(user));
        removeAccount.removeAccount(user,"user123", "test123");
        Assert.assertFalse("User not removed from account list", AccountList.accountArrayList.contains(user));

        AccountList.accountArrayList.clear();
    }

    @Test
    public void testAdminRemoveAccount() {
        AccountList.accountArrayList.add(user);
        AccountList.accountArrayList.add(admin);

        Assert.assertTrue("User not added to account list", AccountList.accountArrayList.contains(user));
        Assert.assertTrue("Admin not added to account list", AccountList.accountArrayList.contains(admin));

        removeAccount.removeAccount(admin,"user123", "test123");

        Assert.assertFalse("User not removed from account list", AccountList.accountArrayList.contains(user));
        Assert.assertTrue("Admin removed from account list", AccountList.accountArrayList.contains(admin));

        AccountList.accountArrayList.clear();

    }

    @Test
    public  void testAdminRemoveAccountSelf() {
        AccountList.accountArrayList.add(admin);

        Assert.assertTrue("User not added to account list", AccountList.accountArrayList.contains(admin));

        removeAccount.removeAccount(admin,"admin123", "test123");

        Assert.assertTrue("Admin removed from account list", AccountList.accountArrayList.contains(admin));

        AccountList.accountArrayList.clear();
    }
}
