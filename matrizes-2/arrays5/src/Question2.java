public class Question2 {

    public static int [] [] swapRows (int [] [] matrix, int row1, int row2) {
        for (int i = 0; i < matrix[0].length; i++) {
            int placeHolder = matrix[row1 - 1][i];
            matrix[row1 - 1][i] = matrix[row2 - 1][i];
            matrix[row2 - 1][i] = placeHolder;
        }

        return matrix;
    }

    public static int [] [] swapColumns (int [] [] matrix, int column1, int column2) {
        for (int i = 0; i < matrix.length; i++) {
            int placeHolder = matrix[i][column1 - 1];
            matrix[i][column1 - 1] = matrix[i][column2 - 1];
            matrix[i][column2 - 1] = placeHolder;
        }

        return matrix;
    }

    public static int [] [] swapDiagonals (int [] [] matrix) {
        int j = matrix.length - 1;

        for (int i = 0; i < matrix.length; i++) {
            int placeHolder = matrix[i][i];
            matrix[i][i] = matrix[i][j];
            matrix[i][j] = placeHolder;
            j--;
        }

        return matrix;
    }

    public static int [] [] swapRowAndColumn (int [] [] matrix, int row, int column) {
        for (int i = 0; i < matrix.length; i++) {
            int placeHolder = matrix[row - 1][i];
            matrix[row - 1][i] = matrix[i][column - 1];
            matrix[i][column - 1] = placeHolder;
        }

        return matrix;
    }

    public static void main(String args[]) {

        int [] [] matrix = Question1.buildMatrix(10, 10);

        System.out.println("Sua matriz é:");
        Question1.showMatrix(matrix);

        matrix = swapRows(matrix, 2, 8);

        System.out.println("\nTrocando a 2ª linha pela 8ª obtemos:");
        Question1.showMatrix(matrix);

        matrix = swapColumns(matrix, 4, 10);

        System.out.println("\nTrocando a 4ª coluna pela 10ª obtemos:");
        Question1.showMatrix(matrix);

        matrix = swapDiagonals(matrix);

        System.out.println("\nTrocando as diagonais obtemos:");
        Question1.showMatrix(matrix);

        matrix = swapRowAndColumn(matrix, 5, 10);

        System.out.println("\nApós trocar a linha 5 pela coluna 10, sua matriz final é:");
        Question1.showMatrix(matrix);
    }
}