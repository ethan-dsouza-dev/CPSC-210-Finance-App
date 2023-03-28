package ui;

import javax.swing.*;
import java.awt.*;

public class DateLabelField extends JPanel {
    private JFormattedTextField dataField;

    public DateLabelField(String label, String pattern) {
        setLayout(new GridLayout(0, 2));

        JLabel dataLabel = new JLabel(label);
        dataField = new JFormattedTextField(pattern);
        dataField.setSize(new Dimension(50, 50));

        add(dataLabel);
        add(dataField);
    }

    public String getDateString() {
        return dataField.getText();
    }

}
