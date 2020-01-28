package main.admin;

import main.GetInputs;
import main.account.Account;
import main.account.AccountList;
import main.calendar.Calendar;
import main.enums.Department;
import main.account.RemoveAccount;
import main.user.UserModel;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class AdminController {
    private AdminView adminView = new AdminView();
    private RemoveAccount removeAccount = new RemoveAccount();

    Calendar cal = new Calendar();

    public void initAdminMenu(AdminModel admin) {
        do {
            callChosenMethod(adminView.adminMenuInput(admin), admin);
        } while(admin.isLogin());
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
            case "0":
                admin.setLogin(false);
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
