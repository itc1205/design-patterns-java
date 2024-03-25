package org.patterns.structuring;

interface WelcomeComponent {
    void greet();
}

class WelcomeWorld implements WelcomeComponent {
    @Override
    public void greet() {
        System.out.println("World!");
    }
}

public abstract class Decorator implements WelcomeComponent {
    protected WelcomeComponent component;

    public Decorator(WelcomeComponent c) {
        component = c;
    }

    public void greet() {
        component.greet();
    }

    public void whatDoIDo() {
        System.out.println("I do nothing!");
    }
}

class DecoratorComma extends Decorator {
    public DecoratorComma(WelcomeComponent c) {
        super(c);
    }

    public void greet() {
        System.out.print(",");
        super.greet();
    }

    public void whatDoIDo() {
        System.out.println("New comma operation");
    }
}

class DecoratorHello extends Decorator {
    public DecoratorHello(WelcomeComponent c) {
        super(c);
    }

    public void greet() {
        System.out.print("Hello");
        super.greet();
    }

    public void whatDoIDo() {
        System.out.println("New comma operation");
    }
}