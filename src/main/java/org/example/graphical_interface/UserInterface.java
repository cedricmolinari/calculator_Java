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
            buttonMinus = "+/-";
    List<JButton> buttonList;
    public UserInterface() {
        super("Calculatrice");
        buttonHandle = new ButtonHandle(displayField);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        displayField.setText("0");
        displayField.setSize(200, 50);

        buttonList = new ArrayList<>();
        
        //setSize(300, 200);


        displayField.setHorizontalAlignment(JTextField.RIGHT);
        add(displayField, BorderLayout.NORTH);

        // layout creating and setting
        setLayout(new GridLayout(6, 4, 5, 5));

        // add new components
            //number
        createButton(button1, 0);
        createButton(button2, 1);
        createButton(button3, 2);
        createOperationButton(buttonAdd, 3);
        createButton(button4, 4);
        createButton(button5, 5);
        createButton(button6, 6);
        createOperationButton(buttonSubtract, 7);
        createButton(button7, 8);
        createButton(button8, 9);
        createButton(button9, 10);
        createOperationButton(buttonMultiply, 11);
        createButton(buttonPercent, 12);
        createButton(button0, 13);
        createButton(buttonMinus, 14);
        createOperationButton(buttonDivide, 15);
        createButton(buttonClearAll, 16);
        createButton(buttonClearEntry, 17);
        createButton(buttonEqual, 18);

        //add(buttonPanel, BorderLayout.CENTER);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the window visible
        setVisible(true);
    }

    private void createButton(String label, int index) {
        JButton button = new JButton(label);
        button.addActionListener(e -> buttonHandle.handleButtonPress(e.getActionCommand()));
        add(button);
        buttonList.add(index, button);
    }
    private void createOperationButton(String label, int index) {
        JButton button = new JButton(label);
        button.setBackground(Color.ORANGE);
        button.setForeground(Color.WHITE);

        button.addActionListener(e -> buttonHandle.handleButtonPress(e.getActionCommand()));
        add(button);
        buttonList.add(index, button);
    }
}
