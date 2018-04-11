package Aufgabe2.returns;

public class TestReturns {

    Integer solution;

    public static void main(String[] args) {
        TestReturns tr = new TestReturns();

        System.out.println("TestReturn after initialisation");
        System.out.println(tr.toString() + "\n");

        System.out.println("returnSolution(2,4)");
        System.out.println(tr.returnSolution(2, 4));
        System.out.println(tr.toString() + "\n");

        System.out.println("setSolution(2,4)");
        tr.setSolution(2, 4);
        System.out.println(tr.toString());
    }

    public Integer returnSolution(int a, int b) {
        return a + b;
    }

    public void setSolution(int a, int b) {
        this.solution = returnSolution(a, b);
    }

    public String toString() {
        return "TestReturns{" +
                "solution=" + solution +
                '}';
    }
}
