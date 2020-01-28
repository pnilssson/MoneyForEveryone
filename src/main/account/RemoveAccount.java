package main.account;

import main.GetInputs;
import main.Menu;
import main.enums.Role;
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
            removeAccount(acc, username, password);
        } else {
            removeAccount(username, password);
        }
    }

    public void removeAccount(Account acc, String username, String password) {
        if(executeAccountDeletion(acc, username, password)){
            acc.removeAccount(acc);
            printRemovedAccount(username);
            Menu menu = new Menu();
            menu.startMenu();
        } else {
            printIncorrectInput();
        }
    }

    public void removeAccount(String username, String password) {
        boolean removedAccount = false;

        for(Account acc : AccountList.accountArrayList) {
            if(executeAccountDeletion(acc, username, password)){
                removedAccount = true;
                acc.removeAccount(acc);
                break;
            }
        }

        if (removedAccount) {
            printRemovedAccount(username);
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

    public void printRemovedAccount(String username) {
        System.out.println("Removed " + username);
    }

}
