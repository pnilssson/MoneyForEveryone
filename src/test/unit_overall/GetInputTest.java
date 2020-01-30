package test.unit_overall;

import main.utils.GetInputs;
import main.enums.Department;
import main.enums.Role;
import org.junit.Assert;
import org.junit.Test;

public class GetInputTest {
    GetInputs getInput = new GetInputs();

    @Test
    public void testCheckIfInputIsInt() {
        Assert.assertEquals("Incorrect int returned", "1", getInput.checkIfInputIsInt("1"));
    }

    @Test
    public void testIfInputIsIntWithLetter() {
        Assert.assertNull(getInput.checkIfInputIsInt("k"));
        Assert.assertNull(getInput.checkIfInputIsInt("!"));
        Assert.assertNull(getInput.checkIfInputIsInt("."));
        Assert.assertNull(getInput.checkIfInputIsInt(""));
    }

    @Test
    public void testGetAdminRoleFromInput() {
        Assert.assertEquals("Admin role not returned", Role.ADMIN, getInput.getRoleFromInput("1"));
    }

    @Test
    public void testGetUserRoleFromInput() {
        Assert.assertEquals("User role not returned", Role.USER, getInput.getRoleFromInput("2"));
    }
    @Test
    public void testGetIncorrectRoleFromInput() {
        Assert.assertNull("Role returned", getInput.getRoleFromInput("K"));
    }

    @Test
    public void getDeveloperDepartmentFromInput() {
        Assert.assertEquals("Developer department not returned", Department.DEVELOPER, getInput.getDepartmentFromInput("1"));
    }

    @Test
    public void getHRDepartmentFromInput() {
        Assert.assertEquals("HR department not returned", Department.HR,getInput.getDepartmentFromInput("2"));
    }

    @Test
    public void getSupportDepartmentFromInput() {
        Assert.assertEquals("Support department not returned", Department.SUPPORT,getInput.getDepartmentFromInput("3"));
    }

    @Test
    public void getCEODepartmentFromInput() {
        Assert.assertEquals("CEO department not returned", Department.CEO,getInput.getDepartmentFromInput("4"));
    }

    @Test
    public void getIncorrectDepartmentFromInput() {
        Assert.assertNull("Department returned", getInput.getDepartmentFromInput("K"));
    }

    @Test
    public void testUsernameInput() {
        Assert.assertEquals("Incorrect username returned", "user", getInput.usernameInput("user"));
    }

    @Test
    public void testPasswordInput() {
        Assert.assertEquals("Incorrect password returned", "password", getInput.usernameInput("password"));
    }

    @Test
    public void testValidInputToValidate() {
        Assert.assertEquals("password1 not returned", "password1", getInput.createAccountValidation("password1"));
    }

    @Test
    public void testInvalidInputToValidate() {
        Assert.assertEquals("password returned", "", getInput.createAccountValidation("password"));
    }
}
