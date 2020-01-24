package main.user;

import main.Role;
import main.account.Account;

public class UserModel extends Account {
    private int salary;
    private int balance;
    private int requestedSalary;
    private Enum<Role> requestedNewRole;

    public UserModel(int salary, int balance, Enum<Role> role, String username, String password) {
        super(role, username, password);
        this.salary = salary;
        this.balance = balance;
        this.requestedSalary = 0;
        this.requestedNewRole = role;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
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
