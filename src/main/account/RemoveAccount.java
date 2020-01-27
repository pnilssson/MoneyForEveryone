package main.account;

import main.user.UserModel;

public class RemoveAccount {
    public boolean executeAccountDeletion(UserModel user, String username, String password) {
    if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
        AccountList.accountArrayList.remove(user);
        return true;
    } else {
        System.out.println("Username or password is incorrect");
        return false;
    }
}
}
