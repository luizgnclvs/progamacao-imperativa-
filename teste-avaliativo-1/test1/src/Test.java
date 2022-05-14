import java.util.Random;

public class Test {

    public static int [] [] buildMatrix (int row, int column) {
        Random r = new Random();

        int [] [] matrix = new int [row] [column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = r.nextInt(101);
            }
        }

        return matrix;
    }

    public static void printMatrix (int [] [] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("\n\n");
        }
    }

    public static int [] ascendingOrderVector (int [] vector) {
        int [] orderedVector = new int [vector.length];
        int index = 0;

        int smallestValue;

        do {
            smallestValue = Integer.MAX_VALUE;

            for (int i = 0; i < vector.length; i++) {
                if (vector[i] < smallestValue) {
                    smallestValue = vector[i];
                }
            }

            orderedVector[index] = smallestValue;
            index++;

            for (int i = 0; i < vector.length; i++) {
                if (vector[i] == smallestValue) {
                    vector[i] = Integer.MAX_VALUE;
                    break;
                }
            }
        } while (index < orderedVector.length);

        return orderedVector;
    }

    public static int [] [] ascendingOrderRows (int [] [] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = ascendingOrderVector(matrix[i]);
        }

        return matrix;
    }

    public static int [] [] ascendingOrderColumns (int [] [] matrix) {
        matrix = swapRowsAndColumns(matrix);
        matrix = ascendingOrderRows(matrix);
        matrix = swapRowsAndColumns(matrix);

        return matrix;
    }

    public static int [] [] swapRowsAndColumns (int [] [] matrix) {
        int [] [] swapedMatrix = new int [matrix[0].length] [matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                swapedMatrix[j][i] = matrix[i][j];
            }
        }

        return swapedMatrix;
    }

    public static void main(String[] args) {

        int [] [] matrix = buildMatrix(6, 5);

        System.out.println("\nMatriz original:\n");
        printMatrix(matrix);

        System.out.println("\nElementos das linhas em ordem crescente:\n");
        matrix = ascendingOrderRows(matrix);
        printMatrix(matrix);

        System.out.println("\nElementos das linhas em ordem crescente: + Elementos das colunas em ordem crescente:\n");
        matrix = ascendingOrderColumns(matrix);
        printMatrix(matrix);
    }
}