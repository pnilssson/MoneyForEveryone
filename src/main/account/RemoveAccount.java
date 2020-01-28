package main.account;

import main.GetInputs;
import main.Menu;
import main.admin.AdminModel;
import main.enums.Role;
import main.user.UserModel;

import java.util.Scanner;

public class RemoveAccount {
    private GetInputs getInput = new GetInputs();
    private Scanner scan = new Scanner(System.in);

    public void removeMenu(Account acc) {
        printRemoveAccountConditions();
        System.out.print("Username: ");
        String username = getInput.usernameInput(scan.next());
        System.out.print("Password: ");
        String password = getInput.passwordInput(scan.next());

        checkRoleBeforeRemoveAccount(acc, username, password);
    }

    public void checkRoleBeforeRemoveAccount(Account acc, String username, String password) {
        if (acc.getRole().equals(Role.USER)) {
            removeAccount((UserModel) acc, username, password);
        } else {
            removeAccount((AdminModel) acc, username, password);
        }
    }

    public void removeAccount(UserModel user, String username, String password) {
        if(executeAccountDeletion(user, username, password)){
            user.removeAccount(user);
            printRemovedAccount(username);
            user.setLogin(false);
        } else {
            printIncorrectInput();
        }
    }

    public void removeAccount(AdminModel admin, String username, String password) {
        boolean removedAccount = false;
        boolean sameAccount = false;

        for(Account acc : AccountList.accountArrayList) {
            if(admin != acc) {
                if (executeAccountDeletion(acc, username, password)) {
                    removedAccount = true;
                    acc.removeAccount(acc);
                    break;
                }
            } else {
                sameAccount = true;
            }
        }

        if (removedAccount) {
            printRemovedAccount(username);
        } else if(sameAccount) {
           printIncorrectAccount();
        } else {
            printIncorrectInput();
        }
    }

    public boolean executeAccountDeletion(Account acc, String username, String password) {
        return username.equals(acc.getUsername()) && password.equals(acc.getPassword());
    }

    public void printRemoveAccountConditions() {
        System.out.println("Please confirm deletion of account by entering username and password");
    }

    public void printIncorrectInput() {
        System.out.println("Username or password is incorrect");
    }

    public void printIncorrectAccount() {
        System.out.println("Admin cannot remove their own account");
    }

    public void printRemovedAccount(String username) {
        System.out.println("Removed " + username);
    }

}
