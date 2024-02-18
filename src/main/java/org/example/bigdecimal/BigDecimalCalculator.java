package org.example.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalCalculator {
    private BigDecimal result;

    public BigDecimalCalculator(BigDecimal initialValue) {
        this.result = initialValue;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void add(BigDecimal number) {
        result = result.add(number);
    }

    public void subtract(BigDecimal number) {
        result = result.subtract(number);
    }

    public void multiply(BigDecimal number) {
        result = result.multiply(number);
    }

    public void divide(BigDecimal number) {
        if (number.compareTo(BigDecimal.ZERO) == 0) {
            throw new ArithmeticException("Division by zero");
        }
        result = result.divide(number, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        // 使用 BigDecimalCalculator 进行计算示例
        BigDecimalCalculator calculator = new BigDecimalCalculator(BigDecimal.ZERO);

        calculator.add(new BigDecimal("10.5"));
        calculator.subtract(new BigDecimal("2.3"));
        calculator.multiply(new BigDecimal("3.5"));
        calculator.divide(new BigDecimal("2"));

        System.out.println("Result: " + calculator.getResult());
    }
}
