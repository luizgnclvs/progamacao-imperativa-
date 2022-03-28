import java.util.Scanner;

public class Question1 {
    
    static int [] buildVector() {
		Scanner read = new Scanner (System.in);
		
		int [] vector = new int [15];
		
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
	
	static boolean isTherePrimeNumber(int [] vector) {
		boolean hasPrime = true; 
		
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] == 1) {
				hasPrime = false;
				continue;
			} else if (vector[i] == 2) {
				hasPrime = true;
				break;
			} else {
				for (int j = 2; j < vector[i]; j++) {
					hasPrime = false;
					if (vector[i] % j == 0) {
						break;				
					} else {
						hasPrime = true;
					}
				}
			}
		}
		return hasPrime;		
	}
	
	static int howManyPrimes(int [] vector) {
		int thisMany = 0;
		
		if (isTherePrimeNumber(vector)) {
			for (int i = 0; i < vector.length; i++) {
				if (vector[i] == 2) {
					thisMany++;				
				} else {
					for (int j = 2; j < vector[i]; j++) {
						if (vector[i] % j == 0) {
							break;				
						} else if (j == (vector[i] - 1)) {
							thisMany++;
						} else {
							continue;
						}
					}
				}
			}
		}
		return thisMany;
	}
	
	static int [] primeVector(int [] vector) {
		int [] newVector = new int [howManyPrimes(vector)];
		int position = 0;
		
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] == 2) {
				newVector[position] = vector[i];
				position++;
			} else {
				for (int j = 2; j < vector[i]; j++) {
					if (vector[i] % j == 0) {
						break;				
					} else if (j == (vector[i] - 1)) {
						newVector[position] = vector[i];
						position++;
					} else {
						continue;
					}
				}
			}
		}
		return newVector;
	}	
	
	public static void main(String[] args) {
		
		int [] numbers;
		
		System.out.println("Olá! \nPor favor, insira 15 valores de números INTEIROS a serem armazenados em um vetor\n");
		
		numbers = buildVector();
		
		System.out.printf("\nOs valores inseridos no vetor são, em ordem de inserção: ");
		showVector(numbers);
		
		int [] primeNumbers;		
		primeNumbers = primeVector(numbers);
				
		System.out.printf("\n\nOs números primos contidos no seu vetor são, em ordem de inserção: ");
		showVector(primeNumbers);
	}
}
