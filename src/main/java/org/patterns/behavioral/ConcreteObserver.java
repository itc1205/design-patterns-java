package org.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

interface Observer {
    void update(String news);
}

class ConcreteObservable implements Observable {
    private final List<Observer> parishioners = new ArrayList<>();
    private String newsChurch;
    public void setNewsChurch(String newsChurch) {
        this.newsChurch = newsChurch;
        notifyObservers();
    }
    public void registerObserver(Observer o) {
        parishioners.add(o);
    }
    public void removeObserver(Observer o) {
        parishioners.remove(o);
    }
    public void notifyObservers() {
        parishioners.forEach(o -> o.update(newsChurch));
    }
}

public class ConcreteObserver implements Observer {
    String name;
    public ConcreteObserver(String name) {
        this.name = name;
    }
    @Override
    public void update(String news) {
        System.out.println(name + " узнал новость " + news);
    }
}