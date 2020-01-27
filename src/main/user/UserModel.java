package main.user;

import main.enums.*;
import main.account.Account;

public class UserModel extends Account {
    private int requestedSalary;
    private Enum<Department> requestedNewDepartment;

    public UserModel(int salary, int balance, Enum<Role> role, Enum<Department> department, String username, String password) {
        super(salary, balance, role, department, username, password);
        this.requestedSalary = 0;
        this.requestedNewDepartment = department;
    }

    public int getRequestedSalary() {
        return requestedSalary;
    }

    public void setRequestedSalary(int requestedSalary) {
        this.requestedSalary = requestedSalary;
    }

    public Enum<Department> getRequestedNewDepartment() {
        return requestedNewDepartment;
    }

    public void setRequestedNewDepartment(Enum<Department> requestedNewDepartment) {
        this.requestedNewDepartment = requestedNewDepartment;
    }
}
