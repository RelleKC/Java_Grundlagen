package Aufgabe4.inheritance;

public class Dog {
    Integer age;
    String name;

    public Dog(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public boolean isPuppy() {
        return this.age <= 1;
    }

    public void characteristics() {
        System.out.println("Name: " + this.name);
        System.out.println("Alter: " + this.age);
        System.out.println("Ist Welpe: " + this.isPuppy() + "\n");
    }
}
