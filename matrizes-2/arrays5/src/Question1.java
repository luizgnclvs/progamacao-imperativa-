public class Question1 {

    public static int [] [] buildMatrix (int row, int column) {
        int [] [] matrix = new int [row] [column];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)Math.floor((Math.random() * 100) + 1);
            }
        }

        return matrix;
    }

    public static int [] sumMatrix (int [] [] matrix) {
        int [] sum = new int [matrix.length + matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];
            }

            sum[i] = rowSum;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int columnSum = 0;

            for (int j = 0; j < matrix.length; j++) {
                columnSum += matrix[j][i];
            }

            sum[matrix.length + i] = columnSum;
        }

        return sum;
    }

    public static void showMatrix (int [] [] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }

            System.out.println("\n");
        }
    }

    public static void showSum (int [] vector, int [] [] matrix) {
        for (int i = 0; i < vector.length; i++) {
            if (i < matrix.length) {
                System.out.print("Soma da " + (i + 1) + "ª linha: " + vector[i] + "\n");
            } else {
                System.out.print("Soma da " + ((i - matrix[0].length) + 2) + "ª coluna: " + vector[i] + "\n");
            }
        }
    }

    public static void main(String[] args) {

        int [] [] matrix = buildMatrix(3, 4);

        showMatrix(matrix);

        int [] sum = sumMatrix(matrix);

        showSum(sum, matrix);
    }
}