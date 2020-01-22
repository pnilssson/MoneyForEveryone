package main;

import main.account.Account;
import main.account.AccountList;

import java.util.Scanner;

public class Login {
    Scanner scan = new Scanner(System.in);

    public void loginMenu() {
        String username = "";
        String password = "";
        String loggedIn = "";

        while (!loggedIn.equals("Logged in")) {
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

            loggedIn = login(username, password);
            System.out.println(loggedIn);
        }
        System.out.println("Logged in");
    }

    public String login(String username, String password) {
        for(Account acc : AccountList.accountArrayList) {
            if(acc.getUsername().equals(username)) {

                if(acc.getPassword().equals(password)) {
                    return "Logged in";
                } else {
                    return "Username or password is incorrect";
                }

            } else {
                return "Username or password is incorrect";
            }
        }
        return "";
    }

    public boolean usernameInput(String username) {
        return false;
    }

    public boolean passwordInput(String password) {
        return false;
    }
}
