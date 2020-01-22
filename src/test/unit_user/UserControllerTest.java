package test.unit_user;

import main.Role;
import main.account.AccountList;
import main.user.UserModel;

public class UserControllerTest {
    UserModel user = new UserModel(1000, 0, Role.USER, "testuser", "testpassword");

    public void testRequestForNewRole() {

    }

    public void testRequestForNewSalary() {

    }

    public void testRemoveAccount() {
        AccountList.accountArrayList.add(user);

    }
}
