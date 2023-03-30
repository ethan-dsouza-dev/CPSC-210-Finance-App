package ui.panels;

import model.Transaction;
import model.TransactionSummary;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.panes.AddTransactionPane;
import ui.panes.RemoveTransactionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

// Represents a panel that holds the add, remove, save and load button.
public class ButtonPanel extends JPanel implements ActionListener {
    private JButton addTransactionBtn;
    private JButton removeTransactionBtn;
    private JButton saveButton;
    private JButton loadButton;
    private JButton greatestTransactionBtn;
    private JFrame frame;

    private static final String JSON_STORE = "./data/summary.json";
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private TransactionSummary summary;
    private TransactionSummaryPanel summaryPanel;



    public ButtonPanel(JFrame frame, TransactionSummaryPanel summaryPanel, TransactionSummary ts) {

        super();

        initializeFields(frame, summaryPanel, ts);

        createAddButton();
        createRemoveButton();
        createSaveButton();
        createLoadButton();

        this.setBackground(Color.darkGray);
        this.setPreferredSize(new Dimension(100, 60));
        addButtonsToPanel();
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: adds all buttons to this panel
     */
    private void addButtonsToPanel() {
        this.add(addTransactionBtn);
        this.add(removeTransactionBtn);
        this.add(saveButton);
        this.add(loadButton);
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: initialises all fields
     */
    private void initializeFields(JFrame frame, TransactionSummaryPanel summaryPanel, TransactionSummary ts) {
        this.frame = frame;
        this.summary = ts;
        this.summaryPanel = summaryPanel;
        this.jsonReader = new JsonReader(JSON_STORE);
        this.jsonWriter = new JsonWriter(JSON_STORE);
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: creates a new instance of a JButton with text : "Add" and ActionListener linked to this ButtonPanel
     */
    private void createAddButton() {
        addTransactionBtn = new JButton("Add");
        addTransactionBtn.setActionCommand("addTransaction");
        addTransactionBtn.addActionListener(this);
        addTransactionBtn.setFocusable(false);
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: creates a new instance of a JButton with text "Remove" and adds ActionListener to that button,
     * linked to this ButtonPanel
     */
    private void createRemoveButton() {
        removeTransactionBtn = new JButton("Remove");
        removeTransactionBtn.setActionCommand("removeTransaction");
        removeTransactionBtn.addActionListener(this);
        removeTransactionBtn.setFocusable(false);
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: creates a new instance of a JButton with text "Load" and adds ActionListener to that button,
     * linked to this ButtonPanel
     */
    private void createLoadButton() {
        loadButton = new JButton("Load");
        loadButton.setActionCommand("loadTransactions");
        loadButton.addActionListener(this);
        loadButton.setFocusable(false);
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: creates a new instance of a JButton with text "Save" and adds ActionListener to that button,
     * linked to this ButtonPanel
     */
    private void createSaveButton() {
        saveButton = new JButton("Save");
        saveButton.setActionCommand("saveTransactions");
        saveButton.addActionListener(this);
        saveButton.setFocusable(false);
    }

//    /**
//     * @MODIFIES: this
//     * @EFFECTS: creates a new instance of a JButton with text "Greatest Expense" and adds ActionListener to
//     * that button, linked to this ButtonPanel
//     */
//    private void createGreatestTransactionButton() {
//        greatestTransactionBtn = new JButton("Greatest Expense");
//        greatestTransactionBtn.setActionCommand("findGreatestTransaction");
//        greatestTransactionBtn.addActionListener(this);
//        greatestTransactionBtn.setFocusable(false);
//    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addTransaction")) {
            new AddTransactionPane(this.summary, this.summaryPanel, this.frame);
            updateDisplay();
            System.out.println(summary.getTransactionSummary());
        }
        if (e.getActionCommand().equals("removeTransaction")) {
            removeFromTransactionSummary();
        }
        if (e.getActionCommand().equals("saveTransactions")) {
            saveTransactionSummary(this.summary);
        }
        if (e.getActionCommand().equals("loadTransactions")) {
            loadTransactionSummary();
        }
//        if (e.getActionCommand().equals("findGreatestTransaction")){
//            findGreatestTransaction();
//        }
    }

    /**
     * @MODIFIES: summaryPanel
     * @EFFECTS: clears then displays the current state of summary
     */
    private void updateDisplay() {
        summaryPanel.removeAll();
        summaryPanel.displayTransactions(summary);
        summaryPanel.revalidate();
        summaryPanel.repaint();
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: removes
     */
    private void removeFromTransactionSummary() {

        new RemoveTransactionPane(this.summary, this.summaryPanel);
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: saves transactionSummary to json file.
     */
    private void saveTransactionSummary(TransactionSummary ts) {
        try {
            jsonWriter.open();
            jsonWriter.write(ts);
            jsonWriter.close();
            System.out.println("Saved to " + JSON_STORE);
            ImageIcon saveIcon = new ImageIcon("./data/images/saved.png");
            JOptionPane.showMessageDialog(null, "Transaction summary has been saved!",
                    "Saved Transaction", JOptionPane.QUESTION_MESSAGE, saveIcon);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: loads transactionSummary from file when OK button is pressed.
     */
    private void loadTransactionSummary() {
        try {
            ImageIcon icon = new ImageIcon("./data/images/overwrite.png");
            int option = JOptionPane.showConfirmDialog(null, "Current contents will be overwritten",
                    "Load Transaction", JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
            if (option == JOptionPane.OK_OPTION) {
                summary = jsonReader.read();
                updateDisplay();
                System.out.println("Loaded transaction summary" + " from " + JSON_STORE);
            }
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

//
//    /**
//     * @MODIFIES: this
//     * @EFFECTS: finds the greatest transaction amount for the month in transactionSummary and displays it on a
//     * separate window.
//     */
//    private void findGreatestTransaction() {
//        Transaction transaction = summary.findGreatestTransactionForMonth(LocalDate.now());
//
//        TransactionSummary ts = new TransactionSummary();
//        ts.addTransaction(transaction);
//
//        TransactionSummaryPanel tempPanel = new TransactionSummaryPanel(this.frame, ts);
//        Object[][] displayTransaction = {
//                {"The greatest Transaction for the month was: "},
//                {transaction}
//        };
//        ImageIcon largestExpenseIcon = new ImageIcon("./data/images/expensive.png");
//    }

}
