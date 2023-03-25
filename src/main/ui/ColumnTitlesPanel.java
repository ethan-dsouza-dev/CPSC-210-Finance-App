package ui;

import javax.swing.*;
import java.awt.*;

public class ColumnTitlesPanel extends JPanel  {
    private JLabel date;
    private JLabel details;
    private JLabel amount;
    private JLabel category;

    public ColumnTitlesPanel() {
        date = new JLabel("Date");
        details = new JLabel("Details");
        amount = new JLabel("Amount");
        category = new JLabel("Category");
        date.setHorizontalAlignment(JLabel.CENTER);
        this.setLayout(new GridLayout(1,1));
        this.setBackground(Color.decode("0xc2c36e"));
        add(date);
        add(details);
        add(amount);
        add(category);

    }
}
