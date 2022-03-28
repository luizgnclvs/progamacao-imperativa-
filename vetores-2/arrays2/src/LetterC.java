import java.util.Scanner;

public class LetterC {
    
    static int [] buildVector(int x) {
        Scanner read = new Scanner(System.in);
            
        int [] vector = new int [x];
            
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("Insira um valor para seu vetor: ");
            vector[i] = read.nextInt();
        }		
        return vector;
    }

    static void showVector(int [] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i == (vector.length - 1)) {
                System.out.printf("%d", vector[i]);
            } else {
                System.out.printf("%d, ", vector[i]);
            }
        }
    }

    static int [] concatVectors(int [] vector1, int[] vector2) {
        int [] newVector = new int [vector1.length + vector2.length];

        for (int i = 0; i < newVector.length; i++) {
            if (i < vector1.length) {
                newVector[i] = vector1[i];
            } else {
                newVector[i] = vector2[i - vector1.length];
            }            
        }
        return newVector;
    }

    public static void main(String[] args) {
        
        System.out.println("Insira os valores desejados para \"A\"");
        int [] vectorA = buildVector(5);

        System.out.println("\nInsira os valores desejados para \"B\"");
        int [] vectorB = buildVector(10);

        int [] vectorC = concatVectors(vectorA, vectorB);

        System.out.printf("\nOs valores inseridos em \"A\" são: ");
        showVector(vectorA);
        System.out.printf("\nOs valores inseridos em \"B\" são: ");
        showVector(vectorB);
        
        System.out.printf("\n\nOs valores resultantes em \"C\" são: ");
        showVector(vectorC);
    }
}
