import java.util.Scanner;

// Task 1: Create a class to represent the ATM machine
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    // Task 3: Implement methods for each option
    public String withdraw(double amount) {
        if (amount > bankAccount.getBalance()) {
            return "Insufficient balance";
        } else if (amount <= 0) {
            return "Invalid amount";
        } else {
            bankAccount.setBalance(bankAccount.getBalance() - amount);
            return "Withdrawal successful. New balance: $" + String.format("%.2f", bankAccount.getBalance());
        }
    }

    public String deposit(double amount) {
        if (amount <= 0) {
            return "Invalid deposit amount";
        } else {
            bankAccount.setBalance(bankAccount.getBalance() + amount);
            return "Deposit successful. New balance: $" + String.format("%.2f", bankAccount.getBalance());
        }
    }

    public String checkBalance() {
        return "Your balance is: $" + String.format("%.2f", bankAccount.getBalance());
    }
}

// Task 4: Create a class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

// Task 6: Validate user input and display messages
public class Main {
    public static void main(String[] args) {
        // Task 5: Connect the ATM class with the bank account class
        BankAccount account = new BankAccount(100.00);  // Example starting balance of $100
        ATM atm = new ATM(account);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nATM Interface:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println(atm.withdraw(withdrawAmount));
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println(atm.deposit(depositAmount));
                    break;
                case 3:
                    System.out.println(atm.checkBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}

