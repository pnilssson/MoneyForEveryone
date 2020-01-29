package test.unit_admin;

import main.admin.AdminView;
import org.junit.Assert;
import org.junit.Test;

public class AdminViewTest {
    AdminView adminView = new AdminView();

    @Test
    public void testCorrectMenuChoice() {
        Assert.assertTrue("UserUI menuchoice not returning correct value", adminView.correctAdminMenuChoice("1"));
        Assert.assertFalse("UserUI menuchoice not returning correct value", adminView.correctAdminMenuChoice("k"));
    }
}
