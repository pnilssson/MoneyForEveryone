package main.user;

import main.Role;
import main.account.Account;

public class UserModel extends Account {
    private int salary;
    private int balance;

    public UserModel(int salary, int balance, Enum<Role> role, String username, String password) {
        super(role, username, password);
        this.salary = salary;
        this.balance = balance;
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
}
