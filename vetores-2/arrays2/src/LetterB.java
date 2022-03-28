import java.util.Scanner;

public class LetterB {
    
    static int [] buildVector() {
        Scanner read = new Scanner(System.in);
            
        int [] vector = new int [5];
            
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

    static int [] thisMinusThat(int [] vector1, int [] vector2) {
        int [] newVector = new int [vector1.length];

        for (int i = 0; i < newVector.length; i++) {
            newVector[i] = vector1[i] - vector2[i];
        }
        return newVector;
    }
    
    public static void main(String[] args) {
        
        System.out.println("Insira os valores desejados para \"A\"");
        int [] vectorA = buildVector();

        System.out.println("\nInsira os valores desejados para \"B\"");
        int [] vectorB = buildVector();

        int [] vectorC = thisMinusThat(vectorA, vectorB);

        System.out.printf("\nOs valores inseridos em \"A\" são: ");
        showVector(vectorA);
        System.out.printf("\nOs valores inseridos em \"B\" são: ");
        showVector(vectorB);
        
        System.out.printf("\n\nOs valores resultantes em \"C\" são: ");
        showVector(vectorC);
    }
}
