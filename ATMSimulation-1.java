// 202510522

import java.util.Scanner;

public class ATMSimulation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String correctPIN = "1234";
        double balance = 1000;

        String[] transactions = new String[100];
        int transactionCount = 0;

        int attempts = 0;
        boolean login = false;

        System.out.println("===== ATM SYSTEM =====");

        while (attempts < 3) {

            System.out.print("Enter PIN: ");
            String pin = sc.nextLine();

            if (pin.equals(correctPIN)) {
                login = true;
                System.out.println("Login Successful!");
                break;
            } else {
                attempts++;
                System.out.println("Wrong PIN!");
            }
        }

        if (!login) {
            System.out.println("Account Locked!");
            sc.close();
            return;
        }

        int choice = 0;

        while (choice != 5) {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                continue;
            }

            if (choice == 1) {

                System.out.println("Current Balance: $" + balance);

            } else if (choice == 2) {

                System.out.print("Enter deposit amount: ");

                try {
                    double amount = Double.parseDouble(sc.nextLine());

                    if (amount > 0) {
                        balance += amount;

                        if (transactionCount < transactions.length) {
                            transactions[transactionCount++] =
                                    "Deposit: $" + amount;
                        }

                        System.out.println("Deposit Successful!");
                    } else {
                        System.out.println("Invalid Amount!");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid Amount!");
                }

            } else if (choice == 3) {

                System.out.print("Enter withdrawal amount: ");

                try {
                    double amount = Double.parseDouble(sc.nextLine());

                    if (amount > 0 && amount <= balance) {
                        balance -= amount;

                        if (transactionCount < transactions.length) {
                            transactions[transactionCount++] =
                                    "Withdrawal: $" + amount;
                        }

                        System.out.println("Withdrawal Successful!");

                    } else {
                        System.out.println("Insufficient Balance or Invalid Amount!");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid Amount!");
                }

            } else if (choice == 4) {

                System.out.println("===== TRANSACTION HISTORY =====");

                if (transactionCount == 0) {
                    System.out.println("No Transactions Found!");
                } else {
                    for (int i = 0; i < transactionCount; i++) {
                        System.out.println((i + 1) + ". " + transactions[i]);
                    }
                }

            } else if (choice == 5) {

                System.out.println("Thank You For Using ATM!");

            } else {

                System.out.println("Invalid Option!");

            }
        }

        sc.close();
    }
}