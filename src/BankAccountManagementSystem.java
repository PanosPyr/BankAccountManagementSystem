
public class BankAccountManagementSystem {
    public static void main(String[] args) {

        InputUtils inputUtils = new InputUtils();
        BankService bankService = new BankService();
        boolean exit = false;

        while (!exit) {
            System.out.println("*************************");
            System.out.println("Account Management System");
            System.out.println("*************************");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Get Transactions");
            System.out.println("7. Account Deletion");
            System.out.println("8. Print Account Statements");
            System.out.println("9. Update Information");
            System.out.println("10. Interest calculation");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            int choice = inputUtils.readInt();
            switch (choice) {
                case 1:
                    bankService.createSavingsAccount();
                    break;
                case 2:
                    bankService.createCurrentAccount();
                    break;
                case 3:
                    bankService.accountDeposit();
                    break;
                case 4:
                    bankService.accountWithdraw();
                    break;
                case 5:
                    bankService.accountGetBalance();
                    break;
                case 6:
                    bankService.accountGetTransactions();
                    break;
                case 7:
                    bankService.accountDeletion();
                    break;
                case 8:
                    bankService.accountStatement();
                    break;
                case 9:
                    bankService.accountChanges();
                    break;
                case 10:
                    bankService.calculateInterest();
                    break;
                case 11:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}