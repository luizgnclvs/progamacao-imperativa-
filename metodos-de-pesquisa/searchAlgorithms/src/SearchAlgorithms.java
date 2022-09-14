import java.util.Random;
import java.util.Scanner;

public class SearchAlgorithms {

    public static int [] buildVector (int length) {

        Random r = new Random();

        int [] vector = new int [length];

        for (int i = 0; i < length; i++) {
            vector[i] = r.nextInt(31);
        }

        return vector;
    }

    public static void showVector (int [] vector) {

        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + "\t");
        }

        System.out.println("\n");
    }

    public static int [] orderingVector (int [] vector) {

        int [] orderedVector = new int [vector.length];

        int index = 0;

        do {
            int smallest = Integer.MAX_VALUE;

            for (int i = 0; i < vector.length; i++) {
                if (vector[i] < smallest) {
                    smallest = vector[i];
                }
            }

            vector[linearSearch(vector, smallest)] = Integer.MAX_VALUE;

            orderedVector[index] = smallest;

            index++;
        } while (index < vector.length);

        return orderedVector;
    }

    public static int linearSearch (int [] vector, int key) {

        int i;

        boolean found = false;

        for (i = 0; i < vector.length; i++) {
            if (key == vector[i]) {
                found = true;

                break;
            }
        }

        if (found) {
            return i;
        } else {
            return -1;
        }
    }

    public static int improvedLinearSearch (int [] vector, int key) {

        // vector = orderingVector(vector);

        int i;

        boolean found = false;

        for (i = 0; i < vector.length; i++) {
            if (vector[i] >= key) {
                if (vector[i] == key) {
                    found = true;
                }

                break;
            }
        }

        if (found) {
            return i;
        } else {
            return -1;
        }
    }

    public static int binarySearch (int [] vector, int key) {

        // vector = orderingVector(vector);

        int beginning = 0, middle = -1, end = vector.length - 1;

        boolean found = false;

        while (beginning <= end) {
            middle = (beginning + end) / 2;

            if (vector[middle] == key) {
                found = true;

                break;
            } else if (vector[middle] > key) {
                end = middle - 1;
            } else {
                beginning = middle + 1;
            }
        }

        if (found) {
            return middle;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        Random r = new Random();

        int [] vector = buildVector(r.nextInt(8) + 8);

        int key;

        System.out.println("\nSeu vetor é:\n");
        showVector(vector);

        System.out.print("O valor a ser pesquisado é: ");
        try (Scanner read = new Scanner (System.in)) {
            key = read.nextInt();
        }

        int [] valueIndex = new int [3];

        long [] startTime = new long [3];
        long [] stopTime = new long [3];

        startTime[0] = System.nanoTime();
        valueIndex[0] = linearSearch(vector, key);
        stopTime[0] = System.nanoTime();

        if (valueIndex[0] == -1) {
            System.out.println("\nO valor pesquisado não está presente no seu vetor.");
        } else {
            System.out.println("\nO valor pesquisado está localizado na posição: " + (valueIndex[0] + 1));
        }

        System.out.println("O tempo de execução da busca sequencial simples foi de: " + (stopTime[0] - startTime[0]) + "ns.");

        vector = orderingVector(vector);

        System.out.println("\nSeu vetor ordenado é:\n");
        showVector(vector);

        startTime[1] = System.nanoTime();
        valueIndex[1] = improvedLinearSearch(vector, key);
        stopTime[1] = System.nanoTime();

        if (valueIndex[1] == -1) {
            System.out.println("O valor pesquisado não está presente no seu vetor.");
        } else {
            System.out.println("O valor pesquisado está localizado na posição: " + (valueIndex[1] + 1));
        }

        System.out.println("O tempo de execução da busca sequencial melhorada foi de: " + (stopTime[1] - startTime[1]) + "ns.\n");

        startTime[2] = System.nanoTime();
        valueIndex[2] = binarySearch(vector, key);
        stopTime[2] = System.nanoTime();

        if (valueIndex[2] == -1) {
            System.out.println("O valor pesquisado não está presente no seu vetor.");
        } else {
            System.out.println("O valor pesquisado está localizado na posição: " + (valueIndex[2] + 1));
        }

        System.out.println("O tempo de execução da busca binária foi de: " + (stopTime[2] - startTime[2]) + "ns.");
    }
}