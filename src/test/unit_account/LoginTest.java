package test.unit_account;

import main.Menu;
import main.Role;
import main.user.UserModel;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest {
    Menu menu = new Menu();

    @Test
    public void loginTest() {
        Assert.assertEquals("Menu incorrect input check", true, menu.menuChoice("1"));
        UserModel user = new UserModel(10, 0, Role.USER, "user1", "qwerty");
    }
}
