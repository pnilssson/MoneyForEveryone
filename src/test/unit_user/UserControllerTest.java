package test.unit_user;

import main.account.AccountList;
import main.account.RemoveAccount;
import main.enums.Department;
import main.enums.Role;
import main.user.UserController;
import main.user.UserModel;
import org.junit.Assert;
import org.junit.Test;

public class UserControllerTest {
    RemoveAccount removeAccount = new RemoveAccount();
    UserModel user = new UserModel(1000, 0, Role.USER, Department.DEVELOPER, "testuser", "testpassword");
    UserController userController = new UserController();

    @Test
    public void testRequestForNewRole() {
        Assert.assertEquals("User role is incorrect", Role.USER, user.getRole());
        userController.submitDepartmentChange(user, Department.DEVELOPER);
        Assert.assertEquals("Requested role not changed", Department.DEVELOPER, user.getRequestedNewDepartment());
    }
    @Test
    public void testRequestForNewSalary() {
        Assert.assertEquals("User salary is incorrect", 1000, user.getSalary());
        userController.submitSalaryChange(user, 9999);
        Assert.assertEquals("Requested salary not changed", 9999, user.getRequestedSalary());
    }

}
