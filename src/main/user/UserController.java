package main.user;

import main.GetInputs;
import main.enums.Department;
import main.account.RemoveAccount;
import java.util.Scanner;

public class UserController {
    private UserView userView = new UserView();
    private GetInputs getInput = new GetInputs();
    private RemoveAccount removeAccount = new RemoveAccount();

    public void initUserMenu(UserModel user) {
        user.setLogin(true);
        do {
            callChosenMethod(userView.userMenuInput(user), user);
        } while (user.isLogin());
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
                user.requestNewDepartment(user);
                break;
            case "5":
                user.requestNewSalary(user);
                break;
            case "6":
                removeAccount.removeMenu(user);
                break;
            case "0":
                user.setLogin(false);
            default:
                break;
        }
    }
}