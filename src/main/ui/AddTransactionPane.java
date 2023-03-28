package ui;

import model.Transaction;
import model.TransactionSummary;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class AddTransactionPane {

    private JButton confirmButton;
    private JOptionPane fieldPane;
    private JFormattedTextField dateField;
    private JTextField detailsField;
    private JFormattedTextField amountField;
    private JTextField categoryField;
    private TransactionSummary newTransactionSummary;

    public AddTransactionPane(TransactionSummary transactionSummary) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dateField = new JFormattedTextField(dateFormat);
        detailsField = new JTextField();
        amountField = new JFormattedTextField();
        categoryField = new JTextField();

        Object[][] fields = {
                {"Enter Date (yyyy-mm-dd): ", dateField},
                {"Enter Details: ", detailsField},
                {"Enter Amount: ", amountField},
                {"Enter Category: ", categoryField}
        };

        int option = JOptionPane.showConfirmDialog(null, fields,"Add Transaction", JOptionPane.OK_CANCEL_OPTION);

        this.newTransactionSummary = transactionSummary;
        if (option == JOptionPane.OK_OPTION) {
            Transaction newTransaction = new Transaction(LocalDate.parse(dateField.getText()), detailsField.getText(),
                    Integer.parseInt(amountField.getText()), categoryField.getText());
            newTransactionSummary.addTransaction(newTransaction);
            System.out.println(transactionSummary.getNumberTransactions());
        }
    }

}
