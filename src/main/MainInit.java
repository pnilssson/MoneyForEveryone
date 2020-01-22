package main;

import main.account.AccountList;
import main.account.Admin;

public class MainInit {

    public static void mainInit() {
        Admin admin = new Admin(Role.ADMIN, "admin1", "admin1234");
        AccountList.accountArrayList.add(admin);

        Menu menu = new Menu();
        menu.startMenu();
    }
}
