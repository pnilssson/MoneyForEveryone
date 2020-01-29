package main.user;

import main.calendar.Calendar;
import main.utils.ScannerClass;

import java.util.Arrays;
import java.util.Scanner;

public class UserView {

    public String userMenuInput(UserModel user) {
        String choice;
        printUserMenu();
        choice = ScannerClass.scan.next();
        while(!correctUserMenuChoice(choice)) {
            System.out.println("Incorrect input");
            choice = ScannerClass.scan.next();
        }
        return choice;
    }

    public boolean correctUserMenuChoice(String input) {
        String[] choices = {"1", "2", "3", "4", "5", "6", "0"};
        boolean listContainsChoice;
        return listContainsChoice = Arrays.asList(choices).contains(input);
    }

    public void printUserBalance(UserModel user) {
        System.out.println("Your balance is: " + user.getBalance());
    }

    public void printUserSalary(UserModel user) {
        System.out.println("Your current salary is: " + user.getSalary());
    }

    public void printUserDepartment(UserModel user) {
        System.out.println("Your current role is: " + user.getDepartment());
    }

    public void printNewRequestedDepartment() {
        System.out.println("What department would you like to request?");
        System.out.println("1) Developer");
        System.out.println("2) HR");
        System.out.println("3) Support");
        System.out.println("4) CEO");
        System.out.print("New department: ");
    }

    public void printNewRequestedNewSalary() {
        System.out.println("Enter the amount of salary you want to request: ");
    }

    public void printUserMenu() {
        System.out.println(Calendar.cal.getTime());
        System.out.println("What would you like to do?");
        System.out.println("1) Check balance");
        System.out.println("2) Check current salary");
        System.out.println("3) Check current department");
        System.out.println("4) Request new department");
        System.out.println("5) Request new salary");
        System.out.println("6) Delete account");
        System.out.println("0) Logout");
        System.out.print("Your choice: ");
    }
}
