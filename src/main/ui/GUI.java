package ui;

import model.TransactionSummary;
import ui.panels.ButtonPanel;
import ui.panels.ColumnTitlesPanel;
import ui.panels.TransactionSummaryPanel;

import javax.swing.*;
import java.awt.*;

// Represents the main JFrame of our application
public class GUI extends JFrame {

    private JPanel buttonPanel;
    private TransactionSummaryPanel summaryPanel;
    private TransactionSummary transactionSummary;

    /**
     * @EFFECTS: constructs new GUI object with an empty transactionSummary
     */
    public GUI() {

        super("The Personal Finance Tracker");
        transactionSummary = new TransactionSummary();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(750, 750));

        setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("./data/images/wealth.png");
        setIconImage(icon.getImage());

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
