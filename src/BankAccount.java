public abstract class BankAccount {

    private String accountNumber;
    private double balance;
    private String accountHolderName;
    private String accountType;

    BankAccount(String accountNumber, double balance, String accountHolderName, String accountType){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public abstract void withdraw(double amount);

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public double getBalance(){
        return this.balance;
    }

    public String getAccountHolderName(){
        return this.accountHolderName;
    }

    public void setAccountHolderName(String newHolder){
        this.accountHolderName = newHolder;
    }

    public String getAccountType(){
        return this.accountType;
    }

    public void setAccountType(String newAccountType){
        this.accountType = newAccountType;
    }
}
