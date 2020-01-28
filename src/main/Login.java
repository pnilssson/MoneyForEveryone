package main;

import main.account.Account;
import main.account.AccountList;
import main.admin.AdminController;
import main.admin.AdminModel;
import main.enums.Role;
import main.user.UserController;
import main.user.UserModel;

import java.util.Scanner;

public class Login {
    Scanner scan = new Scanner(System.in);

    public void loginMenu() {
        GetInputs getInput = new GetInputs();
        System.out.println();

        System.out.print("Username: ");
        String username = getInput.usernameInput(scan.next());

        System.out.print("Password: ");
        String password = getInput.passwordInput(scan.next());

        Account acc = login(username, password);
        if(acc != null) {
            launchMainMenu(acc);
        } else {
            System.out.println("Username or password is incorrect");
        }
    }

    public Account login(String username, String password) {
        for(Account acc : AccountList.accountArrayList) {
            if(acc.getUsername().equals(username)) {
                if(acc.getPassword().equals(password)) {
                    return acc;
                }
            }
        }
        return null;
    }

    public void launchMainMenu(Account acc) {
        System.out.println("Welcome " + acc.getUsername() + "!");
        if(acc.getRole() == Role.USER) {
            UserController userController = new UserController();
            UserModel user = (UserModel) acc;
            userController.initUserMenu(user);
        } else {
            AdminController adminController = new AdminController();
            AdminModel admin = (AdminModel) acc;
            adminController.initAdminMenu(admin);
        }
    }
}
