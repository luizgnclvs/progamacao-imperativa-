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

    public static int [] [] findSmallestValuePerRow (int [] [] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            int smallestValue = Integer.MAX_VALUE;

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < smallestValue) {
                    smallestValue = matrix[i][j];
                }
            }

            for (int j = 0; j < matrix[i].length; j++) {
                if (smallestValue == matrix[i][j]) {
                    matrix[i][j] = matrix[i][0];
                    matrix[i][0] = smallestValue;
                }
            }
        }

        return matrix;
    }

    public static int [] [] orderColumn (int [] [] matrix, int column) {
        int [] orderedColumn = new int [matrix.length];

        int row = 0;

        while (row < matrix.length) {
            int smallestValue = Integer.MAX_VALUE;

            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][column] < smallestValue) {
                    smallestValue = matrix[j][column];
                }
            }

            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][column] == smallestValue) {
                    matrix[j][column] = Integer.MAX_VALUE;
                    break;
                }
            }

            orderedColumn[row] = smallestValue;
            row++;
        }

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = orderedColumn[i];
        }

        return matrix;
    }

    public static void main(String[] args) {

        int [] [] matrix = buildMatrix(6, 5);

        System.out.println("\nMatriz original:\n");
        printMatrix(matrix);

        System.out.println("\nMenor elemento de cada linha na 1ª posição:\n");
        matrix = findSmallestValuePerRow(matrix);
        printMatrix(matrix);

        System.out.println("\nMenor elemento de cada linha na 1ª posição + 1ª coluna em ordem crescente:\n");
        matrix = orderColumn(matrix, 0);
        printMatrix(matrix);
    }
}