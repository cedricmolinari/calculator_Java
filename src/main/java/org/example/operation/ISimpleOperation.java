package org.example.operation;

import java.math.BigDecimal;

public interface ISimpleOperation {
    BigDecimal add(BigDecimal a, BigDecimal b);

    BigDecimal substract(BigDecimal a, BigDecimal b);

    BigDecimal multiply(BigDecimal a, BigDecimal b);

    BigDecimal divide(BigDecimal a, BigDecimal b);


}
