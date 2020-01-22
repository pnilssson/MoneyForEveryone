package main;

import main.account.Account;
import main.account.AccountList;

import java.util.Scanner;

public class Login {
    Scanner scan = new Scanner(System.in);

    public void loginMenu() {
        boolean loggedIn = false;
        while (!loggedIn) {

            String username = "";
            String password = "";

            while (username.equals("")) {
                username = checkUsernameInput(usernameInput());
            }
            while (password.equals("")) {
                password = checkPasswordInput(passwordInput());
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

    public String usernameInput() {
        System.out.println("Username: ");
        return scan.next().toLowerCase();
    }

    public String passwordInput() {
        System.out.println("Password: ");
        return scan.next().toLowerCase();
    }

    public String checkUsernameInput(String username) {
        if(username.length() < 6) {
            return "";
        }

        return username;
    }

    public String checkPasswordInput(String password) {
        if(password.length() < 6) {
            return "";
        }

        return password;
    }
}
