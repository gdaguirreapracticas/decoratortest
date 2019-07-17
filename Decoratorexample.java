package decoratorexample;

interface Intermediate {

    void doIt();
}

class Car implements Intermediate {

    public void doIt() {
        System.out.print("its a car ");
    }
}

abstract class Decorator implements Intermediate {

    private Intermediate core;

    public Decorator(Intermediate inner) {
        core = inner;
    }

    public void doIt() {
        core.doIt();
    }
}

class Window extends Decorator {

    public Window(Intermediate inner) {
        super(inner);
    }

    public void doIt() {
        super.doIt();
        doWindow();
    }

    private void doWindow() {
        System.out.print("also it has windows ");
    }
}

class Mirror extends Decorator {

    public Mirror(Intermediate inner) {
        super(inner);
    }

    public void doIt() {
        super.doIt();
        doMirror();
    }

    private void doMirror() {
        System.out.print("also it has mirrors ");
    }
}

class Door extends Decorator {

    public Door(Intermediate inner) {
        super(inner);
    }

    public void doIt() {
        super.doIt();
        doDoor();
    }

    private void doDoor() {
        System.out.print("also it has doors ");
    }
}

public class Decoratorexample {

    public static void main(String[] args) {
        Intermediate newcar = new Door(new Mirror(new Door(new Window(new Car()))));
        newcar.doIt();
        System.out.println();
    }
}
