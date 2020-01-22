package test.unit_user;

import main.Role;
import main.user.UserModel;
import main.user.UserView;
import org.junit.Assert;
import org.junit.Test;

public class UserViewTest {
    UserModel user = new UserModel(1000, 0, Role.USER, "testuser", "testpassword");
    UserView userView = new UserView();

    @Test
    public void testUserMenuInput() {

    }

    @Test
    public void testCorrectMenuChoice() {
        Assert.assertTrue("UserUI menuchoice not returning correct value", userView.correctMenuChoice("1"));
    }
}
