package test.system;

import main.account.CreateAccount;
import main.account.Login;
import main.account.RemoveAccount;
import main.admin.AdminController;
import main.admin.AdminModel;
import main.admin.AdminView;
import main.enums.Department;
import main.enums.Role;
import main.user.UserController;
import main.user.UserModel;
import main.utils.AccountList;
import org.junit.Assert;
import org.junit.Test;

public class SystemTest {

    Login login = new Login();
    UserModel user = new UserModel(10, 0, Role.USER, Department.DEVELOPER, "user1", "qwerty");
    AdminModel admin = new AdminModel(10, 0, Role.ADMIN, Department.SUPPORT, "admin1", "qwerty");
    UserController userController = new UserController();
    AdminView adminView = new AdminView();
    AdminController adminController = new AdminController();
    RemoveAccount removeAccount = new RemoveAccount();
    CreateAccount createAccount = new CreateAccount();

    @Test
    public void systemTest() {
        AccountList.accountArrayList.add(user);
        AccountList.accountArrayList.add(admin);
        // Requirement 1 - User requirements

        // Requirement 1a - Log in with a user
        Assert.assertEquals("Login method not returning account type", user, login.login("user1","qwerty"));

        // Requirement 1b - Check balance
        Assert.assertEquals("Balance is not 0", 0, user.getBalance());

        // Requirement 1c - Check salary
        Assert.assertEquals("Salary is not 10", 10, user.getSalary());

        // Requirement 1d - Check department
        Assert.assertEquals("Department is not developer", Department.DEVELOPER, user.getDepartment());

        // Requirement 1e - Request change of salary/department
        userController.submitDepartmentChange(user, Department.HR);
        Assert.assertEquals("Requested department not changed", Department.HR, user.getRequestedNewDepartment());


        // Requirement 2 - Admin

        // Requirement 2a - Log in with an admin
        Assert.assertEquals("Login method not returning account type", admin, login.login("admin1","qwerty"));
        // Requirement 2b - Check balance
        Assert.assertEquals("Balance is not 0", 0, admin.getBalance());
        // Requirement 2c - Check salary
        Assert.assertEquals("Salary is not 10", 10, admin.getSalary());
        // Requirement 2d - Check department
        Assert.assertEquals("Department is not support", Department.SUPPORT, admin.getDepartment());

        // Requirement 2 - Check users log in details
        adminView.displayUserDetails(user.getAccountId(), user.getUsername(), user.getPassword(), user.getRole(), user.getDepartment());
        Assert.assertEquals("username is not in list", "user1", AccountList.accountArrayList.get(0).getUsername() );
        Assert.assertEquals("password is not in list", "qwerty", AccountList.accountArrayList.get(0).getPassword());

        // Requirement 2 - Check requested changes
        Assert.assertTrue("Incorrect any Requests returned with new department requested", adminController.displayAllRequests());

        // Requirement 2 - Move calendar a month and payout salaries
        Assert.assertEquals("Incorrect balance from user", 0, user.getBalance());
        adminController.advanceCalendarAndPayout();
        Assert.assertEquals("Incorrect salary added to balance", 10, user.getBalance());

        // Requirement 2 - Create account, at least 1 letter and 1 number
        UserModel user2 = createAccount.createUser("user2", "qwerty1");
        AccountList.accountArrayList.add(user2);
        Assert.assertTrue("User is not added to account list", AccountList.accountArrayList.contains(user2));

        // Requirement 2 - Remove account admin
        removeAccount.removeAccount(admin, "user2", "qwerty1");
        Assert.assertFalse("User is not removed from account list", AccountList.accountArrayList.contains(user2));

        // Requirement 1f - Remove own user
        UserModel user3 = createAccount.createUser("user2", "qwerty1");
        AccountList.accountArrayList.add(user3);
        removeAccount.removeAccount(user3, "user2", "qwerty");

        AccountList.accountArrayList.clear();
    }
}
