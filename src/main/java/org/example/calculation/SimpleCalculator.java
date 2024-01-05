package org.example.calculation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SimpleCalculator implements SimpleCalculation {


    @Override
    public BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    @Override
    public BigDecimal substract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    @Override
    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    @Override
    public BigDecimal divide(BigDecimal a, BigDecimal b) {
        try {
            return a.divide(b, RoundingMode.HALF_EVEN);
        } catch (ArithmeticException e) {
            throw new CalculatorException("Erreur : " + e.getMessage());
        }

    }


}
