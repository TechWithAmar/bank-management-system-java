import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String name;
    private String password;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountNumber, String name, String password) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.password = password;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
            System.out.println("Amount Deposited Successfully!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
            System.out.println("Amount Withdrawn Successfully!");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No Transactions Found.");
        } else {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}
