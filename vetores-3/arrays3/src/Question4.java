import java.util.Scanner;

public class Question4 {
    
    static void showVector(int [] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i == (vector.length - 1)) {
                System.out.printf("%d", vector[i]);
            } else {
                System.out.printf("%d, ", vector[i]);
            }
        }
    }

    static int [][] concatArrays(int [] vector1, int [] vector2) {
        int [][] bothArrays = new int [2][10];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0) {
                    bothArrays[i][j] = vector1[j];                    
                } else {
                    bothArrays[i][j] = vector2[j];                    
                }                
            }
        }
        return bothArrays;
    }

    static int [][] evenOrOdd() {
        Random r = new Random();
        
        int [] vectorEven = new int [10];
        int [] vectorOdd = new int [10];

        int evenPos = 0;
        int oddPos = 0;

        int number;

        for (int i = 0; i < 10; i++) {
            number = (r.nextInt(20) + 1);

            if (number % 2 == 0) {
                vectorEven[evenPos] = number;
                evenPos++;
            } else {
                vectorOdd[oddPos] = number;
                oddPos++;
            }
        }
        return concatArrays(vectorOdd, vectorEven);
    }      

    public static void main(String[] args) {
                                        
        int [][] evensAndOdds = evenOrOdd();

        int [] evens = new int [10];
        int [] odds = new int [10];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0) {
                    odds[j] = evensAndOdds[i][j];
                } else {
                    evens[j] = evensAndOdds[i][j];
                }
            }
        }

        System.out.printf("O vetor contendo os números ímpares é: ");
        showVector(odds);
        System.out.printf("\nO vetor contendo os números pares é: ");
        showVector(evens);
    }
}
