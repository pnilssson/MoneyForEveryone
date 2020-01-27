package main.admin;

import main.enums.*;
import main.account.Account;

public class AdminModel extends Account {
    public AdminModel(int salary, int balance, Enum<Role> role, Enum<Department> department, String username, String password) {
        super(salary, balance, role, department, username, password);
    }
    public AdminModel(String username, String password) {
        this(0, 0,  Role.ADMIN, Department.DEVELOPER, username, password);
    }
}
