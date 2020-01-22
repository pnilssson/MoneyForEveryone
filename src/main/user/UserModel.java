package main.user;

import main.Role;
import main.account.Account;

public class UserModel extends Account {
    public UserModel(int salary, int balance, Enum<Role> role, String username, String password) {
        super(salary, balance, role, username, password);
    }
}
