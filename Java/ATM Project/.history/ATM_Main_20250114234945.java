import java.io.InputStream;
import java.util.Scanner;

public class ATM_Main {

    int pinNo;
    int option;
    Scanner newScanner = new Scanner(System.in);

    public ATM_Main() {
    }

    public static void main(String[] args) {

        ATM_Main new_ATM_Main = new ATM_Main();
        new_ATM_Main.welcome();

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fixedAccount'");
    }

    private void checkAccount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkAccount'");
    }

    private void savingAccount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'savingAccount'");
    }

    private void enterPin(){
    System.out.println("Please enter your pin:");
    pinNo = System.;
    }

}