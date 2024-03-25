package org.patterns.behavioral;

import org.junit.jupiter.api.Test;


class ObserverPatternTest {
    @Test
    public void testObserverPattern() {
        ConcreteObservable church = new ConcreteObservable() {{
            registerObserver(
                    new ConcreteObserver("Daniil")
            );
            registerObserver(
                    new ConcreteObserver("Iem")
            );
            registerObserver(
                    new ConcreteObserver("Alex")
            );
            registerObserver(
                    new ConcreteObserver("Krill")
            );
        }};
        church.setNewsChurch("Hello, world");
    }
}