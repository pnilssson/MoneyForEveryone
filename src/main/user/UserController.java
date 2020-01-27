package main.user;

import main.GetInputs;
import main.enums.Department;
import main.account.RemoveAccount;
import java.util.Scanner;

public class UserController {
    private Scanner scan = new Scanner(System.in);
    private UserView userView = new UserView();
    private GetInputs getInput = new GetInputs();
    private RemoveAccount removeAccount = new RemoveAccount();
    private String quit;

    public void initUserMenu(UserModel user) {
        do {
            quit = userView.userMenuInput(user);
            callChosenMethod(quit, user);
        } while(!quit.equals("0"));
    }

    public void callChosenMethod(String menuChoice, UserModel user) {
        switch (menuChoice) {
            case "1":
                userView.printUserBalance(user);
                break;
            case "2":
                userView.printUserSalary(user);
                break;
            case "3":
                userView.printUserDepartment(user);
                break;
            case "4":
                requestNewDepartment(user);
                break;
            case "5":
                requestNewSalary(user);
                break;
            case "6":
                removeAccount.removeMenu(user);
                break;
            default:
                break;
        }
    }

    public void requestNewDepartment(UserModel user) {
        Enum<Department> newDepartment;
        Enum<Department> currentDepartment = user.getDepartment();
        userView.printNewRequestedDepartment();
        newDepartment = getInput.getDepartmentFromInput();
        if(currentDepartment != newDepartment) {
            submitDepartmentChange(user, newDepartment);
        }
    }

    public void submitDepartmentChange(UserModel user, Enum<Department> newDepartment) {
        user.setRequestedNewDepartment(newDepartment);
    }

    public void requestNewSalary(UserModel user) {
        int newSalary = 0;
        userView.printNewRequestedNewSalary();
        newSalary = getInput.getIntFromInput();
        submitSalaryChange(user, newSalary);
    }

    public void submitSalaryChange(UserModel user, int newSalary) {
        user.setRequestedSalary(newSalary);
    }

    /*
    public void removeAccount(UserModel user) {
        RemoveAccount removeAccount = new RemoveAccount();
        userView.printUserRemoveAccountConditions();
        System.out.print("Username: ");
        String username = getInput.usernameInput(scan.next());
        System.out.print("Password: ");
        String password = getInput.passwordInput(scan.next());
        if(removeAccount.executeAccountDeletion(user, username, password)) {
            quit = "0";
        }
    }
   */

}
