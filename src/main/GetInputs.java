package main;

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
                roleToReturn = Role.DEVELOPER;
                break;
            case 2:
                roleToReturn = Role.HR;
                break;
            case 3:
                roleToReturn = Role.CEO;
                break;
            default:
                incorrectInput();
                roleToReturn = user.getRole();
                break;
        }
        return roleToReturn;
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
