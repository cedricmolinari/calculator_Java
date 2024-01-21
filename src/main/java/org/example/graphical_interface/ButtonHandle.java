package org.example.graphical_interface;

import org.example.Utilities.MathUtils;
import org.example.operation.SimpleOperation;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ButtonHandle {
    //JTextField displayField = new JTextField();
    private JTextField displayField;
    public ButtonHandle(JTextField displayField) {
        this.displayField = displayField;
    }

    List<String> specialButton = Arrays.asList("%", "C", "CE", "+/-");
    private BigDecimal previousNumber = BigDecimal.ZERO;
    BigDecimal result;
    SimpleOperation simpleCalculator = new SimpleOperation();
    boolean isFirstNumberOfNumber = true;
    private BigDecimal currentNumber = BigDecimal.ZERO;
    String currentOperator;
    String previousOperator;
    String currentText;
    private static final int MAX_DIGITS = 4; // define the maximum of numbers you can enter for a number
    MathUtils mathUtils = new MathUtils();
    boolean isSpecialButton = false;
    public void handleButtonPress(String buttonValue) {
        for (int i = 0; i < specialButton.toArray().length; i++) {
            if (Objects.equals(specialButton.get(i), buttonValue)) {
                isSpecialButton = true;
                break;
            }
        }
        if (Character.isDigit(buttonValue.charAt(0))) {
            // it's a number
            appendToDisplay(buttonValue);
        } else if (isSpecialButton) {
            // it's a special button
            doSpecialAction(buttonValue);
        } else {
            // it's an operator
            performOperation(buttonValue);
        }
    }
    private void performOperation(String buttonValue) {
        // we save the first operator of the operation in previousOperator
        // because we need the previous to select the operation to do
        previousOperator = currentOperator;

        // then we get the new operator entered
        currentOperator = buttonValue;
        isFirstNumberOfNumber = true;

        // here, we decide if we had to do an operation now or not
        // we can do operation if we have at least 2 numbers (and the second operator is entered), else not
        if (previousOperator != null && !previousOperator.equals("=")) {
            doOperation(simpleCalculator, previousOperator);
            currentNumber = result; // when operation is done, the result is like the first argument of the next operation
        } else {
            currentOperator = buttonValue; // this case only if we have entered one number, and we are typing the first operator
        }
    }
    private void doOperation(SimpleOperation simpleOperation, String previousOperator) {
        switch (previousOperator) {
            case "+" -> result = simpleOperation.add(previousNumber, currentNumber);
            case "-" -> result = simpleOperation.substract(previousNumber, currentNumber);
            case "*" -> result = simpleOperation.multiply(previousNumber, currentNumber);
            case "/" -> result = simpleOperation.divide(previousNumber, currentNumber);
        }
        displayField.setText(result.toString());
    }
    private void doSpecialAction(String specialButton) {
        switch (specialButton) {
            case "%":
                displayField.setText(mathUtils.convertToPercent(String.valueOf(currentNumber)));
                currentNumber = new BigDecimal(displayField.getText());
                break;
            case "C":
                clearOperation();
                break;
            case "CE":
                if (currentNumber.toString().length() < 2 || currentNumber == null) {
                    currentNumber = null;
                    displayField.setText("0");
                    isFirstNumberOfNumber = true;
                } else {
                    currentText = displayField.getText().substring(0, displayField.getText().length() - 1);
                    displayField.setText(currentText);
                    currentNumber = new BigDecimal(currentText);

                }
                break;
            case "+/-":
                currentNumber = currentNumber.negate();
                displayField.setText(String.valueOf(currentNumber));
        }
        isSpecialButton = false;
    }



    // KEEP THIS FUNCTION HERE
    private void appendToDisplay(String number) {
        currentText = displayField.getText();
        // if it's the first number of a new entered number
        if (isFirstNumberOfNumber) {
            // play condition only if this first number is not a zero
            if (!number.equals("0")) {
                displayField.setText(number);
                previousNumber = currentNumber;
                currentNumber = new BigDecimal(number);
                isFirstNumberOfNumber = false;
                // else, the first number equal 0, it's like you're not entering a first number
            } else {
                displayField.setText("0");
                isFirstNumberOfNumber = true;
            }
            // else we're typing the second (or further) number of a number
        } else {
            if (currentText.length() < MAX_DIGITS) {
                // display
                String newNumber = currentText + number;
                displayField.setText(newNumber);
                currentNumber = new BigDecimal(newNumber);
            }
        }
    }

    // clear operation
    public void clearOperation() {
        displayField.setText("0");
        currentNumber = null;
        previousNumber = null;
        currentOperator = null;
        previousOperator = null;
    }
}
