import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BankService{

    private InputUtils inputUtils;
    ArrayList<BankAccount> accounts;
    ArrayList<Transactions> transactions;

    BankService() {
        this.accounts = new ArrayList<BankAccount>();
        this.inputUtils = new InputUtils();
        this.transactions = new ArrayList<Transactions>();
    }

    public void createSavingsAccount(){
        System.out.println("Enter your name to create a savings account:");
        String accountOwner = inputUtils.readString();
        System.out.println("Enter your account number:");
        String accountNumber = inputUtils.readString();
        System.out.println("Enter your balance:");
        double accountBalance = inputUtils.readDouble();
        accounts.add(new SavingsAccount(accountNumber, accountBalance, accountOwner, "Savings"));
        transactions.add(new Transactions(accountNumber,accountBalance,accountOwner,"Savings",accountBalance,"Deposit"));
    }

    public void createCurrentAccount(){
        System.out.println("Enter your name to create a current account:");
        String accountOwner = inputUtils.readString();
        System.out.println("Enter your account number:");
        String accountNumber = inputUtils.readString();
        System.out.println("Enter your balance:");
        double accountBalance = inputUtils.readDouble();
        System.out.println("Enter account accountOverdraft:");
        int accountOverdraft = inputUtils.readInt();
        accounts.add(new CurrentAccount(accountNumber, accountBalance, accountOwner, "Current", accountOverdraft));
        transactions.add(new Transactions(accountNumber,accountBalance,accountOwner,"Current",accountBalance,"Deposit"));
    }

    private BankAccount findAccount(){
        System.out.print("Enter account number: ");
        String accountNumber = inputUtils.readString();
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    private void switchToSavings(BankAccount account){
        String accountOwner = account.getAccountHolderName();
        String accountNumber = account.getAccountNumber();
        double accountBalance = account.getBalance();
        accounts.remove(account);
        accounts.add(new SavingsAccount(accountNumber, accountBalance, accountOwner, "Savings"));
        System.out.println("Account successfully changed to Savings");
    }

    private void switchToCurrent(BankAccount account){
        String accountOwner = account.getAccountHolderName();
        String accountNumber = account.getAccountNumber();
        double accountBalance = account.getBalance();
        System.out.print("Enter account accountOverdraft:");
        int accountOverdraft = inputUtils.readInt();
        accounts.remove(account);
        accounts.add(new CurrentAccount(accountNumber, accountBalance, accountOwner, "Current", accountOverdraft));
        System.out.println("Account successfully changed to Current");
    }


    public void accountDeposit(){
        BankAccount account = findAccount();
        if(account != null){

            System.out.print("Enter amount to deposit: ");
            double amount = inputUtils.readDouble();
            account.deposit(amount);
            transactions.add(new Transactions(account.getAccountNumber(),account.getBalance(),account.getAccountHolderName(),account.getAccountType(),amount,"Deposit"));

        }
    }

    public void accountWithdraw(){
        BankAccount account = findAccount();
        if(account != null){
            System.out.print("Enter amount to withdraw: ");
            double amount = inputUtils.readDouble();
            account.withdraw(amount);
            transactions.add(new Transactions(account.getAccountNumber(),account.getBalance(),account.getAccountHolderName(),account.getAccountType(),amount,"Withdraw"));
        }
    }

    public void accountGetBalance(){
        BankAccount account = findAccount();
        if(account != null){
            System.out.println("The account" + account.getAccountNumber() + "has" + account.getBalance());
        }
    }

    public void accountGetTransactions(){
        BankAccount account = findAccount();
        if(account != null) {
            for (Transactions transaction : transactions) {
                if (transaction.getAccountNumber().equals(account.getAccountNumber())) {
                    System.out.println(transaction.getAccountNumber() + " " + transaction.getAmount() + " " + transaction.getTransactionType());
                }
            }
        }
    }

    public void accountDeletion(){
        BankAccount account = findAccount();
        if(account != null){
            accounts.remove(account);
            System.out.print("Account deleted");
        }
    }

    public void accountStatement(){
        BankAccount account = findAccount();
        if(account != null) {
            System.out.println("Statement for " + account.getAccountType() + " account " + account.getAccountNumber() + " of owner: " + account.getAccountHolderName());
            for (Transactions transaction : transactions) {
                if (transaction.getAccountNumber().equals(account.getAccountNumber())) {
                    System.out.println("Movement: " + transaction.getTransactionType() + " Amount of movement: " + transaction.getAmount() + " Balance: " + transaction.getBalance());
                }
            }
        }
    }

    public void accountChanges(){
        BankAccount account = findAccount();
        boolean correctChoice = false;
        if(account != null) {
            while(!correctChoice) {
                System.out.println("Choose what to change:");
                System.out.println("1. Account Holder");
                System.out.println("2. Account type");
                int choice = inputUtils.readInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter new holders name: ");
                        String newHolder = inputUtils.readString();
                        account.setAccountHolderName(newHolder);
                        System.out.println("New holder is " + account.getAccountHolderName());
                        correctChoice = true;
                        break;
                    case 2:
                        if (account.getAccountType().equals("Current")) {
                            switchToSavings(account);
                        } else {
                            switchToCurrent(account);
                        }
                        correctChoice = true;
                        break;

                    default:
                        correctChoice = false;
                        System.out.println("Invalid choice. Please try again.");
                }
            }

        }
    }

    public void calculateInterest(){
        BankAccount account = findAccount();
        if(account != null) {
            if(account.getAccountType().equals("Savings")){
                System.out.print("This account currently has:  $" + account.getBalance());
                System.out.print("Enter amount of money: ");
                double amount = inputUtils.readDouble();
                System.out.print("Enter interest percentage (in %): ");
                double interestRate = inputUtils.readDouble() / 100.0;
                System.out.print("Enter years of interest: ");
                int years = inputUtils.readInt();

                double interest = amount * interestRate * years;
                System.out.println("Interest is: " + interest);
            }
            else{
                System.out.println("Interest can only be calculated in a savings account.");
            }
        }
    }
}
