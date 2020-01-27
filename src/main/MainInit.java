package main;

import main.account.AccountList;
import main.account.Admin;
import main.user.UserModel;

public class MainInit {

    public static void mainInit() {
        Admin admin = new Admin(Role.ADMIN, "admin1", "admin1234");
        UserModel user = new UserModel(10, 0, Role.USER, "user1", "qwerty");

        AccountList.accountArrayList.add(admin);
        AccountList.accountArrayList.add(user);

        Menu menu = new Menu();
        menu.startMenu();
    }
}
