   import transaction.Account;
import reports.TransactionReport;

public class MainApplication {
    public static void main(String[] args) {
        Account myAccount = new Account("ACT123456789", 5000.00);
        TransactionReport report = new TransactionReport();

        System.out.println("Initial State:");
        report.generateSummary(myAccount);

        System.out.println("\n--- Executing Transactions ---");
        myAccount.deposit(1500.50);
        myAccount.withdraw(2000.00);
        myAccount.withdraw(6000.00);

        System.out.println("\nFinal State:");
        report.generateSummary(myAccount);
    }
}
