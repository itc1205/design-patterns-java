package org.patterns.structuring;

import org.patterns.fakethirdparty.UltraFastFloatCalculator;

/**
 * DecimalCalculatorAdapter - класс калькулятора который работает на основе UltraFastFloatCalculator, делает это в целых
 * числах, а также, что самое главное, умеет делить (возможно даже на ноль).
 */
public class DecimalCalculatorAdapter {
    private final UltraFastFloatCalculator fastFloatCalculator = new UltraFastFloatCalculator();

    int multiply(int a, int b) {
        return (int) fastFloatCalculator.multiply((float) a, (float) b);
    }

    int add(int a, int b) {
        return (int) fastFloatCalculator.add((float) a, (float) b);
    }

    int subtract(int a, int b) {
        return (int) fastFloatCalculator.subtract((float) a, (float) b);
    }

    int divide(int a, int b) {
        return a / b;
    }
}


