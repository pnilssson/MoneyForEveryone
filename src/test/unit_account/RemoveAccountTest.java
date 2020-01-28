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

    CreateAccount createAccount = new CreateAccount();
    RemoveAccount removeAccount = new RemoveAccount();

    @Test
    public void testUserRemoveAccount() {
        Assert.assertEquals("Incorrect amount of account", AccountList.accountArrayList.size(), 0);
        createAccount.createAccount(Role.USER, "user123", "test123");
        Assert.assertEquals("Incorrect amount of account", AccountList.accountArrayList.size(), 1);
        UserModel user = (UserModel) AccountList.accountArrayList.get(AccountList.accountArrayList.size() -1);
        removeAccount.removeAccount(user, "user123", "test123");
        Assert.assertEquals("Incorrect amount of account", AccountList.accountArrayList.size(), 0);
        AccountList.accountArrayList.clear();
    }

    @Test
    public void testAdminRemoveAccount() {
        Assert.assertEquals("Incorrect amount of account", AccountList.accountArrayList.size(), 0);
        createAccount.createAccount(Role.USER, "user123", "test123");
        createAccount.createAccount(Role.ADMIN, "admin123", "test123");
        Assert.assertEquals("Incorrect amount of account", AccountList.accountArrayList.size(), 2);
        AdminModel admin =  (AdminModel) AccountList.accountArrayList.get(AccountList.accountArrayList.size() -1);
        removeAccount.removeAccount(admin, "user123", "test123");
        Assert.assertEquals("Incorrect amount of account", AccountList.accountArrayList.size(), 1);
        AccountList.accountArrayList.clear();
    }

    @Test
    public  void testAdminRemoveAccountSelf() {
        Assert.assertEquals("Incorrect amount of account", AccountList.accountArrayList.size(), 0);
        createAccount.createAccount(Role.ADMIN, "admin123", "test123");
        Assert.assertEquals("Incorrect amount of account", AccountList.accountArrayList.size(), 1);
        AdminModel admin =  (AdminModel) AccountList.accountArrayList.get(AccountList.accountArrayList.size() -1);
        removeAccount.removeAccount(admin, "admin123", "test123");
        Assert.assertEquals("Incorrect amount of account", AccountList.accountArrayList.size(), 1);
        AccountList.accountArrayList.clear();
    }
}
