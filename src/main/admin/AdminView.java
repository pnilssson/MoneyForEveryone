package main.admin;

import main.account.Account;
import main.account.AccountList;
import main.calendar.Calendar;
import main.enums.Role;
import main.user.UserModel;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.Scanner;

public class AdminView {
    Scanner scan = new Scanner(System.in);

    public String adminMenuInput(AdminModel admin) {
        String choice;
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
        System.out.println(Calendar.cal.getTime());
        System.out.println("What would you like to do?");
        System.out.println("1) Check balance");
        System.out.println("2) Check current salary");
        System.out.println("3) Check current department");
        System.out.println("4) Check users login details");
        System.out.println("5) Check requested changes to salary/department");
        System.out.println("6) Advance to the 25th and payout salaries");
        System.out.println("7) Create account");
        System.out.println("8) Delete account");
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

    public void displayUserWithChange(UserModel user) {
        System.out.println("ID: " + user.getAccountId() + ") " + user.getUsername() + " has new requests. ");
    }

    public void displayNewDepartment(UserModel user) {
        System.out.println(user.getUsername() + " has requested " + user.getRequestedNewDepartment() + " as new department.");
        printApproveOrDecline();
    }

    public void displayNewSalary(UserModel user) {
        System.out.println(user.getUsername() + " has requested " + user.getRequestedSalary() + " as new salary, current salary: " + user.getSalary());
        printApproveOrDecline();
    }

    public void printApproveOrDecline() {
        System.out.println("Do you:");
        System.out.println("1) Approve");
        System.out.println("2) Decline");
        System.out.print("Your choice: ");
    }
}
