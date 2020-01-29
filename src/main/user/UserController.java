package main.user;

import main.GetInputs;
import main.enums.Department;
import main.account.RemoveAccount;
import main.utils.ScannerClass;

public class UserController {
    private UserView userView = new UserView();
    private GetInputs getInput = new GetInputs();
    private RemoveAccount removeAccount = new RemoveAccount();

    public void initUserMenu(UserModel user) {
        user.setLogin(true);
        do {
            callChosenMethod(userView.userMenuInput(user), user);
        } while(user.isLogin());
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
            case "0":
                user.setLogin(false);
                break;
            default:
                break;
        }
    }

    public void requestNewDepartment(UserModel user) {
        Enum<Department> newDepartment;
        Enum<Department> currentDepartment = user.getDepartment();
        userView.printNewRequestedDepartment();
        newDepartment = getInput.getDepartmentFromInput(ScannerClass.scan.next());
        if(currentDepartment != newDepartment) {
            submitDepartmentChange(user, newDepartment);
        }
    }

    public void submitDepartmentChange(UserModel user, Enum<Department> newDepartment) {
        user.setRequestedNewDepartment(newDepartment);
    }

    public void requestNewSalary(UserModel user) {
        int newIntSalary = 0;
        userView.printNewRequestedNewSalary();
        String newSalary = getInput.getIntFromInput(ScannerClass.scan.next());
        if(newSalary != null) {
            newIntSalary = getInput.convertStringToInt(newSalary);
            submitSalaryChange(user, newIntSalary);
        } else {
            getInput.incorrectInput();
        }
    }

    public void submitSalaryChange(UserModel user, int newSalary) {
        user.setRequestedSalary(newSalary);
    }
}
