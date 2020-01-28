package test.unit_overall;

import main.GetInputs;
import org.junit.Assert;
import org.junit.Test;

public class GetInputTest {
    GetInputs getInput = new GetInputs();

    @Test
    public void testGetIntFromInput() {
        //TODO
    }

    @Test
    public void testGetRoleFromInput() {
        //TODO
    }

    @Test
    public void getDepartmentFromInput() {
        //TODO
    }

    @Test
    public void testUsernameInput() {
        Assert.assertEquals("Incorrect username returned", "user", getInput.usernameInput("user"));
    }

    @Test
    public void testPasswordInput() {
        Assert.assertEquals("Incorrect password returned", "password", getInput.usernameInput("password"));
    }
}
