package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class TransactionSummary {

    private ArrayList<Transaction> transactions;

    /**
     * @EFFECTS: creates a new TransactionSummary object with an empty list of transactions.
     */
    public TransactionSummary() {
        transactions = new ArrayList<>();
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: adds a new transaction to the end of transactionSummary.
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    /**
     * @EFFECTS: returns a list of transactions in transactionSummary
     */
    public ArrayList<Transaction> getTransactionSummary() {
        return transactions;
    }

    /**
     * @REQUIRES: transaction to be in list
     * @MODIFIES: this
     * @EFFECTS: removes the transaction at given index
     */
    public void removeTransaction(int index) {
        transactions.remove(index);
    }

    /**
     * @REQUIRES: an element to exist at given index
     * @EFFECTS: returns transaction at given index
     */
    public Transaction getTransactionAtIndex(int index) {
        return transactions.get(index);
    }

    /**
     * @REQUIRES: atleast one element to be in the list.
     * @EFFECTS: returns the transaction with the greatest amount.
     */
    public Transaction findGreatestTransaction() {
        Transaction maxAmountTransaction = null;
        int maxAmount = 0;

        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > maxAmount) {
                maxAmountTransaction = transaction;
                maxAmount = (int) transaction.getAmount();
            }
        }
        return maxAmountTransaction;
    }

    public Transaction findGreatestTransactionForMonth() {
        Transaction maxAmountTransaction = null;
        int maxAmount = 0;
        int numberOfElements = transactions.size();
        LocalDate now = LocalDate.now(); // 2015-11-24
        LocalDate pastMonth = now.minusMonths(1);

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();

            long diff = ChronoUnit.DAYS.between(transactionDate, now);

            if (transaction.getAmount() > maxAmount && diff < 30) {
                maxAmountTransaction = transaction;
                maxAmount = (int) transaction.getAmount();
            }
        }
        return maxAmountTransaction;
    }
}
