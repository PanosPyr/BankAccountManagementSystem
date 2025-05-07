public class Transactions extends BankAccount{

    private double amount;
    private String transactionType;

    Transactions(String accountNumber, double balance, String accountHolderName, String accountType, double amount, String transactionType) {
        super(accountNumber, balance, accountHolderName, accountType);
        this.amount = amount;
        this.transactionType = transactionType;
    }

    @Override
    public void withdraw(double amount) { //not used

    }

    public double getAmount(){
        return this.amount;
    }

    public String getTransactionType(){
        return this.transactionType;
    }


}
