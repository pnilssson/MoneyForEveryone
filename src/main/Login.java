package main;

import main.account.Account;
import main.account.AccountList;

import java.util.Scanner;

public class Login {
    Scanner scan = new Scanner(System.in);

    public void loginMenu() {
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("");

            System.out.println("Username: ");
            String username = usernameInput(scan.next());

            System.out.println("Password: ");
            String password = passwordInput(scan.next());

            Account acc = login(username, password);
            if(acc != null) {
                loggedIn = true;
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

    public String usernameInput(String username) {
        return username.toLowerCase();
    }

    public String passwordInput(String password) {
        return password;
    }
}
