import java.util.*;

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility(double amount);
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        setBalance(initialBalance);
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    protected void setBalance(double balance) { this.balance = balance; }

    public void deposit(double amount) {
        if (amount > 0) setBalance(balance + amount);
        else System.out.println("Invalid deposit amount");
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) setBalance(balance - amount);
        else System.out.println("Invalid or insufficient funds");
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account: " + accountNumber + ", Holder: " + holderName + ", Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate; // annual

    public SavingsAccount(String accNo, String name, double balance, double interestRate) {
        super(accNo, name, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        // simple interest for demonstration (not realistic)
        return getBalance() * (interestRate/100);
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Applying loan for savings account: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility(double amount) {
        return getBalance() >= amount * 0.2; // arbitrary rule
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        // usually current accounts don't give interest
        return 0;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = Arrays.asList(
            new SavingsAccount("SB1001", "Neha", 10000, 4.0),
            new CurrentAccount("CA2001", "Karan", 5000)
        );

        System.out.println("---- Banking Details ----");
        for (BankAccount a : accounts) {
            a.displayDetails();
            System.out.println("Interest: " + a.calculateInterest());
            if (a instanceof Loanable) {
                Loanable l = (Loanable)a;
                System.out.println("Loan eligibility for 5000: " + l.calculateLoanEligibility(5000));
            }
            System.out.println();
        }
    }
}
