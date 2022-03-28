import java.util.Scanner;

public class Question3 {
    
    static int [] buildVector() {
		Scanner read = new Scanner(System.in);
		
		int [] vector = new int [10];
		
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
    
    static int [] swapANumber(int [] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > 0) {
                vector[i] *= -1;
            }            
        }        
        return vector;
    }    

    public static void main(String[] args) {
        
        int [] numbers;
		
		System.out.println("Ol�! \nPor favor, insira 10 valores de n�meros INTEIROS a serem armazenados em um vetor\n");
		
		numbers = buildVector();
        
        System.out.printf("\nOs valores inseridos no vetor s�o, em ordem de inser��o: ");
		showVector(numbers);

        System.out.printf("\n\nOs valores finais do seu vetor são: ");
        showVector(swapANumber(numbers));
    }
}
