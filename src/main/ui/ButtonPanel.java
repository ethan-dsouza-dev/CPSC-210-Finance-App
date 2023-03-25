package ui;

import model.Transaction;
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


    public ButtonPanel(JFrame frame) {

        super();
        this.frame = frame;

        createAddButton();
        createRemoveButton();
        createSaveButton();
        createLoadButton();

        this.setBackground(Color.green);
        // this.setLayout(new GridLayout(1, 4, 0, 0));
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
        //addTransactionBtn.setBounds(0, 0, 25, 12);
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
        if (e.getSource() == addTransactionBtn) {
            frame.setTitle("Added Transaction");
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
