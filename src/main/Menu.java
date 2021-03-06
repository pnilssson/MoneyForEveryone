package main;

import main.account.Login;
import main.calendar.Calendar;
import java.util.Scanner;

public class Menu {

    public void startMenu() {
        boolean incorrectChoice = true;
        while(incorrectChoice) {
            System.out.println(Calendar.cal.getTime());
            System.out.println("1) Login");
            System.out.println("0) Exit");
            System.out.print("Your choice: ");
            incorrectChoice = menuChoice(new Scanner(System.in).next());
        }
    }

    public boolean menuChoice(String menuChoice) {
        switch (menuChoice) {
            case "1" :
                Login login = new Login();
                login.loginMenu();
                return true;
            case "0":
                // System.exit(0);
                return false;
            default:
                System.out.println("Incorrect input");
                return true;
        }
    }
}
