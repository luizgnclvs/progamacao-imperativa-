public class Question3 {

    public static int findBiggest (int [] [] matrix) {
        int biggest = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] >= biggest) {
                    biggest = matrix[i][j];
                }
            }
        }

        return biggest;
    }

    public static int [] [] multiplyMatrix (int [] [] matrix, int factor) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] *= factor;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

        int [] [] M = Question1.buildMatrix(2, 2);

        System.out.println("Sua matriz original:");
        Question1.showMatrix(M);

        int [] [] R = multiplyMatrix(M, findBiggest(M));

        System.out.println("Sua nova matriz:");
        Question1.showMatrix(R);
    }
}
