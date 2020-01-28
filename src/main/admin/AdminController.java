package main.admin;

import main.GetInputs;
import main.account.Account;
import main.account.AccountList;
import main.account.CreateAccount;
import main.enums.Department;
import main.account.RemoveAccount;
import java.util.Scanner;

public class AdminController {
    private AdminView adminView = new AdminView();
    private RemoveAccount removeAccount = new RemoveAccount();
    private CreateAccount createAccount = new CreateAccount();

    public void initAdminMenu(AdminModel admin) {
        admin.setLogin(true);
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
                admin.requestNewDepartment(admin);
                break;
            case "5":
                admin.requestNewSalary(admin);
                break;
            case "6":
                adminView.displayUserDetails();
                break;
            case "7":
                checkRequestedChanges();
                break;
            case "8":
                advanceCalendarAndPayout();
                break;
            case "9":
                createAccount.createMenu();
                break;
            case "10":
                removeAccount.removeMenu(admin);
                break;
            case "0":
                admin.setLogin(false);
            default:
                break;
        }
    }

    public void advanceCalendarAndPayout() {
        for (Account acc : AccountList.accountArrayList) {
            acc.setBalance(acc.getBalance() + acc.getSalary());
        }
    }

    public void checkRequestedChanges() {

    }
}
