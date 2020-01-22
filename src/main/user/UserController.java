package main.user;

public class UserController {
    UserView userView = new UserView();

    public void initUserMenu(UserModel user) {
        callChosenMethod(userView.userMenuInput(user), user);
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
                break;
            case "5":
                break;
            case "6":
                break;
            default:
                break;
        }
    }

    public void askForNewRole() {

    }

    public void askForNewSalary() {

    }

    public void removeAccount() {

    }
}
