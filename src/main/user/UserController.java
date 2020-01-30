package main.user;

import main.utils.GetInputs;
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
            callChosenMethod(userView.userMenuInput(), user);
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
        // Enum<Department> currentDepartment = user.getDepartment();
        userView.printNewRequestedDepartment();
        newDepartment = getInput.getDepartmentFromInput(ScannerClass.scan.next());
        submitDepartmentChange(user, newDepartment);
    }

    public boolean submitDepartmentChange(UserModel user, Enum<Department> newDepartment) {
        if(checkSameDepartment(user, newDepartment)) {
            printSameDepartment();
            return false;
        }
        user.setRequestedNewDepartment(newDepartment);
        return true;
    }

    public boolean checkSameDepartment(UserModel user, Enum<Department> newDepartment) {
        return newDepartment == user.getDepartment();
    }

    public void requestNewSalary(UserModel user) {
        int newIntSalary;
        userView.printNewRequestedNewSalary();
        String newSalary = getInput.checkIfInputIsInt(ScannerClass.scan.next());
        if(newSalary != null) {
            newIntSalary = getInput.convertStringToInt(newSalary);
            submitSalaryChange(user, newIntSalary);
        } else {
            getInput.incorrectInput();
        }
    }

    public boolean submitSalaryChange(UserModel user, int newSalary) {
        if(checkSameSalary(user, newSalary)) {
            printSameSalary();
            return false;
        }
        user.setRequestedSalary(newSalary);
        return true;
    }

    public boolean checkSameSalary(UserModel user, int newSalary) {
        return newSalary == user.getSalary();
    }

    public void printSameDepartment() {
        System.out.println("You cannot request to change to the same department you are in");
    }
    public void printSameSalary() {
        System.out.println("You cannot request to change your salary to one you already have");
    }
}
