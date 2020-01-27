package test.unit_user;

import main.user.UserView;
import org.junit.Assert;
import org.junit.Test;

public class UserViewTest {
    UserView userView = new UserView();

    @Test
    public void testUserMenuInput() {

    }

    @Test
    public void testCorrectMenuChoice() {
        Assert.assertTrue("UserUI menuchoice not returning correct value", userView.correctMenuChoice("1"));
    }
}
