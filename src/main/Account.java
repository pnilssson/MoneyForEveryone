package main;

public abstract class Account {
    private int accountId;
    private static int accountIdCounter = -1;
    private String salary;
    private String balance;
    private String role;
    private boolean login = false;
    private String username;
    private String password;
    private String passwordHint;
    private String passwordAnswer;

    public Account(String username, String password, String passwordHint, String passwordAnswer, String salary, String balance, String role) {
        this.accountId = accountIdCounter++;
        this.username = username;
        this.password = password;
        this.passwordHint = passwordHint;
        this.passwordAnswer = passwordAnswer;
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

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    public String getPasswordAnswer() {
        return passwordAnswer;
    }

    public void setPasswordAnswer(String passwordAnswer) {
        this.passwordAnswer = passwordAnswer;
    }

    public Account createAccount(String salary, String balance, String role) {

        return null;
    }

}
