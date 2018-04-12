import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class SupportObject {
    String name;
    Integer[][] matrix = new Integer[2][2];

    public SupportObject(String name, Integer[][] matrix) {
        this.name = name;
        this.matrix = matrix;
    }

    public SupportObject() {

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix.length; j++) {
                this.matrix[i][j] = ThreadLocalRandom.current().nextInt(0, 9 + 1);
            }
        }
    }


    public static void main(String[] args) {
        //Aufgabe 1
        SupportObject object = new SupportObject();
        System.out.println(object.toString());
        System.out.println("Determinante: " + object.berechneDeterminante() + '\n');

        //Aufgabe 2
        long start, end;

        System.out.println("Zeit für das einfügen von 1000000 neu Instanziierten SupportObjects:");

        ArrayList<SupportObject> objectArrayList = new ArrayList<SupportObject>();
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            objectArrayList.add(new SupportObject());
        }
        end = System.currentTimeMillis();
        printTimeDiff("ArrayList ", start, end);

        LinkedList<SupportObject> objectLinkedList = new LinkedList<SupportObject>();
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            objectLinkedList.add(new SupportObject());
        }
        end = System.currentTimeMillis();
        printTimeDiff("LinkedList ", start, end);


        System.out.println('\n' + "Zeit für die Determinantenberechnung aller Einträge:" + '\n');

        start = System.currentTimeMillis();
        for (int i = 0; i < objectArrayList.size(); i++) {
            objectArrayList.get(i).berechneDeterminante();
        }
        end = System.currentTimeMillis();
        printTimeDiff("ArrayList (for-Schleife)", start, end);


        //LinkedList for-Schleife zu Zeitaufwändig
        /*
        start = System.currentTimeMillis();
        for (int i = 0; i < objectLinkedList.size() ; i++) {
            System.out.println(i);
            objectLinkedList.get(i).berechneDeterminante();
        }
        end = System.currentTimeMillis();
        printTimeDiff("LinkedList (for-Schleife)",start, end);
        */


        start = System.currentTimeMillis();
        for (SupportObject tmp : objectArrayList) {
            tmp.berechneDeterminante();
        }
        end = System.currentTimeMillis();
        printTimeDiff("ArrayList (foreach-Schleife)", start, end);

        start = System.currentTimeMillis();
        for (SupportObject tmp : objectLinkedList) {
            tmp.berechneDeterminante();
        }
        end = System.currentTimeMillis();
        printTimeDiff("LinkedList (foreach-Schleife)", start, end);
    }

    public static void printTimeDiff(String name, long start, long end) {
        System.out.println(name + (end - start) + "ms");
    }

    public int berechneDeterminante() {
        return this.matrix[0][0] * this.matrix[1][1] - this.matrix[0][1] * this.matrix[1][0];
    }

    public String toString(Integer[][] array) {
        String s = "";

        for (int i = 0; i < array.length; i++) {
            s += Arrays.toString(array[i]) + '\n';
        }

        return s;
    }

    public String toString() {
        return "Name: " + name + '\n' + '\n' + "Matrix: " + '\n' + '\n' + toString(matrix) + '\n';
    }
}
