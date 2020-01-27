package test.unit_account;

import main.Login;
import main.Role;
import main.account.Account;
import main.account.AccountList;
import main.user.UserModel;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest {
    Login login = new Login();
    UserModel user = new UserModel(10, 0, Role.USER, "user1", "qwerty");
    Account account = user;

    @Test
    public void loginTest() {
        Assert.assertNull("Login method not returning null when wrong username/password used", login.login(user.getUsername(), user.getPassword()));
        AccountList.accountArrayList.add(user);
        Assert.assertEquals("Login method not returning account type", account, login.login(user.getUsername(), user.getPassword()));
    }

    @Test
    public void testUsernameInput() {
        Assert.assertEquals("Incorrect username returned", "user", login.usernameInput("user"));
    }

    @Test
    public void testPasswordInput() {
        Assert.assertEquals("Incorrect password returned", "password", login.usernameInput("password"));
    }

    @Test
    public void testLaunchMainMenu() {

    }
}
