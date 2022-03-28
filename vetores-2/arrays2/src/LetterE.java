import java.util.Scanner;

public class LetterE {
    
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

   static int [] swapVectors(int [] vector) {
       int [] newVector = new int [vector.length];

       int j = vector.length - 1;

       for (int i = 0; i < vector.length; i++) {
           newVector[i] = vector[j];
           j--;
       }
       return newVector;
   }

    public static void main(String[] args) {
        
        int [] vectorA = buildVector(20);

        int [] vectorB = swapVectors(vectorA);

        System.out.printf("\nOs valores inseridos em \"A\" são: ");
        showVector(vectorA);
        System.out.printf("\nOs valores resultantes em \"B\" são: ");
        showVector(vectorB);
    }
}
