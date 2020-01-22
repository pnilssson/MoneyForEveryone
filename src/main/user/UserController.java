package main.user;

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
                requestForNewRole();
                break;
            case "5":
                requestForNewSalary();
                break;
            case "6":
                removeAccount();
                break;
            default:
                break;
        }
    }

    public void requestForNewRole() {

    }

    public void requestForNewSalary() {

    }

    public void removeAccount() {

    }
}
