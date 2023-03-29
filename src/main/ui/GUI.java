package ui;

import model.Transaction;
import model.TransactionSummary;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private JPanel buttonPanel;
    private TransactionSummaryPanel summaryPanel;

    private TransactionSummary transactionSummary;

    public GUI() {

        super("The Personal Finance Tracker");
        transactionSummary = new TransactionSummary();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(750, 750));

        setLayout(new BorderLayout());

        ImageIcon dog = new ImageIcon("./data/wealth.png");
        setIconImage(dog.getImage());

        summaryPanel = new TransactionSummaryPanel(this, transactionSummary);
        buttonPanel = new ButtonPanel(this, summaryPanel,transactionSummary);

        add(new ColumnTitlesPanel(), BorderLayout.NORTH);
        add(summaryPanel);
        add(buttonPanel, BorderLayout.SOUTH);


        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new GUI();
    }
}
