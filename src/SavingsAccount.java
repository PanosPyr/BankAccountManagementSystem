public class SavingsAccount extends BankAccount{

    SavingsAccount(String accountNumber, double balance, String accountHolderName, String accountType) {
        super(accountNumber, balance, accountHolderName, accountType);
        System.out.println("New savings account created");
    }

    @Override
    public void withdraw(double amount) {
        double currentBalance = getBalance();
        if(currentBalance - amount >= 100){
            System.out.println("Withdrawing: " + amount);
            deposit(-amount);
        }
        else{
            System.out.println("Insufficient funds.");
        }
    }
}
