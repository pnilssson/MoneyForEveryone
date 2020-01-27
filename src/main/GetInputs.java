package main;

import main.enums.Department;
import main.enums.Role;
import main.user.UserModel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetInputs {
    public int getIntFromInput() {
        boolean incorrectInput = true;
        int numberToReturn = 0;
        do{
            try{
                numberToReturn = new Scanner(System.in).nextInt();
                incorrectInput = false;
            } catch (InputMismatchException e) {
                incorrectInput();
            }
        } while (incorrectInput);
        return numberToReturn;
    }

    public Enum<Role> getRoleFromInput(UserModel user){
        int chosenRole = getIntFromInput();
        Enum<Role> roleToReturn;
        switch (chosenRole) {
            case 1:
                roleToReturn = Role.ADMIN;
                break;
            case 2:
                roleToReturn = Role.USER;
                break;
            default:
                incorrectInput();
                roleToReturn = user.getRole();
                break;
        }
        return roleToReturn;
    }


    public Enum<Department> getDepartmentFromInput(UserModel user){
        int chosenRole = getIntFromInput();
        Enum<Department> departmentToReturn;
        switch (chosenRole) {
            case 1:
                departmentToReturn = Department.CEO;
                break;
            case 2:
                departmentToReturn = Department.HR;
                break;
            case 3:
                departmentToReturn = Department.DEVELOPER;
                break;
            case 4:
                departmentToReturn = Department.SUPPORT;
                break;
            default:
                incorrectInput();
                departmentToReturn = user.getDepartment();
                break;
        }
        return departmentToReturn;
    }

    public void incorrectInput() {
        System.out.println("Incorrect input");
    }


    public String usernameInput(String username) {
        return username.toLowerCase();
    }

    public String passwordInput(String password) {
        return password;
    }
}
