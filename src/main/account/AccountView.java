package main.account;

public class AccountView {
    public void printNewRequestedDepartment() {
        System.out.println("What role would you like to request?");
        System.out.println("1) Developer");
        System.out.println("2) HR");
        System.out.println("3) Support");
        System.out.println("4) CEO");
    }

    public void printNewRequestedNewSalary() {
        System.out.println("Enter the amount of salary you want to request: ");
    }

}
