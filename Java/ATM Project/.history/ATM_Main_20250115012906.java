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

    private void handleAccountOptions(int choice) {
        while (true) {
            System.out.println("\nAccount Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = getValidInput();
            if (choice == 5) break;

            switch (choice) {
                case 1 -> checkBalance();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 4 -> transferMoney();
                default -> System.out.println("Invalid choice. Please try again.");
            }
    }

    private int getValidInput() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValidInput'");
    }

    private boolean authenticateUser() {
        System.out.print("Please enter your PIN: ");
        int userPin = scanner.nextInt();
        return userPin == pinNumber;
    }

    private void welcome() {
        System.out.println("Welcome to MKHACANE BANK");
    }

    private void selectAccount() {
        System.out.println("Please select an account:\n1.Savings\n2.Check\n3.Fixed");
        option = newScanner.nextInt();

        switch (option) {
            case 1:
                savingAccount();
                break;
            case 2:
                checkAccount();
                break;

            case 3:
                fixedAccount();
                break;

            default:
                System.out.println("Invalid option");
                break;
        }

    }

    private void fixedAccount() {
        System.out.println("Fixed Account\n");
        System.out.println(
                "Please select an option:\n1.Check Balance\n2.Deposit Money\n3.Withdraw Money\n4.Transfer Amount");
        option = newScanner.nextInt();

        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                DepositMoney();
                break;

            case 3:
                WithdrawMoney();
                break;
            case 4:
                transferMoney();
                break;

            default:
                System.out.println("Invalid option");
                break;
        }

    }

    private void checkAccount() {
        System.out.println("Check Account\n");
        System.out.println(
                "Please select an option:\n1.Check Balance\n2.Deposit Money\n3.Withdraw Money\n4.Transfer Amount");
        option = newScanner.nextInt();

        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                DepositMoney();
                break;

            case 3:
                WithdrawMoney();
                break;
            case 4:
                transferMoney();
                break;

            default:
                System.out.println("Invalid option");
                break;
        }
    }

    private void savingAccount() {
        System.out.println("Savings Account\n");
        System.out.println(
                "Please select an option:\n1.Check Balance\n2.Deposit Money\n3.Withdraw Money\n4.Transfer Amount");
        option = newScanner.nextInt();

        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                DepositMoney();
                break;

            case 3:
                WithdrawMoney();
                break;
            case 4:
                transferMoney();
                break;

            default:
                System.out.println("Invalid option");
                break;
        }
    }

    private void WithdrawMoney() {
        System.out.println("Please enter the amount to Withdraw");
        amount = newScanner.nextFloat();
        System.out.println("You have successfully withdrawn an amount of R" + amount + " your current balance is R"
                + (balance - amount));

    }

    private void DepositMoney() {
        System.out.println("Please enter amount to deposit");
        amount = newScanner.nextFloat();
        System.out.println("Your deposited amount is:R");
        System.out.println("Your current balance is:R");
    }

    private void checkBalance() {
        System.out.println("Your current balance is:R");
    }

    private void transferMoney() {
        System.out.println("Transfer Money");
        ;
    }

    private void enterPin() {
        System.out.print("Please enter your pin:\n");
        int input = newScanner.nextInt();

        if (pinNo == input)
            selectAccount();

    }

}