public class Account {


    private final String firstName;
    private final String lastName;
    private final long accountNumber;
    private double balance;

    public Account(String firstName, String lastName, long accountNumber, double initialDeposit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
    }
    public String getfirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit (double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("Invalid amount. Deposit must be positive.");
        }
    }

    public double withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        }
        else if (amount < 0) {
            System.out.println("Amount can't be negative");
            return balance;
        }
        else {
            return balance -= amount;
        }
        return amount;
    }



    public void displayDetails() {
        System.out.println("******************************************************");
        System.out.println("Customer Name: " + getfirstName() + " " + getLastName());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Balance: " + getBalance());
        System.out.println("******************************************************");
    }


}
