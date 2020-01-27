package main;

import main.account.Account;
import main.account.AccountList;
import main.user.UserController;
import main.user.UserModel;

import java.util.Scanner;

public class Login {
    Scanner scan = new Scanner(System.in);

    public void loginMenu() {
        System.out.println("");

        System.out.print("Username: ");
        String username = usernameInput(scan.next());

        System.out.print("Password: ");
        String password = passwordInput(scan.next());

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
        UserController userController = new UserController();
        if(acc.getRole() != Role.ADMIN) {
            UserModel user = (UserModel) acc;
            userController.initUserMenu(user);
        }
    }

    public String usernameInput(String username) {
        return username.toLowerCase();
    }

    public String passwordInput(String password) {
        return password;
    }
}
