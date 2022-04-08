import java.util.Scanner;
import java.util.Random;

public class Main {
    
    static int menu () {
        Scanner read = new Scanner(System.in);
        
        System.out.printf("%s \n%s \n%s \n%s", "Olá, qual o método desejado para construir sua matriz?", "(Insira o número que corresponde ao método desejado)", "1 - Inserção manual", "2 - Inserção randômica\n");
        
        int method = read.nextInt();
        while(method != 1 && method != 2) {
            System.out.printf("\nOpção inválida! Tente novamente: ");
            method = read.nextInt();
        }
        return method;
    }

    static int[] matrixDimensions () {
        Scanner read = new Scanner(System.in);
        
        int[] dimensions = new int [2];

        System.out.println("\nInsira o número de linhas e colunas desejados para sua matriz");
        
        System.out.printf("Linhas: ");
        dimensions[0] = read.nextInt();
        
        System.out.printf("Colunas: ");
        dimensions[1] = read.nextInt();

        return dimensions;
    }

    static int menuOps () {
        Scanner read = new Scanner(System.in);

        System.out.printf("%s \n%s \n%s \n%s \n%s", "\nOlá, deseja realizar alguma operação com sua matriz?", "(Insira o número que corresponde ao método desejado)", "1 - Trocar linhas", "2 - Trocar colunas", "3 - Não desejo realizar nenhuma operação\n");

        int method = read.nextInt();
        while(method != 1 && method != 2 && method != 3) {
            System.out.printf("\nOpção inválida! Tente novamente: ");
            method = read.nextInt();
        }
        return method;
    }

    static int[][] buildMatrixRead (int x, int y) {
        Scanner read = new Scanner(System.in);
        
        int[][] matrix = new int [x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.printf("Insira um valor: ");
                matrix[i][j] = read.nextInt();
            }
        }
        return matrix;
    }

    static int[][] buildMatrixRandom (int x, int y) {
        Random r = new Random();

        int[][] matrix = new int [x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = r.nextInt(101);
            }
        }
        return matrix;
    }

    static void showMatrix (int[][] matrix) {
        System.out.println("\nSua matriz é:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d\t", matrix[i][j]);              
            }
            System.out.printf("\n");
        }
    }

    static int[] selectMatrix (int x, int[][] matrix) {
        Scanner read = new Scanner(System.in);
        
        String str, str2;
        int limit;
        if (x == 1) {
            str = "linhas";
            str2 = "Linha";
            limit = matrix.length;
        } else {
            str = "colunas";
            str2 = "Coluna";
            limit = matrix[0].length;
        }

        int[] select = new int [2];

        System.out.println("\nQuais " + str + " você deseja trocar?");
        for (int i = 0; i < 2; i++) {
            System.out.printf("%dª %s: ", i + 1, str2);
            select[i] = read.nextInt();
            while(select[i] < 1 || select[i] > limit) {
                System.out.printf("\nNão foi possível encontrar esta linha na sua matriz! Tente novamente: ");
                select[i] = read.nextInt();
            }
        }
        return select;
    }

    static int[][] shuffleRow (int[][] matrix, int x) {
        int[] select = selectMatrix(x, matrix);
        
        int row1 = (select[0] - 1);
        int row2 = (select[1] - 1);

        for (int i = 0; i < matrix[0].length; i++) {
            int temp = matrix[row1][i];
            matrix[row1][i] = matrix[row2][i];
            matrix[row2][i] = temp;
        }
        return matrix;
    }

    static int[][] shuffleColumn (int[][] matrix, int x) {
        int[] select = selectMatrix(x, matrix);
        
        int col1 = (select[0] - 1);
        int col2 = (select[1] - 1);

        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
        return matrix;
    }

    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);
        
        int[][] matrix;

        int method = menu();

        if (method == 1) {
            int[] dimensions = matrixDimensions();
            
            matrix = buildMatrixRead(dimensions[0], dimensions[1]);
        } else {
            int[] dimensions = matrixDimensions();
            
            matrix = buildMatrixRandom(dimensions[0], dimensions[1]);
        }

        showMatrix(matrix);
        
        int operation = menuOps();
        
        if (operation == 1) {
            shuffleRow(matrix, operation);

            showMatrix(matrix);
        } else if (operation == 2) {
            shuffleColumn(matrix, operation);

            showMatrix(matrix);
        } else {
            System.out.println("\nOk, nenhuma operação será executada");
        }
    }
}