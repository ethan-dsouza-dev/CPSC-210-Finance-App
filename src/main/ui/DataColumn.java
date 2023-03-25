package ui;

import javax.swing.*;
import java.awt.*;

public class DataColumn extends JPanel {
    private JList<String> dateColumn;

    public DataColumn() {

        DefaultListModel<String> dates = new DefaultListModel<>();
        dates.addElement("2023-05-27");
        dates.addElement("2023-05-26");
        dates.addElement("2023-05-25");
        dates.addElement("2023-05-24");

        dateColumn = new JList<>(dates);
        dateColumn.setBounds(100, 100, 75, 75);
        setBackground(Color.ORANGE);
        add(dateColumn);
    }
}
