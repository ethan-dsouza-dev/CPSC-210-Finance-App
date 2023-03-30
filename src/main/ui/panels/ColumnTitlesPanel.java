package ui.panels;

import javax.swing.*;
import java.awt.*;

// represents a Panel that holds the Title names of all the titles
public class ColumnTitlesPanel extends JPanel  {
    private JLabel date;
    private JLabel details;
    private JLabel amount;
    private JLabel category;

    /**
     * @EFFECTS: creates a new instance of a ColumnTitlesPanel with each field initialised to a JLabel and its
     *           corresponding name.
     */
    public ColumnTitlesPanel() {
        date = new JLabel("Date");
        details = new JLabel("Details");
        amount = new JLabel("Amount");
        category = new JLabel("Category");


        this.setLayout(new GridLayout(1,1, 2, 0));
        this.setBackground(Color.decode("#bababa"));
        add(date);
        add(details);
        add(amount);
        add(category);

        centerTitlesChangeFont();
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: centers all labels in this Panel and changes font settings
     */
    private void centerTitlesChangeFont() {
        Component[] labels = this.getComponents();
        for (Component c : labels) {
            if (c instanceof JLabel) {
                ((JLabel) c).setHorizontalAlignment(JLabel.CENTER);
                c.setFont(new Font("Apple Casual", Font.BOLD, 20));
            }
        }
    }
}
