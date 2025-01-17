import java.io.InputStream;
import java.util.Scanner;

public class ATM_Main {

    private final int pinNumber = 1234;
    private float balance;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ATM_Main atm = new ATM_Main();
        atm.startATM();

    }

    private void startATM() {
        welcome();
        if (authenticateUser()) {
            showMainMenu();
        } else {
            System.out.println("Invalid PIN. Exiting...");
        }
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("\nSelect Account Type:");
            System.out.println("1. Savings Account");
            System.out.println("2. Check Account");
            System.out.println("3. Fixed Account");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = getValidInput();
            if (choice == 4) {
                System.out.println("Thank you for using MKHACANE BANK. Goodbye!");
                break;
            }
            handleAccountOptions(choice);
        }
    }

    private void handleAccountOptions(int accountType) {
        while (true) {
            System.out.println("\nAccount Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = getValidInput();
            if (choice == 5)
                break;

            switch (choice) {
                case 1:
                    checkBalance();
                case 2:
                    depositMoney();
                case 3:
                    withdrawMoney();
                case 4:
                    transferMoney();
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private int getValidInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }

    private boolean authenticateUser() {
        System.out.print("Please enter your PIN: ");
        int userPin = scanner.nextInt();
        return userPin == pinNumber;
    }

    private void welcome() {
        System.out.println("Welcome to MKHACANE BANK");
    }

    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: R");
        float withdrawAmount = scanner.nextFloat();
        if (withdrawAmount > 0 && withdrawAmount <= balance) {
            balance -= withdrawAmount;
            System.out.printf("Successfully withdrawn R%.2f. Current balance: R%.2f%n", withdrawAmount, balance);
        } else if (withdrawAmount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    private void depositMoney() {
        System.out.print("Enter amount to deposit: R");
        float depositAmount = scanner.nextFloat();
        if (depositAmount > 0) {
            balance += depositAmount;
            System.out.printf("Successfully deposited R%.2f. Current balance: R%.2f%n", depositAmount, balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: R%.2f%n", balance);
    }

    private void transferMoney() {
        System.out.print("Enter amount to transfer: R");
        float transferAmount = scanner.nextFloat();
        if (transferAmount > 0 && transferAmount <= balance) {
            balance -= transferAmount;
            System.out.printf("Successfully transferred R%.2f. Current balance: R%.2f%n", transferAmount, balance);
        } else if (transferAmount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Transfer amount must be positive.");
        }
    }

}