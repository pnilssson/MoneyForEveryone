package test.unit_account;

import main.account.Login;
import main.account.Account;
import main.utils.AccountList;
import main.enums.Department;
import main.enums.Role;
import main.user.UserModel;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest {
    Login login = new Login();
    UserModel user = new UserModel(10, 0, Role.USER, Department.DEVELOPER, "createAccountUser1", "qwerty");

    @Test
    public void loginSuccessTest() {
        AccountList.accountArrayList.add(user);
        Assert.assertEquals("Login method not returning account type", user, login.login("createAccountUser1","qwerty"));

        AccountList.accountArrayList.clear();
    }

    @Test
    public void loginWithNoUserTest() {
        Assert.assertNull("Login method not returning null when wrong username/password used", login.login("createAccountUser1", "qwerty"));
    }

    @Test
    public void loginWrongInputTest() {
        AccountList.accountArrayList.add(user);
        Assert.assertNull("Login method not returning null when wrong username/password used", login.login("createAccountUser2", "qwerty"));

        AccountList.accountArrayList.clear();
    }
}
