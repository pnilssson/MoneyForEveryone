package test.unit_user;

import main.user.UserView;
import org.junit.Assert;
import org.junit.Test;

public class UserViewTest {
    UserView userView = new UserView();

    @Test
    public void testCorrectMenuChoice() {
        Assert.assertTrue("UserUI menu choice not returning correct value", userView.correctUserMenuChoice("1"));
    }

    @Test
    public void testIncorrectMenuChoice() {
        Assert.assertFalse("UserUI menu choice not returning correct value", userView.correctUserMenuChoice("k"));
    }
}
