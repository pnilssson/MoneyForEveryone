package main;

import java.util.Scanner;

public class Menu {
    public void startMenu() {
        boolean choice = true;
        while(choice) {
            System.out.println("1) Login");
            System.out.println("0) Exit");
            System.out.print("Your choice: ");
            choice = menuChoice(new Scanner(System.in).next());
        }
    }

    public boolean menuChoice(String menuChoice) {
        switch (menuChoice) {
            case "1" :
                Login login = new Login();
                login.loginMenu();
                return true;
            case "0":
                return false;
            default:
                System.out.println("Incorrect input");
                return true;
        }
    }
}
