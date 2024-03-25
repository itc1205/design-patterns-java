package org.patterns.behavioral;

import org.junit.jupiter.api.Test;

class AbstractHouseTest {

    @Test
    void build() {
        TemplateHouse house = new ConcreteHouse();
        house.build();
    }
}