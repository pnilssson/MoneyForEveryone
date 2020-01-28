package main.admin;

import main.account.Account;
import main.account.AccountList;
import main.user.UserModel;

import java.util.Arrays;
import java.util.Scanner;

public class AdminView {
    Scanner scan = new Scanner(System.in);

    public String adminMenuInput(AdminModel admin) {
        String choice;
        System.out.println("Welcome " + admin.getUsername() + "!");
        printUserMenu();
        choice = scan.next();
        while(!correctAdminMenuChoice(choice)) {
            System.out.println("Incorrect input");
            choice = scan.next();
        }
        return choice;
    }

    public boolean correctAdminMenuChoice(String input) {
        String[] choices = {"1", "2", "3", "4", "5", "6", "7", "8", "0"};
        boolean listContainsChoice;
        return listContainsChoice = Arrays.asList(choices).contains(input);
    }

    public void printAdminBalance(AdminModel admin) {
        System.out.println("Your balance is: " + admin.getBalance());
    }

    public void printAdminSalary(AdminModel admin) {
        System.out.println("Your current salary is: " + admin.getSalary());
    }

    public void printAdminDepartment(AdminModel admin) {
        System.out.println("Your current role is: " + admin.getRole());
    }

    public void printUserMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1) Check balance");
        System.out.println("2) Check current salary");
        System.out.println("3) Check current department");
        System.out.println("4) Request new department");
        System.out.println("5) Request new salary");
        System.out.println("6) Check users login details");
        System.out.println("7) Check requested changes to salary/department");
        System.out.println("8) Advance to the 25th and payout salaries");
        System.out.println("9) Create account");
        System.out.println("10) Delete account");
        System.out.println("0) Logout");
        System.out.print("Your choice: ");
    }


    public void displayUserDetails() {
        for(Account acc: AccountList.accountArrayList) {
            System.out.println("User: " + acc.getUsername());
            System.out.println("Password: " + acc.getPassword());
            System.out.println("Role: " + acc.getRole());
            System.out.println("Department: " + acc.getDepartment());
            System.out.println("");
        }
    }

    private void displayRequests() {
        for(Account acc: AccountList.accountArrayList) {
            if(acc.getDepartment() != acc.getRequestedNewDepartment()) {
                System.out.println(acc.getUsername() + "has requested " + acc.getRequestedNewDepartment() + " as new department.");
            }
            if(acc.getSalary() != acc.getRequestedSalary()) {
                System.out.println(acc.getUsername() + "has requested " + acc.getRequestedSalary() + " as new salary, current salary: " + acc.getSalary());
            }
        }
    }
}
