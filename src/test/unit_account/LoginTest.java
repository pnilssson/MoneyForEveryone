package test.unit_account;

import main.Menu;
import main.Role;
import main.User;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest {
    Menu menu = new Menu();

    @Test
    public void loginTest() {
        Assert.assertEquals("Menu incorrect input check", true, menu.menuChoice("1"));
        User user = new User(10, 0, Role.USER, "user1", "qwerty");
    }
}
