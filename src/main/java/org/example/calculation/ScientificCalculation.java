package org.example.calculation;

import java.math.BigDecimal;

public interface ScientificCalculation {
    BigDecimal squareRoot(BigDecimal a);

    BigDecimal square(BigDecimal a);

    BigDecimal exponentiation(BigDecimal a, Integer b);
}
