package main;

import main.enums.Department;
import main.enums.Role;
import java.util.InputMismatchException;

public class GetInputs {

     public String checkIfInputIsInt(String input) {
         int convertInputToInt;
         try{
             convertInputToInt = Integer.parseInt(input);
             input = String.valueOf(convertInputToInt);
         } catch (InputMismatchException | NumberFormatException | NullPointerException e) {
            input = null;
         }
         return input;
    }

    public int convertStringToInt(String string) {
         return Integer.parseInt(string);
    }

    public Enum<Role> getRoleFromInput(String input){
        Enum<Role> roleToReturn;
        switch (input) {
            case "1":
                roleToReturn = Role.ADMIN;
                break;
            case "2":
                roleToReturn = Role.USER;
                break;
            default:
                incorrectInput();
                roleToReturn = null;
                break;
        }
        return roleToReturn;
    }


    public Enum<Department> getDepartmentFromInput(String input){
        Enum<Department> departmentToReturn;
        switch (input) {
            case "1":
                departmentToReturn = Department.CEO;
                break;
            case "2":
                departmentToReturn = Department.HR;
                break;
            case "3":
                departmentToReturn = Department.DEVELOPER;
                break;
            case "4":
                departmentToReturn = Department.SUPPORT;
                break;
            default:
                incorrectInput();
                departmentToReturn = null;
                break;
        }
        return departmentToReturn;
    }

    public void incorrectInput() {
        System.out.println("Incorrect input");
    }

    public String usernameInput(String username) {
        return username;
    }

    public String passwordInput(String username) {
        return username;
    }

    public String createAccountValidation(String inputToValidate) {
        boolean hasLetter = false;
        boolean hasNumber = false;

        for(Character c : inputToValidate.toCharArray()) {
            if(Character.isDigit(c)) {
                hasNumber = true;
            }
            if(Character.isLetter(c)) {
                hasLetter = true;
            }
        }
        if( hasNumber && hasLetter) {
            return inputToValidate;
        }
        return "";
    }
}
