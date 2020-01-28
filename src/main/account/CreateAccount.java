package main.account;

import main.GetInputs;
import main.admin.AdminModel;
import main.enums.Role;
import main.user.UserModel;

import java.util.Scanner;

public class CreateAccount {
    private Scanner scan = new Scanner(System.in);
    private GetInputs getInput = new GetInputs();

    public void createMenu(Account acc) {
        Role role = null;

        System.out.println("Enter a username: ");
        String username = getInput.usernameInput(scan.next());
        // newUsername();

        System.out.println("Enter a password: ");
        String password = getInput.passwordInput(scan.next());
        // newPassword();

        while(role == null) {
            System.out.println("Choose a role for the new account: ");
            System.out.println("1) Admin ");
            System.out.println("2) User");
            System.out.print("Your choice: ");

            role = (Role) getInput.getRoleFromInput();
        }

        createAccount(role, username, password);
    }

    public void createAccount(Enum<Role> role, String username, String password) {
        if(role.equals(Role.USER)) {
            AccountList.accountArrayList.add(createUser(username, password));
        } else {
            AccountList.accountArrayList.add(createAdmin(username, password));
        }
    }

    public AdminModel createAdmin(String username, String password) {
        return new AdminModel(username, password);
    }

    public UserModel createUser(String username, String password) {
        return new UserModel(username, password);
    }
}
