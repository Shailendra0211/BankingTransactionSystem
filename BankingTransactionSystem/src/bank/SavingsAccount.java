package bank;

public class SavingsAccount extends BankAccount{
	public SavingsAccount(String accountNumber,String accountHolderName,double initialBalance) {
		super(accountNumber,accountHolderName,initialBalance);
	}
	
	public void displaySavingsAccount() {
		System.out.println("-----------Saving Account-----------");
		System.out.println("Account Type: Savings");
		System.out.println("Account Number: "+ getAccountNumber());
		System.out.println("Account Holder: "+ getAccountHolderName());
		System.out.printf("Balance: %.2f%n",getBalance());
	}


@Override
public boolean withdraw(double amount) {
	if(!Double.isFinite(amount)|| amount<=0) {
		System.out.println("Error: Withdrawal amount must be greater than zero.");
		return false;
	}
	
	double minimumBalance=500.00;
	
	if(amount>getBalance()-minimumBalance) {
		System.out.println("Withdrawal denied: Minimum balance of Rs.500 required.");
		return false;
	}
	return super.withdraw(amount);
	
}

}