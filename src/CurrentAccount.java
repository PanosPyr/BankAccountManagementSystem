public class CurrentAccount extends BankAccount{

    private int overdraft;

    CurrentAccount(String accountNumber, double balance, String accountHolderName, String accountType, int overdraft) {
        super(accountNumber, balance, accountHolderName, accountType);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount) {
        double currentBalance = getBalance();
        if(currentBalance - amount >= -(this.overdraft)){
            System.out.println("Withdrawing: " + amount);
            deposit(-amount);
        }
        else{
            System.out.println("Overdraft limit exceeded.");
        }
    }

    public double getOverdraft(){
        return this.overdraft;
    }

    public void setOverdraft(int newOverdraft){
        this.overdraft = newOverdraft;
    }
}
