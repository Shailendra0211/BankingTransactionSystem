
package bank;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BankService bank = new BankService();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            displayMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    createSavingsAccount();
                    break;

                case 2:
                    createCurrentAccount();
                    break;

                case 3:
                    searchAccount();
                    break;

                case 4:
                    depositMoney();
                    break;

                case 5:
                    withdrawMoney();
                    break;

                case 6:
                    checkBalance();
                    break;

                case 7:
                    viewTransactionHistory();
                    break;

                case 8:
                    bank.displayAllAccounts();
                    break;

                case 9:
                    running = false;
                    System.out.println(
                        "Thank you for using our banking system!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please select 1 to 9."
                    );
            }
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println("\n========================================");
        System.out.println(" BANKING & TRANSACTION MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Create Savings Account");
        System.out.println("2. Create Current Account");
        System.out.println("3. Search Account");
        System.out.println("4. Deposit Money");
        System.out.println("5. Withdraw Money");
        System.out.println("6. Check Balance");
        System.out.println("7. View Transaction History");
        System.out.println("8. Display All Accounts");
        System.out.println("9. Exit");
        System.out.println("========================================");
    }

    private static void createSavingsAccount() {

        System.out.println("\n--- Create Savings Account ---");

        String number = readText("Enter account number: ");
        String name = readText("Enter account holder name: ");
        double balance = readDouble("Enter initial balance: ");

        try {
            SavingsAccount account =
                new SavingsAccount(number, name, balance);

            bank.addAccount(account);

        } catch (IllegalArgumentException e) {
            System.out.println("Account creation failed: "
                               + e.getMessage());
        }
    }

    private static void createCurrentAccount() {

        System.out.println("\n--- Create Current Account ---");

        String number = readText("Enter account number: ");
        String name = readText("Enter account holder name: ");
        double balance = readDouble("Enter initial balance: ");

        try {
            CurrentAccount account =
                new CurrentAccount(number, name, balance);

            bank.addAccount(account);

        } catch (IllegalArgumentException e) {
            System.out.println("Account creation failed: "
                               + e.getMessage());
        }
    }

    private static void searchAccount() {

        String number = readText("Enter account number to search: ");
        BankAccount account = bank.findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
        } else {
            account.displayAccountDetails();
        }
    }

    private static void depositMoney() {

        String number = readText("Enter account number: ");
        double amount = readDouble("Enter deposit amount: ");

        bank.depositMoney(number, amount);
    }

    private static void withdrawMoney() {

        String number = readText("Enter account number: ");
        double amount = readDouble("Enter withdrawal amount: ");

        bank.withdrawMoney(number, amount);
    }

    private static void checkBalance() {

        String number = readText("Enter account number: ");
        bank.checkBalance(number);
    }

    private static void viewTransactionHistory() {

        String number = readText("Enter account number: ");
        BankAccount account = bank.findAccount(number);

        if (account == null) {
            System.out.println("Account not found.");
        } else {
            account.displayTransactionHistory();
        }
    }

    private static String readText(String prompt) {

        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readInt(String prompt) {

        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static double readDouble(String prompt) {

        while (true) {
            try {
                System.out.print(prompt);
                double value =
                    Double.parseDouble(scanner.nextLine().trim());

                if (!Double.isFinite(value)) {
                    System.out.println("Enter a finite numeric value.");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount.");
            }
        }
    }
}
