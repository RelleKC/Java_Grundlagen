package Aufgabe3.constructors;

public class Dog {

    Integer age;
    String name;
    boolean isPuppy;

    public Dog() {
    }

    public Dog(Integer age, String name, boolean isPuppy) {
        this.age = age;
        this.name = name;
        this.isPuppy = isPuppy;
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog(3, "Barney", true);

        dog1.characteristics();
        dog2.characteristics();
    }

    public void characteristics() {
        System.out.println("Name: " + this.name);
        System.out.println("Alter: " + this.age);
        System.out.println("Ist Welpe: " + this.isPuppy + "\n");
    }
}
