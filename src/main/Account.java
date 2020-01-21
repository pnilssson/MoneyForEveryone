package main;

public abstract class Account {
    private int accountId;
    private String salary;
    private String balance;
    private String role;
    private boolean login;
    private String username;
    private String password;

    public Account(int accountId, String salary, String balance, String role, String username, String password) {
        this.accountId = accountId;
        this.salary = salary;
        this.balance = balance;
        this.role = role;
        this.login = false;
        this.username = username;
        this.password = password;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
