package main.user;

import java.util.Arrays;
import java.util.Scanner;

public class UserView {
    Scanner scan = new Scanner(System.in);

    public String userMenuInput(UserModel user) {
        String choice;
        System.out.println("Welcome " + user.getUsername() + "!");
        printUserMenu(user);
        choice = scan.next();
        while(!correctMenuChoice(choice)) {
            System.out.println("Incorrect input");
            choice = scan.next();
        }
        return choice;
    }

    public boolean correctMenuChoice(String input) {
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

    public void printUserRole(UserModel user) {
        System.out.println("Your current role is: " + user.getRole());
    }

    public void printRemoveAccountConditions() {
        System.out.println("Please confirm deletion of account by entering username and password");
    }


    public void printNewRequestedRole() {
        System.out.println("What role would you like to request?");
        System.out.println("1) Developer");
        System.out.println("2) HR");
        System.out.println("3) CEO");
    }

    public void printNewRequestedNewSalary() {
        System.out.println("Enter the amount of salary you want to request: ");
    }

    public void printUserMenu(UserModel user) {
        System.out.println("What would you like to do?");
        System.out.println("1) Check balance");
        System.out.println("2) Check current salary");
        System.out.println("3) Check current role");
        System.out.println("4) Request new role");
        System.out.println("5) Request new salary");
        System.out.println("6) Delete account");
        System.out.println("0) Logout");
        System.out.print("Your choice: ");
    }
}
