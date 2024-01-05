package org.example.graphical_interface;

import org.example.calculation.ScientificCalculator;
import org.example.calculation.SimpleCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserInterface extends JFrame {
    JTextField displayField = new JTextField();

    SimpleCalculator simpleCalculator = new SimpleCalculator();
    PressedKey pressedKey = new PressedKey();
    JButton button1 = new JButton(String.valueOf(1));
    JButton button2 = new JButton(String.valueOf(2));
    JButton button3 = new JButton(String.valueOf(3));
    JButton button4 = new JButton(String.valueOf(4));
    JButton button5 = new JButton(String.valueOf(5));
    JButton button6 = new JButton(String.valueOf(6));
    JButton button7 = new JButton(String.valueOf(7));
    JButton button8 = new JButton(String.valueOf(8));
    JButton button9 = new JButton(String.valueOf(9));
    JButton button0 = new JButton(String.valueOf(0));
    JButton buttonAdd = new JButton("+");
    JButton buttonSubstract = new JButton("-");
    JButton buttonMultiply = new JButton("*");
    JButton buttonDivide = new JButton("/");
    JButton buttonEqual = new JButton("=");
    List<JButton> buttonList;
    String buttonValue;
    boolean isFirstNumberAfterOperator = true;
    private BigDecimal currentNumber = BigDecimal.ZERO;
    private BigDecimal lastNumber = BigDecimal.ZERO;
    String currentOperator;
    String lastOperator;
    BigDecimal result;

    public UserInterface() {
        super("Exemple Swing");
        displayField.setText("0");

        buttonList = new ArrayList<>();
        
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // layout creating and setting
        setLayout(new GridLayout(4, 4, 5, 5));

        // add new components
            //chiffres
        add(button1);
        buttonList.add(0, button1);
        add(button2);
        buttonList.add(1, button2);
        add(button3);
        buttonList.add(2, button3);
        add(button4);
        buttonList.add(3, button4);
        add(button5);
        buttonList.add(4, button5);
        add(button6);
        buttonList.add(5, button6);
        add(button7);
        buttonList.add(6, button7);
        add(button8);
        buttonList.add(7, button8);
        add(button9);
        buttonList.add(8, button9);
        add(button0);
        buttonList.add(9, button0);

        add(buttonAdd);
        buttonList.add(10, buttonAdd);
        add(buttonSubstract);
        buttonList.add(11, buttonSubstract);
        add(buttonMultiply);
        buttonList.add(12, buttonMultiply);
        add(buttonDivide);
        buttonList.add(13, buttonDivide);

        add(buttonEqual);
        buttonList.add(14, buttonEqual);
        
        
        for (JButton button : buttonList) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonValue = button.getText();
                    handleButtonPress(buttonValue);
                }
            });
        }

        // add the display field to the window
        add(displayField);

        // set the window visible
        setVisible(true);
    }
    private void handleButtonPress(String buttonValue) {
        if (Character.isDigit(buttonValue.charAt(0))) {
            // it's a number
            appendToDisplay(buttonValue);
        } else {
            // it's an operator
            performOperation(buttonValue);
        }
    }
    private void appendToDisplay(String number) {
        // lastNumber = new BigDecimal(displayField.getText());
        // currentNumber = new BigDecimal(number);
        String newNumber;
        if (isFirstNumberAfterOperator) {
            lastNumber = currentNumber;
            displayField.setText(number);
            currentNumber = new BigDecimal(number);
            isFirstNumberAfterOperator = false;
        } else {
            newNumber = displayField.getText() + number;
            currentNumber = new BigDecimal(newNumber);
            displayField.setText(newNumber);
        }
    }
    private void performOperation(String buttonValue) {
        lastOperator = currentOperator;
        currentOperator = buttonValue;
        isFirstNumberAfterOperator = true;
        if (lastOperator != null && lastOperator!= "=") {
            if (Objects.equals(currentOperator, "=")) {
                finalOperation(simpleCalculator, lastOperator);
                currentNumber = result;
            } else {
                intermediateOperation(simpleCalculator, lastOperator);
            }
        } else {
            currentOperator = buttonValue;
        }
    }
    private void finalOperation(SimpleCalculator simpleCalculator, String lastOperator) {
        //result = null;
        switch (lastOperator) {
            case "+" -> result = simpleCalculator.add(lastNumber, currentNumber);
            case "-" -> result = simpleCalculator.substract(lastNumber, currentNumber);
            case "*" -> result = simpleCalculator.multiply(lastNumber, currentNumber);
            case "/" -> result = simpleCalculator.divide(lastNumber, currentNumber);
        }
        displayField.setText(result.toString());
    }
    private void intermediateOperation(SimpleCalculator simpleCalculator, String lastOperator) {
        //result = null;
        switch (lastOperator) {
            case "+" -> result = simpleCalculator.add(currentNumber, lastNumber);
            case "-" -> result = simpleCalculator.substract(currentNumber, lastNumber);
            case "*" -> result = simpleCalculator.multiply(currentNumber, lastNumber);
            case "/" -> result = simpleCalculator.divide(currentNumber, lastNumber);
        }
        displayField.setText(result.toString());
        currentNumber = lastNumber;
        currentOperator = lastOperator;
    }
}
