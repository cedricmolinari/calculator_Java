package org.example.operation;

import java.math.BigDecimal;

public interface IScientificOperation {
    BigDecimal squareRoot(BigDecimal a);

    BigDecimal square(BigDecimal a);

    BigDecimal exponentiation(BigDecimal a, Integer b);
}
