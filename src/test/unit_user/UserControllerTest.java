package test.unit_user;

import main.enums.Department;
import main.enums.Role;
import main.user.UserController;
import main.user.UserModel;
import org.junit.Assert;
import org.junit.Test;

public class UserControllerTest {
    UserModel user = new UserModel(10, 0, Role.USER, Department.DEVELOPER, "testuser", "testpassword");
    UserController userController = new UserController();

    @Test
    public void testRequestForNewDepartment() {
        Assert.assertEquals("User department is incorrect", Department.DEVELOPER, user.getDepartment());
        userController.submitDepartmentChange(user, Department.HR);
        Assert.assertEquals("Requested department not changed", Department.HR, user.getRequestedNewDepartment());
    }

    @Test
    public void testRequestForTheSameDepartment() {
        Assert.assertEquals("User department is incorrect", Department.DEVELOPER, user.getDepartment());
        Assert.assertFalse("User changed to same department", userController.submitDepartmentChange(user, Department.DEVELOPER));
    }

    @Test
    public void testRequestForNewSalary() {
        Assert.assertEquals("User salary is incorrect", 10, user.getSalary());
        userController.submitSalaryChange(user, 15);
        Assert.assertEquals("Requested salary not changed", 15, user.getRequestedSalary());
    }

    @Test
    public void testRequestForTheSameSalary() {
        Assert.assertEquals("User salary is incorrect", 10, user.getSalary());
        Assert.assertFalse("User changed to same department", userController.submitSalaryChange(user, 10));
    }
}
