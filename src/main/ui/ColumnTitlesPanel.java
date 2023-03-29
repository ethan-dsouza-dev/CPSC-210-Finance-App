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


        this.setLayout(new GridLayout(1,1, 2, 0));
        this.setBackground(Color.LIGHT_GRAY);
        add(date);
        add(details);
        add(amount);
        add(category);

        centerTitles();
        setLabelBackgrounds();
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: centers all labels in this Panel
     */
    private void centerTitles() {
        Component[] labels = this.getComponents();
        for (Component c : labels) {
            if (c instanceof JLabel) {
                ((JLabel) c).setHorizontalAlignment(JLabel.CENTER);
            }
        }
    }


    private void setLabelBackgrounds() {
        Component[] labels = this.getComponents();
        for (Component c : labels) {
            if (c instanceof JLabel) {
                ((JLabel) c).setBackground(Color.BLUE);
            }
        }
    }
}
