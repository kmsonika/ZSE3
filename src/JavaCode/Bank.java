package JavaCode;

import java.util.Scanner;

public class Bank 
{
	private int account_Number;
	private String account_Holder_Name;
	private String branch_Name;
	private int pin;
	
	public Bank(int account_Number, String account_Holder_Name, String branch_Name, int pin )
	{	
	this.account_Number=account_Number;
	this.account_Holder_Name=account_Holder_Name;
	this.branch_Name=branch_Name;
	this.pin=pin;
	}
	
	 // Getter methods
    public int getAccountNumber() {
        return account_Number;
    }

    public int getPin() {
        return pin;
    }

    // Setter method for PIN
    public void setPin(int newPin) {
        this.pin = newPin;
    }

	
    // Static method to securely change PIN
    public static void Pin_change(Bank[] accounts, int targetAccountNumber, int oldPin, int newPin) 
    {
        boolean found = false;

        for (Bank account : accounts) 
        {
            if (account.getAccountNumber() == targetAccountNumber) 
            {
                found = true;
                if (account.getPin() == oldPin) 
                {
                    account.setPin(newPin);
                    System.out.println("PIN changed successfully for account number: " + targetAccountNumber);
                
            } 
                else 
                {
                System.out.println("❌ Incorrect old PIN for account number: " + targetAccountNumber);
                }
            break;
        }
    }

    if (!found) 
    {
        System.out.println("❌ Account number " + targetAccountNumber + " not found.");
    }
           

    }
	
	public void showDetails()
	{
		System.out.println("Account number : " +this.account_Number+ ",\t Holder Name : \t" +this.account_Holder_Name+ ",\t Branch :\t" + this.branch_Name+",\t Pin : \t" +this.pin);
	}
	
	
	public static void main(String[] args) 
	{
		   
        Scanner scanner = new Scanner(System.in);
        // Creating 5 Bank objects
        Bank[] accounts = new Bank[5];
        accounts[0] = new Bank(1001,"Sonika","Noida",1234);
        accounts[1] = new Bank(1002,"Kajal","G.Noida",5678);
        accounts[2] = new Bank(1003,"Kamal","Delhi",2123);
        accounts[3] = new Bank(1004,"Shweta","Gurgaon",4567);
        accounts[4] = new Bank(1005,"Mohseen","Patna",8908);
        
     // Before PIN change
        System.out.println("Before PIN change:");
        for (Bank acc : accounts) 
        {
            acc.showDetails();
        }
     

        // User input for PIN change
        System.out.println("\nEnter details to change PIN:");
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();

        System.out.print("Enter Current PIN: ");
        int oldPin = scanner.nextInt();

        System.out.print("Enter new PIN: ");
        int newPin = scanner.nextInt();

        // Attempt to change PIN
        Pin_change(accounts, accNum, oldPin, newPin);

        // Display after PIN change
        System.out.println("\nAfter PIN change:");
        for (Bank acc : accounts) 
        {
            acc.showDetails();
        }

        scanner.close();

}}
