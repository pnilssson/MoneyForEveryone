package main.user;

import main.GetInputs;
import main.Login;
import main.Role;
import main.account.AccountList;

import java.util.Scanner;

public class UserController {
    Scanner scan = new Scanner(System.in);
    UserView userView = new UserView();
    GetInputs getInput = new GetInputs();

    public void initUserMenu(UserModel user) {
        String quit;
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
                userView.printUserRole(user);
                break;
            case "4":
                requestNewRole(user);
                break;
            case "5":
                requestNewSalary(user);
                break;
            case "6":
                removeAccount(user);
                break;
            default:
                break;
        }
    }

    public void requestNewRole(UserModel user) {
        Enum<Role> newRole;
        Enum<Role> currentRole = user.getRole();
        userView.printNewRequestedRole();
        newRole = getInput.getRoleFromInput(user);
        if(currentRole != newRole) {
            submitRoleChange(user, newRole);
        }
    }

    public void submitRoleChange(UserModel user, Enum<Role> newRole) {
        user.setRequestedNewRole(newRole);
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

    public void removeAccount(UserModel user) {
        Login login = new Login();
        userView.printRemoveAccountConditions();
        String username = login.usernameInput(scan.next());
        String password = login.passwordInput(scan.next());
        executeAccountDeletion(user, username, password);
    }

    public void executeAccountDeletion(UserModel user, String username, String password) {
        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            AccountList.accountArrayList.remove(user);
        } else {
            System.out.println("Username or password is incorrect");
        }
    }
}
