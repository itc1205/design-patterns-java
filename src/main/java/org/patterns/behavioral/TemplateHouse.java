package org.patterns.behavioral;

public abstract class TemplateHouse {
    public final void build() {
        pourFoundation();
        putTheDoor();
        buildRoof();
    }
    private void pourFoundation() { System.out.println("Заливка фундамента"); }

    abstract void putTheDoor();
    abstract void buildRoof();
}


class ConcreteHouse extends TemplateHouse {
    @Override
    void putTheDoor() {
        System.out.println("Вставка деревянной двери");
    }

    @Override
    void buildRoof() {
        System.out.println("Постройка крыши с окном");
    }
}