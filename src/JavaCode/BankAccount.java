package JavaCode;
import java.util.Scanner;

public class BankAccount {
    private int accountNumber;
    private int pin;

    // Constructor
    public BankAccount(int accountNumber, int pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;
    }

    // Getter methods
    public int getAccountNumber() {
        return accountNumber;
    }

    public int getPin() {
        return pin;
    }

    // Setter method for PIN
    public void setPin(int newPin) {
        this.pin = newPin;
    }

    // Static method to securely change PIN
    public static void Pin_change(BankAccount[] accounts, int targetAccountNumber, int oldPin, int newPin) {
        boolean found = false;

        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == targetAccountNumber) {
                found = true;
                if (account.getPin() == oldPin) {
                    account.setPin(newPin);
                    System.out.println("✅ PIN changed successfully for account number: " + targetAccountNumber);
                } else {
                    System.out.println("❌ Incorrect old PIN for account number: " + targetAccountNumber);
                }
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Account number " + targetAccountNumber + " not found.");
        }
    }

    // Display method for testing
    public void display() {
        System.out.println("Account Number: " + accountNumber + ", PIN: " + pin);
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating 5 BankAccount objects
        BankAccount[] accounts = new BankAccount[5];
        accounts[0] = new BankAccount(101, 1234);
        accounts[1] = new BankAccount(102, 2345);
        accounts[2] = new BankAccount(103, 3456);
        accounts[3] = new BankAccount(104, 4567);
        accounts[4] = new BankAccount(105, 5678);

        // Display before PIN change
        System.out.println("🔍 Before PIN change:");
        for (BankAccount acc : accounts) 
        {
            acc.display();
        }

        // User input for PIN change
        System.out.println("\n🔐 Enter details to change PIN:");
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();

        System.out.print("Enter old PIN: ");
        int oldPin = scanner.nextInt();

        System.out.print("Enter new PIN: ");
        int newPin = scanner.nextInt();

        // Attempt to change PIN
        Pin_change(accounts, accNum, oldPin, newPin);

        // Display after PIN change
        System.out.println("\n🔄 After PIN change:");
        for (BankAccount acc : accounts) {
            acc.display();
        }

        scanner.close();
    }
}