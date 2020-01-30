package test.unit_overall;

import main.utils.GetInputs;
import main.enums.Department;
import main.enums.Role;
import org.junit.Assert;
import org.junit.Test;

public class GetInputTest {
    GetInputs getInput = new GetInputs();

    @Test
    public void testGetIntFromInput() {
        Assert.assertEquals("Incorrect int returned", "1", getInput.getIntFromInput("1"));
    }

    @Test
    public void testGetRoleFromInput() {
        Assert.assertEquals("Incorrect role returned", Role.ADMIN, getInput.getRoleFromInput("1"));
    }

    @Test
    public void getDepartmentFromInput() {
        Assert.assertEquals("Incorrect department returned", Department.HR,getInput.getDepartmentFromInput("2"));
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
