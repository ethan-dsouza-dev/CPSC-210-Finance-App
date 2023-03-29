package ui;

import model.Transaction;
import model.TransactionSummary;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AddTransactionPane {

    private JFormattedTextField dateField;
    private JTextField detailsField;
    private JFormattedTextField amountField;
    private JTextField categoryField;
    private TransactionSummary summary;
    private TransactionSummaryPanel summaryPanel;
    private JFrame frame;

    public AddTransactionPane(TransactionSummary transactionSummary, TransactionSummaryPanel summaryPanel, JFrame frame) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dateField = new JFormattedTextField(dateFormat);
        detailsField = new JTextField();
        amountField = new JFormattedTextField();
        categoryField = new JTextField();

        ImageIcon icon = new ImageIcon("./data/budget.png");

        Object[][] fields = {
                {"Enter Date (yyyy-mm-dd): ", dateField},
                {"Enter Details: ", detailsField},
                {"Enter Amount: ", amountField},
                {"Enter Category: ", categoryField}
        };


        int option = JOptionPane.showConfirmDialog(null, fields, "Add Transaction",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);

        this.frame = frame;
        this.summary = transactionSummary;
        this.summaryPanel = summaryPanel;
        addToTransactionSummary(transactionSummary, option);
    }

    private void addToTransactionSummary(TransactionSummary transactionSummary, int option) {
        if (option == JOptionPane.OK_OPTION) {
            try {
                Transaction newTransaction = new Transaction(LocalDate.parse(dateField.getText()),
                        detailsField.getText(), Integer.parseInt(amountField.getText()), categoryField.getText());
                updateScreen(newTransaction);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Date was not formatted correctly!",
                        "Date Parse Error", JOptionPane.INFORMATION_MESSAGE);
            }
            System.out.println(transactionSummary.getNumberTransactions());
        }
    }

    /**
     * @MODIFIES: this, TransactionSummaryPanel, GUI
     * @EFFECTS: updates the screen with current state of transactionSummary
     */
    private void updateScreen(Transaction newTransaction) {
        summary.addTransaction(newTransaction);
        summaryPanel.resetColumns();
        summaryPanel.revalidate();
        summaryPanel.repaint();
        summaryPanel.displayTransactions(this.summary);
        summaryPanel.revalidate();
        summaryPanel.repaint();

    }

}

