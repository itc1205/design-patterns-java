package org.patterns.structuring;

import org.junit.jupiter.api.Test;

class WelcomeDecoratorsTest {
    @Test
    public void testIfPrintsOut() {
        Decorator c = new DecoratorHello(new DecoratorComma(new WelcomeWorld())); // Will output Hello, world!
        c.greet();
    }
}
