package test.integration;

import main.admin.AdminController;
import main.enums.Department;
import main.enums.Role;
import main.user.UserController;
import main.user.UserModel;
import main.utils.AccountList;
import org.junit.Assert;
import org.junit.Test;

public class SalaryTest {
    UserModel user = new UserModel(10, 0, Role.USER, Department.DEVELOPER, "testuser", "testpassword");
    UserController userController = new UserController();
    AdminController adminController = new AdminController();

    @Test
    public void testRequestSalaryAndApply() {
        Assert.assertEquals("User salary is incorrect", 10, user.getSalary());

        userController.submitSalaryChange(user, 20);
        Assert.assertEquals("Requested salary not changed", 20, user.getRequestedSalary());
        AccountList.accountArrayList.add(user);

        Assert.assertTrue("Incorrect any Requests returned with new salary requested", adminController.displayAllRequests());

        adminController.acceptSalaryChange(user);
        Assert.assertEquals("Salary is not changed", 20, user.getSalary());
    }

    @Test
    public void testRequestSalaryAndDecline() {
        Assert.assertEquals("User salary is incorrect", 10, user.getSalary());

        userController.submitSalaryChange(user, 20);
        Assert.assertEquals("Requested salary not changed", 20, user.getRequestedSalary());
        AccountList.accountArrayList.add(user);

        Assert.assertTrue("Incorrect any Requests returned with new salary requested", adminController.displayAllRequests());

        adminController.declineSalaryChange(user);
        Assert.assertEquals("Salary is not changed", 10, user.getSalary());
    }
}
