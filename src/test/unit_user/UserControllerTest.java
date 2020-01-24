package test.unit_user;

import main.Role;
import main.account.AccountList;
import main.user.UserController;
import main.user.UserModel;
import org.junit.Assert;
import org.junit.Test;

public class UserControllerTest {
    UserModel user = new UserModel(1000, 0, Role.USER, "testuser", "testpassword");
    UserController userController = new UserController();

    @Test
    public void testRequestForNewRole() {

    }
    @Test
    public void testRequestForNewSalary() {

    }

    @Test
    public void testRemoveAccount() {
        AccountList.accountArrayList.add(user);
        Assert.assertTrue("User not added to account list", AccountList.accountArrayList.contains(user));
        userController.executeAccountDeletion(user,"testuser", "testpassword");
        Assert.assertFalse("User not removed from account list", AccountList.accountArrayList.contains(user));
    }
}
