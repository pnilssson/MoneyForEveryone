package main.admin;

import main.GetInputs;
import main.account.RemoveAccount;
import main.enums.Department;

import java.util.Scanner;

public class AdminController {
    private Scanner scan = new Scanner(System.in);
    private AdminView adminView = new AdminView();
    private GetInputs getInput = new GetInputs();
    private String quit;

    public void initAdminMenu(AdminModel admin) {
        do {
            quit = adminView.adminMenuInput(admin);
            callChosenMethod(quit, admin);
        } while(!quit.equals("0"));
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
                checkUserLoginDetails();
                break;
            case "5":
                checkRequestedChanges();
                break;
            case "6":
                advanceCalendarAndPayOut();
                break;
            case "7":
                createAccount();
                break;
            case "8":
                removeAccount();
                break;
            default:
                break;
        }
    }


    public void removeAccount(AdminModel admin) {
        RemoveAccount removeAccount = new RemoveAccount();
        userView.printRemoveAccountConditions();
        System.out.print("Username: ");
        String username = getInput.usernameInput(scan.next());
        System.out.print("Password: ");
        String password = getInput.passwordInput(scan.next());
        if(removeAccount.executeAccountDeletion(user, username, password)) {
            quit = "0";
        }
    }
}
