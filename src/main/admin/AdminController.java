package main.admin;

import main.utils.GetInputs;
import main.account.Account;
import main.utils.AccountList;
import main.account.CreateAccount;
import main.calendar.Calendar;
import main.account.RemoveAccount;
import main.enums.Role;
import main.user.UserModel;
import main.utils.ScannerClass;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AdminController {
    private AdminView adminView = new AdminView();
    private RemoveAccount removeAccount = new RemoveAccount();
    private CreateAccount createAccount = new CreateAccount();
    private GetInputs getInput = new GetInputs();
    private Calendar cal = new Calendar();

    public void initAdminMenu(AdminModel admin) {
        admin.setLogin(true);
        do {
            callChosenMethod(adminView.adminMenuInput(), admin);
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
                createAccount.createMenu();
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
        if (displayAllRequests()) {
            checkInputForSpecificRequest(getInput.checkIfInputIsInt(ScannerClass.scan.next()));
        } else {
            adminView.printNoRequests();
        }
    }

    public boolean displayAllRequests() {
        ArrayList<Boolean> haveRequests = new ArrayList<>();

        for(Account acc: AccountList.accountArrayList) {
            if(acc.getRole() == Role.USER) {
                haveRequests.add(checkUsersForRequests((UserModel) acc));
            }
        }

        if(haveRequests.contains(true)) {
            adminView.printIdToManage();
            return true;
        }
        return false;
    }

    public boolean checkUsersForRequests(UserModel user) {
        if(user.getDepartment() != user.getRequestedNewDepartment() || user.getSalary() != user.getRequestedSalary()) {
            adminView.displayUserWithChange(user);
            return true;
        }
        return false;
    }

    public void checkInputForSpecificRequest(String input) {
        if(input != null) {
            displaySpecificRequests(getInput.convertStringToInt(input));
        } else {
            getInput.incorrectInput();
        }
    }

    public void displaySpecificRequests(int Id) {
        boolean userFound = false;

        for(Account acc: AccountList.accountArrayList) {
            if(acc.getAccountId() == Id) {
                userFound = true;
                DepartmentOrSalary((UserModel) acc);
            }
        }
        if(!userFound) {
            adminView.printNoUserWithId();
        }
    }

    public void DepartmentOrSalary(UserModel user) {
        if(user.getDepartment() != user.getRequestedNewDepartment()) {
            acceptOrDeclineDepartmentRequest(user);
        }
        if(user.getSalary() != user.getRequestedSalary()) {
            acceptOrDeclineSalaryRequest(user);
        }
    }

    public void acceptOrDeclineSalaryRequest(UserModel user) {
        adminView.displayNewSalary(user);
        checkInputForAcceptOrDenySalaryRequest(user, getInput.checkIfInputIsInt(ScannerClass.scan.next()));
    }

    public void checkInputForAcceptOrDenySalaryRequest(UserModel user, String input) {
        if(input != null) {
            int adminIntInput = getInput.convertStringToInt(input);

            switch (adminIntInput) {
                case 1:
                    acceptSalaryChange(user);
                    break;
                case 2:
                    declineSalaryChange(user);
                    break;
                default:
                    getInput.incorrectInput();
                    break;
            }
        } else {
            getInput.incorrectInput();
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
        checkInputForAcceptOrDenyDepartmentRequest(user, getInput.checkIfInputIsInt(ScannerClass.scan.next()));
    }

    public void checkInputForAcceptOrDenyDepartmentRequest(UserModel user, String input) {
        if(input != null) {
            int adminIntInput = getInput.convertStringToInt(input);

            switch (adminIntInput) {
                case 1:
                    acceptDepartmentChange(user);
                    break;
                case 2:
                    declineDepartmentChange(user);
                    break;
                default:
                    getInput.incorrectInput();
                    break;
            }
        } else {
            getInput.incorrectInput();
        }
    }

    public void acceptDepartmentChange(UserModel user) {
        user.setDepartment(user.getRequestedNewDepartment());
    }

    public void declineDepartmentChange(UserModel user) {
        user.setRequestedNewDepartment(user.getDepartment());
    }
}
