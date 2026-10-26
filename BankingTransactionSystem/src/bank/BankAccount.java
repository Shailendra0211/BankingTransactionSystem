package bank;
import java.util.ArrayList;

public class BankAccount {
	private String accountNumber;
	private String accountHolderName;
	private double balance;
	private ArrayList<Transaction>transactions=new ArrayList<>();
	
	//constructor
	public BankAccount(String accountNumber,String accountHolderName,double initialBalance) {
		if(accountNumber==null || accountNumber.trim().isEmpty()) {
			throw new IllegalArgumentException("Account number cannot be empty.");
		}
		
		if(accountHolderName==null || accountHolderName.trim().isEmpty()) {
			throw new IllegalArgumentException("Account holder name cannot be empty.");
		}
		
		if(!Double.isFinite(initialBalance)||initialBalance<0) {
			throw new IllegalArgumentException("Initial balance cannot be negative or invalid.");
		}
		this.accountNumber=accountNumber;
		this.accountHolderName=accountHolderName;
		this.balance=initialBalance;
	}
	
	
	//Getter methods
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	//Deposit money
	public boolean deposit(double amount) {
		if(!Double.isFinite(amount)|| amount<=0) {
			System.out.println("Error: Deposit amount must be greater than zero.");
		return false;
		}
		
		if(!Double.isFinite(balance + amount)) {
			System.out.println("Error: Balance limit exceeded.");
			return false;
		}
		
		balance+=amount;
		
		transactions.add(new Transaction("DEPOSIT",amount,"SUCCESS"));
		System.out.printf("Deposit Successful! Amount: %.2f%n",amount);
		return true;
		
	}
	
	//Withdraw money
	public boolean withdraw(double amount) {
		
		if(!Double.isFinite(amount)|| amount <=0) {
			System.out.println("Error:Withdrawal amount must be greater than zero.");
			return false;
		}
		
		if(amount>balance) {
			System.out.println("Error : Insufficient balance.");
			return false;
		}
		
		balance-=amount;
		
		transactions.add(new Transaction("WITHDRAWAL",amount,"SUCCESS"));
		
		
		System.out.printf("Withdrawal Syccessful! Amount:%.2f%n",amount);
		return true;
	}
	
	//Display account details
	public void displayAccountDetails() {
		System.out.println("\n---------Account Details--------");
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Account Holder: "+accountHolderName);
		System.out.printf("Balance: %.2f%n ",balance);
	}
	
	public void displayTransactionHistory() {
		System.out.println("--------------Transaction History-------------");
		if(transactions.isEmpty()) {
			System.out.println("No transactions found.");
			return;
		}
		
		for(Transaction transaction:transactions) {
			transaction.displayTransaction();
		}
	}
}
