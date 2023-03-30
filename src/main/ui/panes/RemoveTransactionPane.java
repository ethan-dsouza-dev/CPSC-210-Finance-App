package ui.panes;

import model.TransactionSummary;
import ui.panels.TransactionSummaryPanel;

import javax.swing.*;

public class RemoveTransactionPane {
    private JTextField detailsField;
    private TransactionSummaryPanel summaryPanel;

    // Represents the OptionPane that pops up to get transaction to be removed.
    public RemoveTransactionPane(TransactionSummary transactionSummary, TransactionSummaryPanel summaryPanel) {

        this.detailsField = new JTextField();
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
            System.out.println(transactionSummary.getNumberTransactions());
        }
    }

    /**
     * @MODIFIES: summaryPanel
     * @EFFECTS: clears all panels from frame and then adds current state of summary to summaryPanel
     */
    private void updateDisplay(TransactionSummary transactionSummary, TransactionSummaryPanel summaryPanel) {
        summaryPanel.removeAll();
        summaryPanel.displayTransactions(transactionSummary);
        summaryPanel.revalidate();
        summaryPanel.repaint();
    }

}
