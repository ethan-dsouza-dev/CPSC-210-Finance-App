package ui.panes;

import model.Transaction;
import model.TransactionSummary;
import ui.panels.TransactionSummaryPanel;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

// Represents JOptionPane that opens to get Data for a transaction when user is adding it.
public class AddTransactionPane {

    private JFormattedTextField dateField;
    private JTextField detailsField;
    private JFormattedTextField amountField;
    private JTextField categoryField;
    private TransactionSummary summary;
    private TransactionSummaryPanel summaryPanel;
    private JFrame frame;

    /**
     * @EFFECTS: creates a new AddTransactionPane with fields initialised to JFormattedTextFields
     */
    public AddTransactionPane(TransactionSummary transactionSummary, TransactionSummaryPanel summaryPanel,
                              JFrame frame) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dateField = new JFormattedTextField(dateFormat);
        detailsField = new JTextField();

        amountField = new JFormattedTextField();
        categoryField = new JTextField();

        ImageIcon icon = new ImageIcon("./data/images/budget.png");

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

    /**
     * @REQUIRES: amountField to be a String that can be parsed to an int.
     * @MODIFIES: this
     * @EFFECTS: if the Ok button is pressed then the transaciton is added to transactionSummary
     */
    private void addToTransactionSummary(TransactionSummary transactionSummary, int option) {
        if (option == JOptionPane.OK_OPTION) {
            try {
                Transaction newTransaction = new Transaction(LocalDate.parse(dateField.getText()),
                        detailsField.getText(), Integer.parseInt(amountField.getText()), categoryField.getText());
                updateScreen(newTransaction);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Date was not formatted correctly!",
                        "Date Parse Error", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Amount was not formatted correctly!",
                        "Amount Parse Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * @MODIFIES: this, TransactionSummaryPanel, GUI
     * @EFFECTS: updates the screen with current state of transactionSummary
     */
    private void updateScreen(Transaction newTransaction) {
        summary.addTransaction(newTransaction);
        summaryPanel.removeAll();
        summaryPanel.displayTransactions(this.summary);
        summaryPanel.revalidate();
        summaryPanel.repaint();

    }

}

