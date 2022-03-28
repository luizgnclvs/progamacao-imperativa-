import java.util.Scanner;

public class LetterD {
    
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

    static int [] toThePowerOfTwo(int [] vector) {
        int [] newVector = new int [vector.length];
        
        for (int i = 0; i < vector.length; i++) {
            newVector[i] = vector[i] * vector[i];
        }
        return newVector;
    }

    public static void main(String[] args) {
        
        int [] vectorA = buildVector(15);

        int [] vectorB = toThePowerOfTwo(vectorA);

        System.out.printf("\nOs valores inseridos em \"A\" são: ");
        showVector(vectorA);
        System.out.printf("\nOs valores resultantes em \"B\" são: ");
        showVector(vectorB);
    }
}
