package ui;

import javax.swing.*;
import java.awt.*;

public class LabelFieldCombo extends JPanel {
    private JFormattedTextField dataField;

    public LabelFieldCombo(String label) {
        setLayout(new GridLayout(0, 2));

        JLabel dataLabel = new JLabel(label);
        dataField = new JFormattedTextField();
        dataField.setSize(new Dimension(50, 50));

        add(dataLabel);
        add(dataField);
    }

    public String getText() {
        return dataField.getText();
    }

}
