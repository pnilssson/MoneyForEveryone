package main;

public abstract class Account {
    private int accountId;
    private static int accountIdCounter;
    private String salary;
    private String balance;
    private String role;
    private boolean login = false;

    public Account(String salary, String balance, String role) {
        this.accountId = accountIdCounter++;
        this.salary = salary;
        this.balance = balance;
        this.role = role;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public Account createAccount(String salary, String balance, String role) {

        return null;
    }

}
