package ui;

import model.TransactionSummary;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// Represents a panel that holds the add, remove, save and load button.
public class ButtonPanel extends JPanel implements ActionListener {
    private JButton addTransactionBtn;
    private JButton removeTransactionBtn;
    private JButton saveButton;
    private JButton loadButton;
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

    private void createAddButton() {
        addTransactionBtn = new JButton("Add");
        addTransactionBtn.setActionCommand("addTransaction");
        addTransactionBtn.addActionListener(this);
        addTransactionBtn.setFocusable(false);
    }

    private void createRemoveButton() {
        removeTransactionBtn = new JButton("Remove");
        removeTransactionBtn.setActionCommand("removeTransaction");
        removeTransactionBtn.addActionListener(this);
        removeTransactionBtn.setFocusable(false);
    }

    private void createLoadButton() {
        loadButton = new JButton("Load");
        loadButton.setActionCommand("loadTransactions");
        loadButton.addActionListener(this);
        loadButton.setFocusable(false);
    }

    private void createSaveButton() {
        saveButton = new JButton("Save");
        saveButton.setActionCommand("saveTransactions");
        saveButton.addActionListener(this);
        saveButton.setFocusable(false);
    }

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
            ImageIcon icon = new ImageIcon("./data/images/saved.png");
            JOptionPane.showMessageDialog(null, "Transaction summary has been saved!",
                    "Saved Transaction", JOptionPane.QUESTION_MESSAGE, icon);
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

}
