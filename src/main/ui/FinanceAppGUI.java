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

    private ButtonPanel buttonPanel;
    private TransactionSummaryPanel summaryPanel;
    private TransactionSummary transactionSummary;
    private ColumnTitlesPanel columnTitlesPanel;

    /**
     * @EFFECTS: constructs new GUI object with an empty transactionSummary
     */
    public FinanceAppGUI() {

        super("The Personal Finance Tracker");
        transactionSummary = new TransactionSummary();
        columnTitlesPanel = new ColumnTitlesPanel();

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListenerToFrame();
        setSize(new Dimension(750, 750));

        setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("./data/images/wealth.png");
        setIconImage(icon.getImage());

        summaryPanel = new TransactionSummaryPanel(this, transactionSummary);
        buttonPanel = new ButtonPanel(this, summaryPanel,transactionSummary);

        add(columnTitlesPanel, BorderLayout.NORTH);
        add(summaryPanel);
        add(buttonPanel, BorderLayout.SOUTH);


        setLocationRelativeTo(null);
        setVisible(true);

    }

    /**
     * @MODIFIES: this
     * @EFFECTS: Adds a window listener to this frame and overrides windowClosing to print the EventLog when
     * the window is closed.
     */
    private void addWindowListenerToFrame() {
        addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
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
    }
}
