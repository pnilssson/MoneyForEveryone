package main.admin;

import main.Role;
import main.account.Account;

public class AdminModel extends Account {
    public AdminModel(Enum<Role> role, String username, String password) {
        super(role, username, password);
    }
}
