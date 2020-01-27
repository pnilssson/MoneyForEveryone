package test.unit_user;

import main.Role;
import main.account.AccountList;
import main.account.RemoveAccount;
import main.user.UserController;
import main.user.UserModel;
import org.junit.Assert;
import org.junit.Test;

public class UserControllerTest {
    RemoveAccount removeAccount = new RemoveAccount();
    UserModel user = new UserModel(1000, 0, Role.USER, "testuser", "testpassword");
    UserController userController = new UserController();

    @Test
    public void testRequestForNewRole() {
        Assert.assertEquals("User role is incorrect", Role.USER, user.getRole());
        userController.submitRoleChange(user, Role.DEVELOPER);
        Assert.assertEquals("Requested role not changed", Role.DEVELOPER, user.getRequestedNewRole());
    }
    @Test
    public void testRequestForNewSalary() {
        Assert.assertEquals("User salary is incorrect", 1000, user.getSalary());
        userController.submitSalaryChange(user, 9999);
        Assert.assertEquals("Requested salary not changed", 9999, user.getRequestedSalary());
    }

    @Test
    public void testRemoveAccount() {
        AccountList.accountArrayList.add(user);
        Assert.assertTrue("User not added to account list", AccountList.accountArrayList.contains(user));
        removeAccount.executeAccountDeletion(user,"testuser", "testpassword");
        Assert.assertFalse("User not removed from account list", AccountList.accountArrayList.contains(user));
    }
}
