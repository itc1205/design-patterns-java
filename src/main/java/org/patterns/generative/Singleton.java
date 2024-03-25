package org.patterns.generative;


/**
 * class Singleton - пример порождающего паттерна "Одиночка".
 * <p>
 * Основная особенность данного паттерна заключается в том, что в программе может существовать только один экземпляр
 * одиночка, что упрощает взаимодействие с данными, передающимися в вашем приложении.
 * </p>
 * <p>
 * Зачастую одиночка считаются антипаттерном, так как глобальные переменные - зло.
 * Также из особенностей стоит выделить то, что паттерн является легким способом передачи данных между процессами,
 * (накинули synchronized на все методы, Profit!), что может превратить данный класс в хот-спот в вашем приложении.
 * </p>
 * <p>
 *     TODO: Подправить доки, добавить нормальный пример.
 * </p>
 */
public class Singleton {
    private final static Singleton instance = new Singleton();

    private Singleton() {
        // Этот метод запустится лишь единожды, при запуске программы
        System.out.println("Instance had been created");
    }

    public static synchronized Singleton getInstance() {
        return instance;
    }

    public synchronized void greetOurselves(int threadNumber) {
        System.out.printf("Hello, world from thread %1$s!!%n\n", threadNumber);
    }
}

