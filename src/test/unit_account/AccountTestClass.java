package test.unit_account;

import main.Account;

public class AccountTestClass extends Account {


    public AccountTestClass(String salary, String balance, String role) {
        super(salary, balance, role);
    }


    @Override
    public String getSalary() {
        return super.getSalary();
    }

    @Override
    public void setSalary(String salary) {
        super.setSalary(salary);
    }

    @Override
    public String getBalance() {
        return super.getBalance();
    }

    @Override
    public void setBalance(String balance) {
        super.setBalance(balance);
    }

    @Override
    public String getRole() {
        return super.getRole();
    }

    @Override
    public void setRole(String role) {
        super.setRole(role);
    }

    @Override
    public boolean isLogin() {
        return super.isLogin();
    }

    @Override
    public void setLogin(boolean login) {
        super.setLogin(login);
    }

    @Override
    public Account createAccount(String salary, String balance, String role) {
        return super.createAccount("100", "100", "User");
    }
}
