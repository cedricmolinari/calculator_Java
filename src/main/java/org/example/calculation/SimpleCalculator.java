package org.example.calculation;

import java.math.BigDecimal;

public class SimpleCalculator implements SimpleCalculation {


    @Override
    public BigDecimal additionner(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    @Override
    public BigDecimal soustraire(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    @Override
    public BigDecimal multiplier(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    @Override
    public BigDecimal diviser(BigDecimal a, BigDecimal b) {
        try {
            return a.divide(b);
        } catch (ArithmeticException e) {
            throw new CalculatorException("Erreur : " + e.getMessage());
        }

    }


}
