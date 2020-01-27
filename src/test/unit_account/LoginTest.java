package test.unit_account;

import main.Login;
import main.Role;
import main.account.Account;
import main.user.UserModel;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest {
    Login login = new Login();
    Account account;
    UserModel user = new UserModel(10, 0, Role.USER, "user1", "qwerty");

    @Test
    public void loginTest() {
        Assert.assertEquals("Login method not returning account type", account, login.login("user1", "qwerty"));
        Assert.assertNull("Login method not returning null when wrong username/password used", login.login("1", "1"));
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
