import java.io.InputStream;
import java.util.Scanner;

public class ATM_Main {

    int pinNo = 1234;
    int option;
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
        System.out.println("Savings Account");
    }

    private void enterPin() {
        System.out.print("Please enter your pin:\n");
        pinNo = newScanner.nextInt();

        if (pinNo == 1234)
            selectAccount();

    }

}