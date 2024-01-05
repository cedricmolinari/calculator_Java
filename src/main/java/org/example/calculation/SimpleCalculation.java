package org.example.calculation;

import java.math.BigDecimal;

public interface SimpleCalculation {
    BigDecimal add(BigDecimal a, BigDecimal b);

    BigDecimal substract(BigDecimal a, BigDecimal b);

    BigDecimal multiply(BigDecimal a, BigDecimal b);

    BigDecimal divide(BigDecimal a, BigDecimal b);


}
