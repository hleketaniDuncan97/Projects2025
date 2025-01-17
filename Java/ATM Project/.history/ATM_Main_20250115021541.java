import java.util.Scanner;

public class ATM_Main {
    private final int pinNumber = 1234;
    private float savingsBalance = 0.0f;
    private float checkBalance = 0.0f;
    private float fixedBalance = 0.0f;
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
        scanner.close();
    }

    private void welcome() {
        System.out.println("Welcome to MKHACANE BANK");
    }

    private boolean authenticateUser() {
        System.out.print("Please enter your PIN: ");
        int userPin = scanner.nextInt();
        return userPin == pinNumber;
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
                    checkBalance(accountType);
                    break;
                case 2:
                    depositMoney(accountType);
                    break;
                case 3:
                    withdrawMoney(accountType);
                    break;
                case 4:
                    transferMoney(accountType);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
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

    private void checkBalance(int accountType) {
        float balance = getAccountBalance(accountType);
        System.out.printf("Your current balance is: R%.2f%n", balance);
    }

    private void depositMoney(int accountType) {
        System.out.print("Enter amount to deposit: R");
        float depositAmount = scanner.nextFloat();
        if (depositAmount > 0) {
            updateAccountBalance(accountType, depositAmount);
            System.out.printf("Successfully deposited R%.2f.%n", depositAmount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    private void withdrawMoney(int accountType) {
        System.out.print("Enter amount to withdraw: R");
        float withdrawAmount = scanner.nextFloat();
        float balance = getAccountBalance(accountType);
        if (withdrawAmount > 0 && withdrawAmount <= balance) {
            updateAccountBalance(accountType, -withdrawAmount);
            System.out.printf("Successfully withdrawn R%.2f.%n", withdrawAmount);
        } else if (withdrawAmount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    private void transferMoney(int fromAccountType) {
        System.out.println("\nSelect account to transfer to:");
        System.out.println("1. Savings Account");
        System.out.println("2. Check Account");
        System.out.println("3. Fixed Account");
        System.out.print("Enter your choice: ");

        int toAccountType = getValidInput();
        if (fromAccountType == toAccountType) {
            System.out.println("Cannot transfer to the same account. Try again.");
            return;
        }

        System.out.print("Enter amount to transfer: R");
        float transferAmount = scanner.nextFloat();
        float fromBalance = getAccountBalance(fromAccountType);

        if (transferAmount > 0 && transferAmount <= fromBalance) {
            updateAccountBalance(fromAccountType, -transferAmount);
            updateAccountBalance(toAccountType, transferAmount);
            System.out.printf("Successfully transferred R%.2f to the selected account.%n", transferAmount);
        } else if (transferAmount > fromBalance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Transfer amount must be positive.");
        }
    }

    private float getAccountBalance(int accountType) {
        return switch (accountType) {
            case 1: savingsBalance;
                    break;
            case 2: checkBalance;
                    break;
            case 3: fixedBalance;
                    break;
            default: 0.0f;
                    break;
        };
    }

    private void updateAccountBalance(int accountType, float amount) {
        switch (accountType) {
            case 1:
                savingsBalance += amount;
                break;
            case 2:
                checkBalance += amount;
                break;
            case 3:
                fixedBalance += amount;
                break;
        }
    }
}
