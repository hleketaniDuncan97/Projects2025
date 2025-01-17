import java.io.InputStream;
import java.util.Scanner;

public class ATM_Main {

    int pinNo = 1234;
    int option;
    float balance;
    float amount;
    Scanner newScanner = new Scanner(System.in);

    public ATM_Main() {
    }

    public static void main(String[] args) {

        ATM_Main newAtmMain = new ATM_Main();
        newAtmMain.welcome();
        newAtmMain.enterPin();

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
        System.out.println("Fixed Account");

    }

    private void checkAccount() {
        System.out.println("Check Account");
    }

    private void savingAccount() {
        System.out.println("Savings Account\n");
        System.out.println("Please select an option:\n1.Check Balance\n2.Deposit Money
        \n3.Withdraw Money\n4.Transfer Amount");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'WithdrawMoney'");
    }

    private void DepositMoney() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'DepositMoney'");
    }

    private void checkBalance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkBalance'");
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