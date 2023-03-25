package ui;

import javax.swing.*;
import java.awt.*;

public class TransactionSummaryPanel extends JPanel {

    private JList<String> transactions;

    public TransactionSummaryPanel() {
        setBackground(Color.BLACK);
        setLayout(new GridLayout(1, 4, 2, 0));
        add(new DataColumn());
        add(new DataColumn());
        add(new DataColumn());
        add(new DataColumn());
    }
}
