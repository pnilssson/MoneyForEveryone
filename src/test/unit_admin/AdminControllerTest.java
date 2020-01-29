package test.unit_admin;

import main.account.AccountList;
import main.admin.AdminController;
import main.enums.Department;
import main.enums.Role;
import main.user.UserModel;
import org.junit.Assert;
import org.junit.Test;

public class AdminControllerTest {
    AdminController adminController = new AdminController();
    UserModel user = new UserModel(10, 0, Role.USER, Department.DEVELOPER, "user1", "qwerty");

    @Test
    public void testAdvanceCalenderAndPayout() {
        AccountList.accountArrayList.add(user);
        Assert.assertEquals("Incorrect balance from user", 0, user.getBalance());
        adminController.advanceCalendarAndPayout();
        Assert.assertEquals("Incorrect salary added to balance", 10, user.getBalance());
    }

    @Test
    public void testDisplayAllRequests() {
        AccountList.accountArrayList.add(user);
        Assert.assertFalse("Incorrect anyRequests returned with no changes", adminController.displayAllRequests());
        user.setRequestedNewDepartment(Department.CEO);
        Assert.assertTrue("Incorrect anyRequests returned with new department requested", adminController.displayAllRequests());
    }

    @Test
    public void testRequestedChanges() {

    }
}
