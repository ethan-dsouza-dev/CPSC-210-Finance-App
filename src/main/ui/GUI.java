package ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JLabel label;
    private JTextField field;
    private JButton loadButton;

    private JPanel greenPanel;

    public GUI() {

        super("The Personal Finance Tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(750, 750));

        setLayout(new BorderLayout());

        add(new ColumnTitlesPanel(), BorderLayout.NORTH);
        add(new ButtonPanel(this), BorderLayout.SOUTH);
        add(new TransactionSummaryPanel());


        setLocationRelativeTo(null);
        setVisible(true);

    }



    public static void main(String[] args) {
        new GUI();
    }
}
