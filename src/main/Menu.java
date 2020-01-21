package main;

import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);

    public void startMenu() {
        boolean choice = true;
        while(choice) {
            System.out.println("1) Login");
            System.out.println("0) Exit");
            System.out.print("Your choice: ");
            choice = menuChoice(scan.next());
        }
    }

    public Boolean menuChoice(String input) {
        switch (input) {
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
