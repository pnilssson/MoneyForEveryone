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
    UserModel user = new UserModel(10, 0, Role.USER, Department.DEVELOPER, "user1", "qwerty");
    Account account = user;

    @Test
    public void loginTest() {
        Assert.assertNull("Login method not returning null when wrong username/password used", login.login(user.getUsername(), user.getPassword()));
        AccountList.accountArrayList.add(user);
        Assert.assertEquals("Login method not returning account type", account, login.login(user.getUsername(), user.getPassword()));
    }
}
