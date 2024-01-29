package org.example.graphical_interface;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UserInterface extends JFrame {
    private JTextField displayField = new JTextField();
    private ButtonHandle buttonHandle;
    String button1 = "1", button2 = "2", button3 = "3", button4 = "4", button5 = "5", button6 = "6", button7 = "7",
            button8 = "8", button9 = "9", button0 = "0", buttonAdd = "+", buttonSubtract = "-", buttonMultiply = "*",
            buttonDivide = "/", buttonEqual = "=", buttonPercent = "%", buttonClearAll = "C", buttonClearEntry = "CE",
            buttonMinus = "+/-", buttonComma = ".";
    // List<JButton> buttonList;
    public UserInterface() {
        super("Calculatrice");
        buttonHandle = new ButtonHandle(displayField);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());

        // Configure display field
        displayField.setText("0");
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        add(displayField, BorderLayout.NORTH);

        // Create panel for buttons and set its layout to GridLayout
        JPanel buttonPanel = new JPanel(new GridLayout(5, 5, 5, 5));

        // Add buttons to buttonPanel
        addButtonsToPanel(buttonPanel);
        add(buttonPanel, BorderLayout.CENTER);

        //add(buttonPanel, BorderLayout.CENTER);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the window visible
        setVisible(true);
    }

    private void addButtonsToPanel(JPanel panel) {
        panel.add(createButton(button1));
        panel.add(createButton(button2));
        panel.add(createButton(button3));
        panel.add(createOperationButton(buttonAdd));
        panel.add(createButton(button4));
        panel.add(createButton(button5));
        panel.add(createButton(button6));
        panel.add(createOperationButton(buttonSubtract));
        panel.add(createButton(button7));
        panel.add(createButton(button8));
        panel.add(createButton(button9));
        panel.add(createOperationButton(buttonMultiply));
        panel.add(createButton(buttonClearEntry));
        panel.add(createButton(button0));
        panel.add(createButton(buttonPercent));
        panel.add(createOperationButton(buttonDivide));
        panel.add(createButton(buttonClearAll));
        panel.add(createButton(buttonComma));
        panel.add(createButton(buttonMinus));
        panel.add(createOperationButton(buttonEqual));
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(e -> buttonHandle.handleButtonPress(e.getActionCommand()));
        return button;
    }
    private JButton createOperationButton(String label) {
        JButton button = new JButton(label);
        button.setBackground(Color.ORANGE);
        button.setForeground(Color.WHITE);
        button.addActionListener(e -> buttonHandle.handleButtonPress(e.getActionCommand()));
        return button;
    }
}
