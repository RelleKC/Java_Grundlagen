package Aufgabe4.inheritance;

public class TestInheritance {

    public static void main(String[] args) {
        Shepherd shepherd = new Shepherd(4, "Barney", true);
        Chihuahua chihuahua = new Chihuahua(5, "Tinkerbell");

        shepherd.characteristics();
        chihuahua.characteristics();
    }

}
