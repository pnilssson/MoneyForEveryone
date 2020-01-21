package main;

public class Admin extends Account {
    public Admin(int salary, int balance, Enum<Role> role, String username, String password) {
        super(salary, balance, role, username, password);
    }
}
