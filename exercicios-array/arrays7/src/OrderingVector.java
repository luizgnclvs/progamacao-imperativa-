import java.util.Arrays;
import java.util.Random;

public class OrderingVector {

    public static int [] buildvector (int length) {
        Random r = new Random();

        int [] vector = new int [length];

        for (int i = 0; i < length; i++) {
            vector[i] = r.nextInt(101);
        }

        return vector;
    }

    public static void printVector (int [] vector) {
        for (int i = 0; i < vector.length; i++) {

        }
    }

    public static int [] descendingOrderVector (int [] vector) {
        int [] orderedVector = new int [vector.length];
        int index = 0;

        int biggestValue;

        do {
            biggestValue = Integer.MIN_VALUE;

            for (int i = 0; i < vector.length; i++) {
                if (vector[i] > biggestValue) {
                    biggestValue = vector[i];
                }
            }

            orderedVector[index] = biggestValue;
            index++;

            for (int i = 0; i < vector.length; i++) {
                if (vector[i] == biggestValue) {
                    vector[i] = Integer.MIN_VALUE;
                    break;
                }
            }
        } while (index < orderedVector.length);

        return orderedVector;
    }

    public static void main(String[] args) {

        int [] vector = buildvector(10);

        System.out.println("\nVetor original:");
        System.out.println(Arrays.toString(vector));

        System.out.println("\nVetor com seus elementos em ordem decrescente:");
        System.out.println(Arrays.toString(descendingOrderVector(vector)));
    }
}
