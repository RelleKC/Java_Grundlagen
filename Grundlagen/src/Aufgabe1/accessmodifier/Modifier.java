package Aufgabe1.accessmodifier;

public class Modifier {
    public String a;
    private String b;
    String c;

    public Modifier() {
        this.a = "Dieser String ist öffentlich.";
        this.b = "Dieser String ist private.";
        this.c = "Dieser String besitzt keinen modifier.";
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
