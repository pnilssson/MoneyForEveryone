package main;

public class User extends Account {
    public User(String username, String password, String passwordHint, String passwordAnswer, String salary, String balance, String role) {
        super(username, password, passwordHint, passwordAnswer, salary, balance, role);
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
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String getPasswordHint() {
        return super.getPasswordHint();
    }

    @Override
    public void setPasswordHint(String passwordHint) {
        super.setPasswordHint(passwordHint);
    }

    @Override
    public String getPasswordAnswer() {
        return super.getPasswordAnswer();
    }

    @Override
    public void setPasswordAnswer(String passwordAnswer) {
        super.setPasswordAnswer(passwordAnswer);
    }
}
