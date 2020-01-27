package main.user;

import main.enums.*;
import main.account.Account;

public class UserModel extends Account {
    private int requestedSalary;
    private Enum<Role> requestedNewRole;

    public UserModel(int salary, int balance, Enum<Role> role, Enum<Department> department, String username, String password) {
        super(salary, balance, role, department, username, password);
        this.requestedSalary = 0;
        this.requestedNewRole = role;
    }

    public int getRequestedSalary() {
        return requestedSalary;
    }

    public void setRequestedSalary(int requestedSalary) {
        this.requestedSalary = requestedSalary;
    }

    public Enum<Role> getRequestedNewRole() {
        return requestedNewRole;
    }

    public void setRequestedNewRole(Enum<Role> requestedNewRole) {
        this.requestedNewRole = requestedNewRole;
    }
}
