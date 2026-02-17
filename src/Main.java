import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);


        double balance = 0;
        boolean isRunning = true;
        int choice;


        while (isRunning) {
            System.out.println("*********************");
            System.out.println("POP BANK");
            System.out.println("Welcome to Pop Bank");
            System.out.println("*********************");
            System.out.println("1. Create Account");
            System.out.println("2. Make a Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. View Account Details");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.println("*********************");

            System.out.print("Enter your choice(1 - 6): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\n--- Create New Account ---");
                    scanner.nextLine();
                    System.out.print("Enter your first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter your last name: ");
                    String lastName = scanner.nextLine();
                    // Generate random 10-digit account number
                    long accountNumber = (long)(Math.random() * 9_000_000_000L) + 1_000_000_000L;

                    System.out.print("Enter initial deposit: ");
                    double initialDeposit = scanner.nextDouble();

                    Account newAccount =  new Account(firstName, lastName, accountNumber, initialDeposit);

                    //Add to arraylist
                    accounts.add(newAccount);

                    // Print confirmation with the generated account number
                    System.out.println("\n✓ Account created successfully!");
                    System.out.println("Your account number is: " + accountNumber);
                    System.out.println("Account balance: $" + initialDeposit);
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("\n--- Make a deposit ---");
                    scanner.nextLine();
                    System.out.print("Enter your account number: ");
                    long accNumber = scanner.nextLong();

                    Account account = findAccount(accounts, accNumber);

                    if (account != null) {
                        // Account found, ask for deposit amount
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();

                        // Call the deposit method
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    System.out.println();
                }
                case 3 -> System.out.println("Here is your Balance");
                case 4 -> System.out.println("Account Details");
                case 5 -> System.out.println("Amount Withdrawn");
                case 6 -> isRunning = false;
                default -> System.out.println("Pick between 1 - 6");
            }
        }
        System.out.println("*************************************");
        System.out.println("Thank you for banking with POP BANK!");
        System.out.println("Have a nice day!");
        System.out.println("*************************************");

        scanner.close();
    }
    public static Account findAccount(ArrayList<Account> accounts, long accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null; // Account not found
    }
}
