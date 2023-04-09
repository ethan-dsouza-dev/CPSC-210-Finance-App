package ui;

import model.Event;
import model.EventLog;
import model.TransactionSummary;
import ui.panels.ButtonPanel;
import ui.panels.ColumnTitlesPanel;
import ui.panels.TransactionSummaryPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Represents the main JFrame of our application
public class FinanceAppGUI extends JFrame {

    private JPanel buttonPanel;
    private TransactionSummaryPanel summaryPanel;
    private TransactionSummary transactionSummary;

    /**
     * @EFFECTS: constructs new GUI object with an empty transactionSummary
     */
    public FinanceAppGUI() {

        super("The Personal Finance Tracker");
        transactionSummary = new TransactionSummary();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Event Log:");
                for (Event event : EventLog.getInstance()) {
                    System.out.println(event.getDescription());
                }
                System.exit(0);
            }
        });
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
}
