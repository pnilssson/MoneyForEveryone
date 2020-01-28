package main.user;

import main.enums.*;
import main.account.Account;

public class UserModel extends Account {

    public UserModel(int salary, int balance, Enum<Role> role, Enum<Department> department, String username, String password) {
        super(salary, balance, role, department, username, password);
    }

    public UserModel(String username, String password) {
        this(0, 0,  Role.USER, Department.DEVELOPER ,username, password);
    }
}
