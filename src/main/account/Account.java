package main.account;

import main.Role;

public abstract class Account {
    private int accountId;
    private static int idCounter = -1;
    private Enum<Role> role;
    private boolean login;
    private String username;
    private String password;

    public Account(Enum<Role> role, String username, String password) {
        this.accountId = idCounter++;
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

    public Enum<Role> getRole() {
        return role;
    }

    public void setRole(Enum<Role> role) {
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
