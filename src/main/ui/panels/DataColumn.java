package ui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a Panel containing data of one of the fields of TransactionSummary
public class DataColumn extends JPanel implements ActionListener {
    private JList<String> dataColumn;
    private DefaultListModel<String> data;

    /**
     * @EFFECTS: constructs a new DataColum with an empty DefaultListModel and a JList with that ListModel.
     */
    public DataColumn() {

        this.data = new DefaultListModel<>();

        dataColumn = new JList<>(this.data);
        dataColumn.setBounds(100, 100, 75, 75);
        setBackground(Color.lightGray);
        dataColumn.setBackground(Color.lightGray);
        add(dataColumn);
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: adds data of String type to the DefaultListModel and updates the JList
     */
    public void addData(String text) {
        this.data.addElement(text);
        dataColumn = new JList<>((this.data));
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Check")) {
            int index = dataColumn.getSelectedIndex();
            System.out.println("Index Selected: " + index);
            String s = (String) dataColumn.getSelectedValue();
            System.out.println("Value Selected: " + s);
        }
    }
}
