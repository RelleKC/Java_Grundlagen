package Aufgabe4.inheritance;

public class Shepherd extends Dog {
    boolean isPoliceDog;

    public Shepherd(Integer age, String name, boolean isPoliceDog) {
        super(age, name);
        this.isPoliceDog = isPoliceDog;
    }
}
