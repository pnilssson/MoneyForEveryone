package main.admin;

import main.GetInputs;
import main.account.Account;
import main.account.AccountList;
import main.calendar.Calendar;
import main.enums.Department;
import main.account.RemoveAccount;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class AdminController {
    private Scanner scan = new Scanner(System.in);
    private AdminView adminView = new AdminView();
    private GetInputs getInput = new GetInputs();
    private RemoveAccount removeAccount = new RemoveAccount();

    Calendar cal = new Calendar();

    public void initAdminMenu(AdminModel admin) {
        String menuInput;
        do {
            menuInput = adminView.adminMenuInput(admin);
            callChosenMethod(menuInput, admin);
        } while(!menuInput.equals("0"));
    }

    public void callChosenMethod(String menuChoice, AdminModel admin) {
        switch (menuChoice) {
            case "1":
                adminView.printAdminBalance(admin);
                break;
            case "2":
                adminView.printAdminSalary(admin);
                break;
            case "3":
                adminView.printAdminDepartment(admin);
                break;
            case "4":
                adminView.displayUserDetails();
                break;
            case "5":
                //checkRequestedChanges();
                break;
            case "6":
                advanceCalendarAndPayout();
                break;
            case "7":
                //createAccount();
                break;
            case "8":
                removeAccount.removeMenu(admin);
                break;
            default:
                break;
        }
    }

    public void advanceCalendarAndPayout() {
        cal.getCal().add(GregorianCalendar.MONTH, 1);
        for (Account acc : AccountList.accountArrayList) {
            acc.setBalance(acc.getBalance() + acc.getSalary());
        }
    }
}
