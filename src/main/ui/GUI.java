package ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    private JLabel label;
    private JTextField field;

    private JPanel greenPanel;

    public GUI() {

        super("The Personal Finance Tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(750, 750));
        //((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new BorderLayout());

        JButton addTransactionBtn = new JButton("Add");
        addTransactionBtn.setActionCommand("addTransaction");
        addTransactionBtn.addActionListener(this);
        addTransactionBtn.setBounds(0, 0, 25, 12);

        JButton removeTransactionBtn = new JButton("Remove");
        removeTransactionBtn.setActionCommand("removeTransaction");
        removeTransactionBtn.addActionListener(this);
        removeTransactionBtn.setSize(50, 25);

        JButton saveButton = new JButton("Save");
        saveButton.setActionCommand("saveTransactions");
        saveButton.addActionListener(this);
        saveButton.setSize(50, 25);

        JButton loadButton = new JButton("Load");
        loadButton.setActionCommand("loadTransactions");
        loadButton.addActionListener(this);
        loadButton.setSize(50, 25);


        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0, 0, 250, 250);

        JPanel addPanel = new JPanel();
        addPanel.setBackground(Color.blue);
        addPanel.setLayout(new BorderLayout());
        addPanel.add(addTransactionBtn);

        greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setLayout(new GridLayout(1, 4, 0, 0));
        greenPanel.setPreferredSize(new Dimension(100, 60));
        greenPanel.add(addTransactionBtn);
        greenPanel.add(removeTransactionBtn);
        greenPanel.add(saveButton);
        greenPanel.add(loadButton);


        //add(redPanel);
        //add(bluePanel);
        this.add(greenPanel, BorderLayout.SOUTH);
        //pack();
        setLocationRelativeTo(null);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addTransaction")) {
            setTitle("Added Transaction");
        }
        if (e.getActionCommand().equals("removeTransaction")) {
            setTitle("Remove Transaction");
        }
        if (e.getActionCommand().equals("saveTransactions")) {
            setTitle("Saved Transactions");
        }
        if (e.getActionCommand().equals("loadTransactions")) {
            setTitle("Loaded Transactions");
        }
    }

    public static void main(String[] args) {
        new GUI();
    }
}
