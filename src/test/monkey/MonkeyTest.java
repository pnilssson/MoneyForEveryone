package test.monkey;

import main.utils.GetInputs;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Random;

public class MonkeyTest {

    GetInputs getInput = new GetInputs();

    public String stringRandomMaker() {
        int leftLimit = 32; // letter 'a'
        int rightLimit = 126; // letter 'z'
        int targetStringLength = (int)(Math.random() * 100) + 1;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        System.out.println("random string = " + buffer.toString());
       return buffer.toString();
    }

    public boolean checkIfRandomStringIsOnlyNumbers(String input) {
        ArrayList<Boolean> isDigit = new ArrayList<>();

        for(Character c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                return false;
            }
            if(Character.isDigit(c)) {
                isDigit.add(true);
            } else {
                isDigit.add(false);
            }
        }
        return !isDigit.contains(false);
    }

    @Test
    public void monkeyCheckIfInputIsInt() {
        for (int i = 0; i < 10000; i++) {
            String randomString = stringRandomMaker();
            if(checkIfRandomStringIsOnlyNumbers(randomString)) {
                Assert.assertNotNull(getInput.checkIfInputIsInt(randomString));
            } else {
                Assert.assertNull(getInput.checkIfInputIsInt(randomString));
            }
        }
    }

    @Test
    public void monkeyGetRoleFromInput() {
        for(int i = 0; i < 10000; i++) {
            String randomString = stringRandomMaker();
            if(checkIfRandomStringIsOnlyNumbers(randomString)) {
                switch (randomString) {
                    case "1":
                    case "2":
                        Assert.assertNotNull(getInput.getRoleFromInput(randomString));
                        break;
                    default:
                        Assert.assertNull(getInput.getRoleFromInput(randomString));
                        break;
                }
            } else {
                Assert.assertNull(getInput.getRoleFromInput(randomString));
            }
        }
    }

    @Test
    public void monkeyGetDepartmentFromInput() {
        for(int i = 0; i < 10000; i++) {
            String randomString = stringRandomMaker();
            if(checkIfRandomStringIsOnlyNumbers(randomString)) {
                switch(randomString) {
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                        Assert.assertNotNull(getInput.getDepartmentFromInput(randomString));
                        break;
                    default:
                        Assert.assertNull(getInput.getDepartmentFromInput(randomString));
                        break;
                }
            } else {
                Assert.assertNull(getInput.getDepartmentFromInput(randomString));
            }
        }
    }

    @Test
    public void monkeyUsernameInput() {
        for(int i = 0; i < 10000; i++) {
            String username = stringRandomMaker();
            Assert.assertEquals("Incorrect username returned", username, getInput.usernameInput(username));
        }
    }

    @Test
    public void monkeyPasswordInput() {
        for(int i = 0; i < 10000; i++) {
            String password = stringRandomMaker();
            Assert.assertEquals("Incorrect password returned", password, getInput.usernameInput(password));
        }
    }

    @Test
    public void monkeyUsernameAndPasswordValidation() {
        for(int i = 0; i < 10000; i++) {
            String usernameValidation = stringRandomMaker();
            if(getInput.createAccountValidation(usernameValidation) == null) {
                Assert.assertNull(usernameValidation + " not returned", getInput.createAccountValidation(usernameValidation));
            }
            else {
                Assert.assertEquals(usernameValidation + " not returned", usernameValidation, getInput.createAccountValidation(usernameValidation));
            }
        }
    }
}
