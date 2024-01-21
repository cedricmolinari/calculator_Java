package org.example.Utilities;

import javax.swing.*;
import java.math.BigDecimal;


public class MathUtils {
    JTextField displayField = new JTextField();

    // percentage
    public String convertToPercent(String displayedNumber) {
        BigDecimal number = new BigDecimal(displayedNumber);
        BigDecimal resultToDisplay;

        resultToDisplay = number.divide(BigDecimal.valueOf(100));
        return resultToDisplay.toString();
    }



    // erase a number
}
