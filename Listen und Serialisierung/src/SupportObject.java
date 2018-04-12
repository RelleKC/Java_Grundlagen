import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class SupportObject implements Comparable<SupportObject> {
    String name;
    Integer[][] matrix = new Integer[2][2];

    public SupportObject(String name, Integer[][] matrix) {
        this.name = name;
        this.matrix = matrix;
    }

    public SupportObject(Integer[][] matrix) {
        this.matrix = matrix;
    }

    public SupportObject() {

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix.length; j++) {
                this.matrix[i][j] = ThreadLocalRandom.current().nextInt(0, 9 + 1);
            }
        }
    }

    public static void aufgabe1() {
        SupportObject object = new SupportObject();
        System.out.println(object.toString());
        System.out.println("Determinante: " + object.berechneDeterminante() + '\n');
    }

    public static void aufgabe2() {
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

    public static void aufgabe3() {
        ArrayList<SupportObject> objectArrayList = new ArrayList<SupportObject>();

        Integer[][] matrix1 = {{3, 0}, {0, 3}};
        Integer[][] matrix2 = {{2, 0}, {0, 2}};
        Integer[][] matrix3 = {{1, 0}, {0, 1}};
        objectArrayList.add(new SupportObject(matrix1));
        objectArrayList.add(new SupportObject(matrix2));
        objectArrayList.add(new SupportObject(matrix3));

        for (SupportObject object : objectArrayList) {
            System.out.println('\n' + object.toString());
            System.out.println("Determinante: " + object.berechneDeterminante());
        }

        sort(objectArrayList);

        System.out.println('\n' + "sortiert:" + '\n');
        for (SupportObject object : objectArrayList) {
            System.out.println(object.toString());
            System.out.println("Determinante: " + object.berechneDeterminante() + '\n');
        }
    }

    public static void main(String[] args) {

        aufgabe1(); //Implementiere die Klasse SupportObject, welche als Grundlage für alle weiteren Aufgaben dieses Blocks dient.
        aufgabe2(); //Lege eine LinkedList und eine ArrayList mit je 1000000 Einträgen an und miss die Durchlaufzeit unter Verwendung verschiedener Methoden.
        aufgabe3(); //Implementiere eine Sortierfunktion.

    }

    public static void printTimeDiff(String name, long start, long end) {
        System.out.println(name + (end - start) + "ms");
    }

    public static void sort(ArrayList<SupportObject> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if ((list.get(i).compareTo(list.get(i + 1))) == 1) {
                list.add(list.get(i));
                list.remove(i);
                i -= 1;
            }
        }
    }

    public int berechneDeterminante() {
        int tmp = this.matrix[0][0] * this.matrix[1][1] - this.matrix[0][1] * this.matrix[1][0];
        return tmp;
    }

    public String toString(Integer[][] array) {
        String s = "";

        for (int i = 0; i < array.length; i++) {
            s += '\n' + Arrays.toString(array[i]);
        }

        return s;
    }

    public String toString() {
        return "Name: " + name + '\n' + "Matrix: " + toString(matrix);
    }

    public int compareTo(SupportObject b) {
        if (this.berechneDeterminante() < b.berechneDeterminante()) return -1; //kleiner als determinante von b
        else if (this.berechneDeterminante() == b.berechneDeterminante()) return 0; //gleich determinante von b
        return 1; //größer als determinante von b
    }
}
