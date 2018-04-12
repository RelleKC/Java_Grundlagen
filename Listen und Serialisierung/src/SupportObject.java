import java.util.Arrays;
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
        SupportObject object = new SupportObject();
        System.out.println(object.toString());
        System.out.println("Determinante: " + object.berechneDeterminante());
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
