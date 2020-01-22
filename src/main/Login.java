package main;

import main.account.Account;
import main.account.AccountList;

import java.util.Scanner;

public class Login {
    Scanner scan = new Scanner(System.in);

    public void loginMenu() {
        String username = "";
        String password = "";
        boolean loggedIn = false;

        while (!loggedIn) {
            boolean usernameIncorrect = true;
            boolean passwordIncorrect = true;

            while (usernameIncorrect) {
                System.out.println("Username: ");
                username = scan.next().toLowerCase();
                usernameIncorrect = usernameInput(username);
            }
            while (passwordIncorrect) {
                System.out.println("Password: ");
                password = scan.next();
                passwordIncorrect = passwordInput(password);
            }

            Account acc = login(username, password);
            try {
                acc.setLogin(true);
                loggedIn = acc.isLogin();
            } catch (NullPointerException ne) {
                loggedIn = false;
            }
            if(loggedIn) {
                System.out.println("Logged in");
            } else {
                System.out.println("Username or password is incorrect");
            }
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

    public boolean usernameInput(String username) {
        return false;
    }

    public boolean passwordInput(String password) {
        return false;
    }
}
