package reports;

import transaction.Account;

public class TransactionReport {
    public void generateSummary(Account account) {
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Current Balance: ₹" + account.getBalance());
    }
}
