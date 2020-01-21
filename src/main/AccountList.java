package main;

import java.util.ArrayList;

public class AccountList {
    Admin admin = new Admin(0, 0, Role.ADMIN, "admin1", "admin1234");
    ArrayList<Account> accountArrayList;

    public AccountList(ArrayList<Account> accountArrayList) {
        this.accountArrayList = accountArrayList;
    }

    public ArrayList<Account> getAccountArrayList() {
        return accountArrayList;
    }

    public void setAccountArrayList(ArrayList<Account> accountArrayList) {
        this.accountArrayList = accountArrayList;
    }
}
