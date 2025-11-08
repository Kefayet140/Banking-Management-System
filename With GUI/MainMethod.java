
package com.mycompany.banking_management_system;

import java.util.Scanner;

public class MainMethod {
    
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UserInformation user;
     user = new UserInformation("U101", "Kafayet", "12345");
        BankAccount account = new BankAccount("A1001", 1000.0);

        System.out.println("Welcome, " + user.getUserName() + "!");
        int choice;

        do {
            System.out.println("\n===== Banking Menu =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. User Info");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wit = sc.nextDouble();
                    account.withdraw(wit);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.showTransactions();
                    break;

                case 5:
                    user.displayInformation();
                    break;

                case 6:
                    System.out.println("Thank you for using our banking system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }
}