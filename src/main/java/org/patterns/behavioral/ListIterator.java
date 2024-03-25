package org.patterns.behavioral;

import java.util.List;

public class ListIterator<T> implements Iterator<T> {
    private final List<T> list;
    private int index = 0;

    public ListIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void last() {
        index = list.size();
    }

    @Override
    public T next() {
        T obj = list.get(index);
        index++;
        return obj;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}
