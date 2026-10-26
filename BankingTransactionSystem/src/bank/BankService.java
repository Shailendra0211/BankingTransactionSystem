
package bank;

import java.util.HashMap;
import java.util.Map;

public class BankService {

    private HashMap<String, BankAccount> accounts =
            new HashMap<>();

    // Register a new account
    public boolean addAccount(BankAccount account) {

        if (account == null) {
            System.out.println("Error: Account cannot be null.");
            return false;
        }

        String accountNumber = account.getAccountNumber();

        if (accounts.containsKey(accountNumber)) {
            System.out.println(
                "Error: Account number already exists."
            );
            return false;
        }

        accounts.put(accountNumber, account);

        System.out.println(
            "Account registered successfully: " + accountNumber
        );

        return true;
    }

    // Find account by account number
    public BankAccount findAccount(String accountNumber) {

        if (accountNumber == null) {
            return null;
        }

        return accounts.get(accountNumber);
    }

    // Display all registered accounts
    public void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts registered.");
            return;
        }

        System.out.println("\n===== ALL BANK ACCOUNTS =====");

        for (Map.Entry<String, BankAccount> entry
                : accounts.entrySet()) {

            System.out.println(
                "\nAccount Number: " + entry.getKey()
            );

            entry.getValue().displayAccountDetails();
        }
    }

    // Return the number of registered accounts
    public int getAccountCount() {
        return accounts.size();
    }
    
    

public boolean depositMoney(String accountNumber, double amount) {

    BankAccount account = findAccount(accountNumber);

    if (account == null) {
        System.out.println("Error: Account not found.");
        return false;
    }

    return account.deposit(amount);
}

public boolean withdrawMoney(String accountNumber, double amount) {

    BankAccount account = findAccount(accountNumber);

    if (account == null) {
        System.out.println("Error: Account not found.");
        return false;
    }

    return account.withdraw(amount);
}

public void checkBalance(String accountNumber) {

    BankAccount account = findAccount(accountNumber);

    if (account == null) {
        System.out.println("Error: Account not found.");
        return;
    }

    System.out.printf(
        "Available balance: Rs. %.2f%n",
        account.getBalance()
    );
}

}
