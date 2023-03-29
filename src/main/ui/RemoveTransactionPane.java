package ui;

import model.Transaction;
import model.TransactionSummary;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class RemoveTransactionPane {
    private JTextField detailsField;
    private TransactionSummaryPanel summaryPanel;

    public RemoveTransactionPane(TransactionSummary transactionSummary, TransactionSummaryPanel summaryPanel) {

        this.detailsField = new JTextField();
        this.summaryPanel = summaryPanel;

        Object[][] field = {
                {"Enter transaction Detail to delete: ", detailsField}
        };

        int option = JOptionPane.showConfirmDialog(null, field,
                "Remove Transaction", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            transactionSummary.removeTransactionWithDetails(detailsField.getText());
            updateDisplay(transactionSummary, summaryPanel);
            System.out.println(transactionSummary.getNumberTransactions());
        }
    }

    /**
     * @MODIFIES: summaryPanel
     * @EFFECTS: clears all panels from frame and then adds current state of summary to summaryPanel
     */
    private void updateDisplay(TransactionSummary transactionSummary, TransactionSummaryPanel summaryPanel) {
        summaryPanel.clear();
        summaryPanel.displayTransactions(transactionSummary);
        summaryPanel.revalidate();
        summaryPanel.repaint();
    }

}
