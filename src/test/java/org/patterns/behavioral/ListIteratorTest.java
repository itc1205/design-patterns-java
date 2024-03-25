package org.patterns.behavioral;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ListIteratorTest {
    @Test
    public void testIterator() {
        ArrayList<Integer> array = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
        }};
        Iterator<Integer> iterator = new ListIterator<>(array);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}