package main.account;

import main.GetInputs;
import main.enums.*;

public abstract class Account {
    GetInputs getInput = new GetInputs();
    AccountView accView = new AccountView();
    private int accountId;
    private static int idCounter = -1;
    private int salary;
    private int balance;
    private Enum<Role> role;
    private Enum<Department> department;
    private boolean login;
    private String username;
    private String password;
    private int requestedSalary;
    private Enum<Department> requestedNewDepartment;

    public Account(int salary, int balance, Enum<Role> role, Enum<Department> department, String username, String password) {
        this.accountId = idCounter++;
        this.salary = salary;
        this.balance = balance;
        this.role = role;
        this.department = department;
        this.login = false;
        this.username = username;
        this.password = password;
        this.requestedSalary = salary;
        this.requestedNewDepartment = department;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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

    public Enum<Role> getRole() {
        return role;
    }

    public void setRole(Enum<Role> role) {
        this.role = role;
    }

    public Enum<Department> getDepartment() {
        return department;
    }

    public void setDepartment(Enum<Department> department) {
        this.department = department;
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

    public void removeAccount(Account acc) {
        AccountList.accountArrayList.remove(acc);
    }

    public void requestNewDepartment(Account acc) {
        Enum<Department> newDepartment;
        Enum<Department> currentDepartment = acc.getDepartment();
        accView.printNewRequestedDepartment();
        newDepartment = getInput.getDepartmentFromInput();
        if(currentDepartment != newDepartment) {
            submitDepartmentChange(acc, newDepartment);
        }
    }

    public void submitDepartmentChange(Account acc, Enum<Department> newDepartment) {
        acc.setRequestedNewDepartment(newDepartment);
    }

    public void requestNewSalary(Account acc) {
        int newSalary = 0;
        accView.printNewRequestedNewSalary();
        newSalary = getInput.getIntFromInput();
        submitSalaryChange(acc, newSalary);
    }

    public void submitSalaryChange(Account acc, int newSalary) {
        acc.setRequestedSalary(newSalary);
    }
}

