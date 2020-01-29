package main.account;

import main.GetInputs;
import main.admin.AdminModel;
import main.enums.Role;
import main.user.UserModel;

import java.util.Scanner;

public class CreateAccount {
    private Scanner scan = new Scanner(System.in);
    private GetInputs getInput = new GetInputs();

    public void createMenu() {

        System.out.println("Username and Password must contain at least 1 letter and 1 number: ");
        /*
        Role role = newRole();
        String username = newUsername();
        String password = newPassword();
        */
        createAccount(newRole(), newUsername(), newPassword());
    }

    public void createAccount(Enum<Role> role, String username, String password) {
        if(username.equals("") || password.equals("")) {
            getInput.incorrectInput();
        } else {
            if (checkIfUsernameIsAvailable(username)) {
                if (role.equals(Role.USER)) {
                    AccountList.accountArrayList.add(createUser(username, password));
                } else {
                    AccountList.accountArrayList.add(createAdmin(username, password));
                }
            } else {
                printUsernameTaken();
            }
        }
    }

    private AdminModel createAdmin(String username, String password) {
        return new AdminModel(username, password);
    }

    private UserModel createUser(String username, String password) {
        return new UserModel(username, password);
    }

    public Role newRole() {
        System.out.println("Choose a role for the new account: ");
        System.out.println("1) Admin ");
        System.out.println("2) User");
        System.out.print("Your choice: ");

        return (Role) getInput.getRoleFromInput(scan.next());
    }

    public String newUsername() {
        System.out.println("Enter a username: ");
        return getInput.createAccountValidation(scan.next());
    }

    public String newPassword() {
        System.out.println("Enter a password: ");
        return getInput.createAccountValidation(scan.next());
    }


    public boolean checkIfUsernameIsAvailable(String username) {
        boolean taken = false;
        for(Account acc : AccountList.accountArrayList) {
            taken = !acc.getUsername().equals(username);
            break;
        }
        return taken;
    }

    private void printUsernameTaken() {
        System.out.println("Username already in use");
    }
}
