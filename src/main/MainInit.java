package main;

import main.account.AccountList;
import main.admin.AdminModel;
import main.calendar.Calendar;
import main.enums.Department;
import main.enums.Role;
import main.user.UserModel;

public class MainInit {
    public static void mainInit() {
        AdminModel admin = new AdminModel(10, 0, Role.ADMIN, Department.DEVELOPER, "admin1", "admin1234");
        UserModel user = new UserModel(10, 0, Role.USER, Department.HR, "user1", "qwerty");

        AccountList.accountArrayList.add(admin);
        AccountList.accountArrayList.add(user);

        Menu menu = new Menu();
        menu.startMenu();
    }
}
