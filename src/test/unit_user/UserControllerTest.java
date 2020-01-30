package test.unit_user;

import main.enums.Department;
import main.enums.Role;
import main.user.UserController;
import main.user.UserModel;
import org.junit.Assert;
import org.junit.Test;

public class UserControllerTest {
    UserModel user = new UserModel(1000, 0, Role.USER, Department.DEVELOPER, "testuser", "testpassword");
    UserController userController = new UserController();

    @Test
    public void testRequestForNewDepartment() {
        Assert.assertEquals("User department is incorrect", Department.DEVELOPER, user.getDepartment());
        userController.submitDepartmentChange(user, Department.HR);
        Assert.assertEquals("Requested department not changed", Department.HR, user.getRequestedNewDepartment());
    }

    @Test
    public void testRequestForNewSalary() {
        Assert.assertEquals("User salary is incorrect", 1000, user.getSalary());
        userController.submitSalaryChange(user, 9999);
        Assert.assertEquals("Requested salary not changed", 9999, user.getRequestedSalary());
    }

}
