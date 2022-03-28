import java.util.Scanner;

public class Question2 {
    
    static float [] buildVector() {
        Scanner read = new Scanner(System.in);
            
        float [] vector = new float [10];
            
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("Insira um valor para seu vetor: ");
            vector[i] = read.nextInt();
        }		
        return vector;
    }
    
    static void showVector(float [] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i == (vector.length - 1)) {
                System.out.printf("%.2f", vector[i]);
            } else {
                System.out.printf("%.2f, ", vector[i]);
            }
        }
    }

    static int howManyNegatives(float [] vector) {
        int count = 0;

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < 0) {
                count++;
            }
        }
        return count;
    }

    static float sumOfPositives(float [] vector) {
        float sum = 0;

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > 0) {
                sum += vector[i];
            }
        }
        return sum;
    }    

    public static void main(String[] args) {
        
        float [] numbers;
		
		System.out.println("Ol�! \nPor favor, insira 10 valores de n�meros INTEIROS a serem armazenados em um vetor\n");
		
		numbers = buildVector();

        System.out.printf("\nOs valores inseridos no vetor s�o, em ordem de inser��o: ");
		showVector(numbers);

        System.out.printf("\nA quantidade de números negativos presentes em seu vetor é de: %d \nA soma total de todos os valores positivos em seu vetor é de: %.2f", howManyNegatives(numbers), sumOfPositives(numbers));
    }
}
