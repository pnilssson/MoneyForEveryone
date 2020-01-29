package main;

import main.enums.Department;
import main.enums.Role;
import main.user.UserModel;
import main.utils.ScannerClass;

import java.util.InputMismatchException;

public class GetInputs {

     public int getIntFromInput() {
        boolean incorrectInput = true;
        int numberToReturn = 0;

        while(incorrectInput) {
            try{
                // numberToReturn = new Scanner(System.in).nextInt();
                numberToReturn = ScannerClass.scan.nextInt();
                incorrectInput = false;
            } catch (InputMismatchException e) {
                incorrectInput();
            }
        }
        return numberToReturn;
    }

    public Enum<Role> getRoleFromInput(String input){
        // int chosenRole = getIntFromInput();
        Enum<Role> roleToReturn;
        switch (input) {
            case "1":
                roleToReturn = Role.ADMIN;
                break;
            case "2":
                roleToReturn = Role.USER;
                break;
            default:
                // incorrectInput();
                roleToReturn = null;
                break;
        }
        return roleToReturn;
    }


    public Enum<Department> getDepartmentFromInput(String input){
        // int chosenRole = getIntFromInput();
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
                // incorrectInput();
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
