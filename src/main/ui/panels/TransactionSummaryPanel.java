package ui.panels;

import model.Transaction;
import model.TransactionSummary;

import javax.swing.*;
import java.awt.*;

// Represents a panel that holds the transactionSummary.
public class TransactionSummaryPanel extends JPanel {
    private DataColumn dateColumn;
    private DataColumn detailColumn;
    private DataColumn amountColumn;
    private DataColumn categoryColumn;



    /**
     * @MODIFIES: this
     * @EFFECTS: creates a new TransactionSummaryPanel with a GridLayout manager and initializes 4 empty DataColumns
     */
    public TransactionSummaryPanel(JFrame frame, TransactionSummary ts) {
        setBackground(Color.BLACK);
        setLayout(new GridLayout(1, 4, 2, 2));

        displayTransactions(ts);
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: adds all field column components to the this TransactionSummaryPanel
     */
    private void addColumns() {
        add(dateColumn);
        add(detailColumn);
        add(amountColumn);
        add(categoryColumn);
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: creates new instances of dateColumn, detailColumn, amountColumn and categoryColumn
     */
    private void initializeColumns() {
        dateColumn = new DataColumn();
        detailColumn = new DataColumn();
        amountColumn = new DataColumn();
        categoryColumn = new DataColumn();
        addColumns();
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: loops through TransactionSummary and updates the TransactionSummaryPanel to reflect the current state
     * of TransactionSummary.
     */
    public void displayTransactions(TransactionSummary transactionSummary) {
        initializeColumns();
        for (Transaction t : transactionSummary.getTransactionSummary()) {
            dateColumn.addData(t.getDate().toString());
            detailColumn.addData(t.getDetails());
            amountColumn.addData(String.valueOf(t.getAmount()));
            categoryColumn.addData(t.getCategory());
        }
    }
}
