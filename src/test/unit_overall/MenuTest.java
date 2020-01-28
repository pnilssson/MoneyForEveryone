package test.unit_overall;

import main.Menu;
import org.junit.Assert;
import org.junit.Test;

public class MenuTest {
    Menu menu = new Menu();

    @Test
    public void menuExit() {
        Assert.assertFalse("Menu exit check", menu.menuChoice("0"));
    }

    @Test
    public void testMenuChoice() {
        Assert.assertTrue("Menu incorrect input check", menu.menuChoice("k"));
        Assert.assertFalse("MenuChoice returning incorrect boolean", menu.menuChoice("0"));
    }
}
