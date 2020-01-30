package test.integration;

import main.admin.AdminController;
import main.enums.Department;
import main.enums.Role;
import main.user.UserController;
import main.user.UserModel;
import main.utils.AccountList;
import org.junit.Assert;
import org.junit.Test;

public class DepartmentTest {
    UserModel user = new UserModel(10, 0, Role.USER, Department.DEVELOPER, "testuser", "testpassword");
    UserController userController = new UserController();
    AdminController adminController = new AdminController();

    @Test
    public void testRequestDepartmentAndApply() {
        Assert.assertEquals("User department is incorrect", Department.DEVELOPER, user.getDepartment());

        userController.submitDepartmentChange(user, Department.HR);
        Assert.assertEquals("Requested department not changed", Department.HR, user.getRequestedNewDepartment());
        AccountList.accountArrayList.add(user);

        Assert.assertTrue("Incorrect any Requests returned with new department requested", adminController.displayAllRequests());

        adminController.acceptDepartmentChange(user);
        Assert.assertEquals("Department is not changed", Department.HR, user.getDepartment());
    }

    @Test
    public void testRequestDepartmentAndDecline() {
        Assert.assertEquals("User department is incorrect", Department.DEVELOPER, user.getDepartment());

        userController.submitDepartmentChange(user, Department.HR);
        Assert.assertEquals("Requested department not changed", Department.HR, user.getRequestedNewDepartment());
        AccountList.accountArrayList.add(user);

        Assert.assertTrue("Incorrect any Requests returned with new department requested", adminController.displayAllRequests());

        adminController.declineDepartmentChange(user);
        Assert.assertEquals("Department is not changed", Department.DEVELOPER, user.getDepartment());
    }


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
