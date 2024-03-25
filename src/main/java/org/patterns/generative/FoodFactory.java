package org.patterns.generative;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Dish {
    public String cook;
    public String name;
    /**
     * Bitterness is a criteria of bitterness of dish in scale from 1 to 5
     */
    public int bitterness;
}

/**
 * FoodFactory - Класс порождающего паттерна под названием "фабричный метод"
 * <p>
 * Мы используем данный паттерн когда знаем только часть деталей необходимых для создания какого либо объекта.
 * </p>
 * <p>
 * В данном случае мы не знаем кто будет готовить нашу еду, а также насколько она будет кислой, знаем только
 * ее название. Поэтому мы и возлагаем данную обязанность на наш фабричный класс-метод.
 * </p>
 */
public class FoodFactory {
    public Dish cookDish(String nameOfDish) {
        return switch (nameOfDish) {
            case "Orange Cookies" -> new Dish("Dish food cooker", nameOfDish, 4);
            case "Roasted Brussels Sprouts With Pomegranate Seeds" ->
                    new Dish("Dish food very careful cooker", nameOfDish, 5);
            case "Grilled Sweet Potatoes" -> new Dish("Regular cook", nameOfDish, 1);
            default -> null;
        };
    }
}
