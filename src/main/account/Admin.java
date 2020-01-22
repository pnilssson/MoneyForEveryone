package main.account;

import main.Role;
import main.account.Account;

public class Admin extends Account {
    public Admin(Enum<Role> role, String username, String password) {
        super(role, username, password);
    }
}
