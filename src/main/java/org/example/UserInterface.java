package org.example;

import org.example.graphical_interface.ButtonHandle;

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

        displayField.setText("0");
        displayField.setSize(200, 50);

        buttonList = new ArrayList<>();
        
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // layout creating and setting
        setLayout(new GridLayout(5, 4, 5, 5));

        // add new components
            //number
        createButton(button1, 0);
        createButton(button2, 1);
        createButton(button3, 2);
        createButton(button4, 3);
        createButton(button5, 4);
        createButton(button6, 5);
        createButton(button7, 6);
        createButton(button8, 7);
        createButton(button9, 8);
        createButton(button0, 9);

            //simple operators
        createButton(buttonAdd, 10);
        createButton(buttonSubtract, 11);
        createButton(buttonMultiply, 12);
        createButton(buttonDivide, 13);
        createButton(buttonEqual, 14);

            //scientific operators

            //special buttons
        createButton(buttonPercent, 15);
        createButton(buttonClearAll, 16);
        createButton(buttonClearEntry, 17);
        createButton(buttonMinus, 18);



        // add the display field to the window
        add(displayField);

        // set the window visible
        setVisible(true);
    }

    private void createButton(String label, int index) {
        JButton button = new JButton(label);
        button.addActionListener(e -> buttonHandle.handleButtonPress(e.getActionCommand()));
        add(button);
        buttonList.add(index, button);
    }





}
