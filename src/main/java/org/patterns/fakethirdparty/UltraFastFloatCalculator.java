package org.patterns.fakethirdparty;

/**
 * UltraFastFloatCalculator - Калькулятор, который работает очень и очень быстро, но делает это только с float-числами,
 * но он не умеет работать с делением.
 * <p>
 * И также калькулятор является частью библиотеки, которая является неизменяемой
 * </p>
 */
public class UltraFastFloatCalculator {
    private void accelerate() {
        // Some mega-genius acceleration logic
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }

    public float multiply(float a, float b) {
        accelerate();
        return a * b;
    }

    public float add(float a, float b) {
        accelerate();
        return a + b;
    }

    public float subtract(float a, float b) {
        accelerate();
        return a - b;
    }
}
