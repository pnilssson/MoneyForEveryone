package main.user;

import main.enums.*;
import main.account.Account;

public class UserModel extends Account {
    private int requestedSalary;
    private Enum<Department> requestedNewDepartment;

    public UserModel(int salary, int balance, Enum<Role> role, Enum<Department> department, String username, String password) {
        super(salary, balance, role, department, username, password);
        this.requestedSalary = salary;
        this.requestedNewDepartment = department;
    }

    public UserModel(String username, String password) {
        this(0, 0, Role.USER, Department.DEVELOPER, username, password);
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
