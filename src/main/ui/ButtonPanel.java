package ui;

import model.TransactionSummary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener {
    private JButton addTransactionBtn;
    private JButton removeTransactionBtn;
    private JButton saveButton;
    private JButton loadButton;
    private JFrame frame;
    private AddTransactionPane addTransactionPane;


    public ButtonPanel(JFrame frame) {

        super();
        this.frame = frame;

        createAddButton();
        createRemoveButton();
        createSaveButton();
        createLoadButton();

        this.setBackground(Color.green);
        this.setPreferredSize(new Dimension(100, 60));
        this.add(addTransactionBtn);
        this.add(removeTransactionBtn);
        this.add(saveButton);
        this.add(loadButton);
    }

    private void createAddButton() {
        addTransactionBtn = new JButton("Add");
        addTransactionBtn.setActionCommand("addTransaction");
        addTransactionBtn.addActionListener(this);
    }

    private void createRemoveButton() {
        removeTransactionBtn = new JButton("Remove");
        removeTransactionBtn.setActionCommand("removeTransaction");
        removeTransactionBtn.addActionListener(this);
        removeTransactionBtn.setSize(50, 25);
    }

    private void createLoadButton() {
        loadButton = new JButton("Load");
        loadButton.setActionCommand("loadTransactions");
        loadButton.addActionListener(this);
        loadButton.setSize(50, 25);
    }

    private void createSaveButton() {
        saveButton = new JButton("Save");
        saveButton.setActionCommand("saveTransactions");
        saveButton.addActionListener(this);
        saveButton.setSize(50, 25);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addTransaction")) {
            addTransactionPane = new AddTransactionPane(new TransactionSummary());
        }
        if (e.getActionCommand().equals("removeTransaction")) {
            frame.setTitle("Remove Transaction");
        }
        if (e.getActionCommand().equals("saveTransactions")) {
            frame.setTitle("Saved Transactions");
        }
        if (e.getActionCommand().equals("loadTransactions")) {
            frame.setTitle("Loaded Transactions");
        }
    }

}
