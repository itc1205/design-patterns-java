package org.patterns.generative;

import org.junit.jupiter.api.Test;

import java.util.Objects;

class FoodFactoryTest {
    @Test
    void testFoodFactory() {
        Dish dish = new FoodFactory().cookDish("Roasted Brussels Sprouts With Pomegranate Seeds");
        assert (dish.bitterness == 5);
        assert (Objects.equals(dish.name, "Roasted Brussels Sprouts With Pomegranate Seeds"));
        assert (Objects.equals(dish.cook, "Dish food very careful cooker"));
    }
}