package main.admin;

import main.GetInputs;
import main.account.Account;
import main.account.AccountList;
import main.account.CreateAccount;
import main.calendar.Calendar;
import main.enums.Department;
import main.account.RemoveAccount;
import main.enums.Role;
import main.user.UserModel;

import javax.jws.soap.SOAPBinding;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class AdminController {
    private AdminView adminView = new AdminView();
    private RemoveAccount removeAccount = new RemoveAccount();
    private CreateAccount createAccount = new CreateAccount();
    private GetInputs getInput = new GetInputs();
    private Calendar cal = new Calendar();

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
                adminView.displayUserDetails();
                break;
            case "5":
                manageRequests();
                break;
            case "6":
                advanceCalendarAndPayout();
                break;
            case "7":
                createAccount.createMenu(admin);
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

    public void manageRequests() {
        boolean anyRequests = displayAllRequests();
        if(anyRequests) {
            displaySpecificRequests(getInput.getIntFromInput());
        }
    }

    public boolean displayAllRequests() {
        UserModel user;
        boolean anyRequests = false;
        for(Account acc: AccountList.accountArrayList) {
            if(acc.getRole() == Role.USER) {
                user = (UserModel) acc;
                if(user.getDepartment() != user.getRequestedNewDepartment() || user.getSalary() != user.getRequestedSalary()) {
                    anyRequests = true;
                    adminView.displayUserWithChange(user);
                }
            }
        }
        if(anyRequests) {
            System.out.print("Chose user ID to manage: ");
            return true;
        }
        return false;
    }

    public void displaySpecificRequests(int Id) {
        UserModel user;
        boolean userFound = false;
        for(Account acc: AccountList.accountArrayList) {
            if(acc.getAccountId() == Id) {
                userFound = true;
                user = (UserModel) acc;
                if(user.getDepartment() != user.getRequestedNewDepartment()) {
                    acceptOrDeclineDepartmentRequest(user);
                }
                if(user.getSalary() != user.getRequestedSalary()) {
                    acceptOrDeclineSalaryRequest(user);
                }
            }
        }
        if(!userFound) {
            System.out.println("No user with this Id.");
        }
    }

    public void acceptOrDeclineSalaryRequest(UserModel user) {
        adminView.displayNewSalary(user);
        int adminInput = getInput.getIntFromInput();
        if (adminInput == 1) {
            acceptSalaryChange(user);
        } else if (adminInput == 2) {
            declineSalaryChange(user);
        } else {
            System.out.println("Incorrect input.");
        }
    }

    public void acceptSalaryChange(UserModel user) {
        user.setSalary(user.getRequestedSalary());
    }

    public void declineSalaryChange(UserModel user) {
        user.setRequestedSalary(user.getSalary());
    }

    public void acceptOrDeclineDepartmentRequest(UserModel user) {
        adminView.displayNewDepartment(user);
        int adminInput = getInput.getIntFromInput();
        if(adminInput == 1) {
            acceptDepartmentChange(user);
        } else if (adminInput == 2){
            declineDepartmentChange(user);
        } else {
            System.out.println("Incorrect input.");
        }
    }

    public void acceptDepartmentChange(UserModel user) {
        user.setDepartment(user.getRequestedNewDepartment());
    }

    public void declineDepartmentChange(UserModel user) {
        user.setRequestedNewDepartment(user.getDepartment());
    }
}
