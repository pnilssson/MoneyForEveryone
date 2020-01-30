package test.unit_admin;

import main.admin.AdminView;
import org.junit.Assert;
import org.junit.Test;

public class AdminViewTest {
    AdminView adminView = new AdminView();

    @Test
    public void testCorrectMenuChoice() {
        Assert.assertTrue("AdminUI menu choice not returning correct value", adminView.correctAdminMenuChoice("1"));
    }

    @Test
    public void testIncorrectMenuChoice() {
        Assert.assertFalse("AdminUI menu choice not returning correct value", adminView.correctAdminMenuChoice("k"));
    }
}
