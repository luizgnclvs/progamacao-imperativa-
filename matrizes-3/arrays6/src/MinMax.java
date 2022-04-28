public class MinMax {

    public static double [] [] buildMatrix (int row, int column) {

        double [] [] matrix = new double [row] [column];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.floor(Math.random() * 1000000.0) / 10000.0;
            }
        }

        return matrix;
    }

    public static void showMatrix (double [] [] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("\t" + matrix[i][j] + "\t");
            }

            System.out.print("\n\n");
        }
    }

    public static int findMinRow (double [] [] matrix) {

        double min = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] <= min) {
                    min = matrix[i][j];
                }
            }
        }

        int minRow = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == min) {
                    minRow = i;
                    break;
                }
            }
        }

        return minRow;
    }

    public static double findMax (double [] [] matrix) {

        double max = 0;

        int row = findMinRow(matrix);

        for (int i = 0; i < matrix[row].length; i++) {
            if (matrix[row][i] > max) {
                max = matrix[row][i];
            }
        }

        return max;
    }

    public static int findMinMaxColumn (double [] [] matrix) {

        double max = findMax(matrix);

        int row = findMinRow(matrix);
        int column = -1;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[row][i] == max) {
                column = i;
                break;
            }
        }

        return column;
    }

    public static void showMinMax (double [] [] matrix) {

        double max = findMax(matrix);

        int row = findMinRow(matrix);
        int column = findMinMaxColumn(matrix);

        System.out.println("\nSeu MINMAX é: " + max);
        System.out.println("E está localizado no cruzamento da:");
        System.out.println("Linha \'" + row + "\' e");
        System.out.println("Coluna \'" + column + "\'");
    }

    public static void main(String[] args) {

        double [] [] matrix = buildMatrix(4, 7);

        System.out.println("\nSua matriz é:\n");
        showMatrix(matrix);

        showMinMax(matrix);
    }
}