package bank;

public class CurrentAccount extends BankAccount {
	public CurrentAccount(String accountNumber,String accountHolderName,double initialBalance) {
		
		super(accountNumber,accountHolderName,initialBalance);
	}
	
	public void displayCurrentAccount() {
		System.out.println("-----------Current Account------------");
		System.out.println("Account Type: Current");
		System.out.println("Account Number: "+getAccountNumber());
		System.out.println("Account Holder: "+getAccountHolderName());
		System.out.printf("Balance: %.2f%n",getBalance());
		
	
	}
	
	@Override
	public boolean withdraw(double amount) {
		System.out.println("Processing withdrawal for a Current Account...");
		return super.withdraw(amount);
	}
}
