package test.unit_account;

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
    public void menuIncorrectInput() {
        Assert.assertEquals("Menu incorrect input check", true, menu.menuChoice("k"));
    }
}
