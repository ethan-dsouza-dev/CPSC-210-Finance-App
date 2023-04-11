package ui.panes;

import model.TransactionSummary;
import ui.panels.TransactionSummaryPanel;

import javax.swing.*;

public class RemoveTransactionPane {
    private JTextField detailsField;
    private TransactionSummary summary;
    private TransactionSummaryPanel summaryPanel;

    // Represents the OptionPane that pops up to get transaction to be removed.
    public RemoveTransactionPane(TransactionSummary transactionSummary, TransactionSummaryPanel summaryPanel) {

        this.detailsField = new JTextField();
        this.summary = transactionSummary;
        this.summaryPanel = summaryPanel;

        Object[][] field = {
                {"Enter transaction Detail to delete: ", detailsField}
        };

        ImageIcon icon = new ImageIcon("./data/images/trash.png");

        int option = JOptionPane.showConfirmDialog(null, field,
                "Remove Transaction", JOptionPane.YES_NO_OPTION, JOptionPane.NO_OPTION, icon);

        if (option == JOptionPane.OK_OPTION) {
            transactionSummary.removeTransactionWithDetails(detailsField.getText());
            updateDisplay(transactionSummary, summaryPanel);
        }
    }

    /**
     * @MODIFIES: summaryPanel
     * @EFFECTS: clears all panels from frame and then adds current state of summary to summaryPanel
     */
    private void updateDisplay(TransactionSummary transactionSummary, TransactionSummaryPanel summaryPanel) {
        this.summaryPanel.removeAll();
        this.summaryPanel.displayTransactions(transactionSummary);
        this.detailsField.revalidate();
        this.summaryPanel.repaint();
    }

}
