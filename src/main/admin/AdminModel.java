package main.admin;

import main.Role;
import main.account.Account;

public class AdminModel extends Account {
    public AdminModel(int salary, int balance, Enum<Role> role, String username, String password) {
        super(salary, balance, role, username, password);
    }
}
