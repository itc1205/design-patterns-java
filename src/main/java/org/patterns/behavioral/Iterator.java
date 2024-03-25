package org.patterns.behavioral;

public interface Iterator<T> {
    T next();
    void first();
    void last();
    boolean hasNext();
}

