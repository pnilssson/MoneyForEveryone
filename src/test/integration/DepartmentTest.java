package test.integration;

import main.admin.AdminController;
import main.enums.Role;
import main.user.UserController;
import main.user.UserModel;
import main.utils.AccountList;
import org.junit.Assert;
import org.junit.Test;

public class DepartmentTest {
    UserModel user = new UserModel(10, 0, Role.USER, main.enums.Department.DEVELOPER, "testuser", "testpassword");
    UserController userController = new UserController();
    AdminController adminController = new AdminController();

    @Test
    public void testRequestDepartmentAndApply() {
        Assert.assertEquals("User department is incorrect", main.enums.Department.DEVELOPER, user.getDepartment());
        userController.submitDepartmentChange(user, main.enums.Department.HR);
        Assert.assertEquals("Requested department not changed", main.enums.Department.HR, user.getRequestedNewDepartment());

        AccountList.accountArrayList.add(user);
        user.setRequestedNewDepartment(main.enums.Department.CEO);
        Assert.assertTrue("Incorrect any Requests returned with new department requested", adminController.displayAllRequests());

    }
}
