package main;

import java.util.Scanner;

public class Login {
    Scanner scan = new Scanner(System.in);

    public void loginMenu() {
        String username = "";
        String password = "";
        boolean usernameIncorrect = true;
        boolean passwordIncorrect = true;

        while(usernameIncorrect) {
            System.out.println("Username: ");
            username = scan.next();
            usernameIncorrect = usernameInput(username);
        }
        while(passwordIncorrect) {
            System.out.println("Password: ");
            password = scan.next();
            passwordIncorrect = passwordInput(password);
        }

        login(username, password);
    }

    public void login(String username, String Password) {

    }

    public boolean usernameInput(String username) {
        return false;
    }

    public boolean passwordInput(String password) {
        return false;
    }
}
