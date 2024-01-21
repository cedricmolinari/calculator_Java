package org.example.operation;

import org.example.Utilities.CalculatorException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ScientificOperation implements IScientificOperation {
    MathContext mc = new MathContext(4, RoundingMode.HALF_EVEN);
    @Override
    public BigDecimal squareRoot(BigDecimal a) {
        return a.sqrt(mc);
    }

    @Override
    public BigDecimal square(BigDecimal a) {
        return a.multiply(a);
    }

    @Override
    public BigDecimal exponentiation(BigDecimal a, Integer b) {
        try {
            return a.pow(b);
        } catch (ArithmeticException e) {
            throw new CalculatorException("Erreur : " + e.getMessage());
        }
    }
}
