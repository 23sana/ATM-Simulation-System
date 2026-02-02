package atm;

import java.util.Scanner;

/**
 * ATM.java
 * 
 * Handles the main ATM operations for a user:
 * - Check Balance
 * - Deposit Money
 * - Withdraw Money
 * - Mini Statement
 * - Exit
 * 
 * @author Sahana
 */
public class ATM {

    private Bank bank;
    private Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    // Start the ATM simulation
    public void start() {
        System.out.println("===================================");
        System.out.println("       Welcome to ATM System       ");
        System.out.println("===================================");

        // Login
        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        Account user = bank.authenticate(accountNumber, pin);

        if (user == null) {
            System.out.println("Invalid Account Number or PIN. Exiting...");
            return;
        }

        System.out.println("\nLogin Successful!\n");

        int choice;
        do {
            showMenu();
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Check Balance
                    System.out.println("Current Balance: ₹" + user.getBalance());
                    break;

                case 2:
                    // Deposit
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount <= 0) {
                        System.out.println("Amount must be greater than 0.");
                    } else {
                        user.deposit(depositAmount);
                        System.out.println("Amount Deposited Successfully!");
                    }
                    break;

                case 3:
                    // Withdraw
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount <= 0) {
                        System.out.println("Amount must be greater than 0.");
                    } else if (user.withdraw(withdrawAmount)) {
                        System.out.println("Please collect your cash.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;

                case 4:
                    // Mini Statement
                    user.printTransactions();
                    break;

                case 5:
                    // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }

            System.out.println(); // Blank line for readability

        } while (choice != 5);
    }

    // Display ATM menu
    private void showMenu() {
        System.out.println("--------- ATM Menu ---------");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Mini Statement");
        System.out.println("5. Exit");
        System.out.println("----------------------------");
    }
}
