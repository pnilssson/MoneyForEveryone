package main.user;

import main.Login;
import main.account.AccountList;

public class UserController {
    UserView userView = new UserView();

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
                requestForNewRole(user);
                break;
            case "5":
                requestForNewSalary(user);
                break;
            case "6":
                removeAccount(user);
                break;
            default:
                break;
        }
    }

    public void requestForNewRole(UserModel user) {

    }

    public void requestForNewSalary(UserModel user) {

    }

    public void removeAccount(UserModel user) {
        Login login = new Login();
        userView.printRemoveAccountConditions();
        String username = login.usernameInput();
        String password = login.passwordInput();
        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            AccountList.accountArrayList.remove(user);
        } else {
            System.out.println("Username or password is incorrect");
        }
    }
}
