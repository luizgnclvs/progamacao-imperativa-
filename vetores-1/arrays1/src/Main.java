import java.util.Scanner;

public class Main {
    
    static void showGrades(double [] xyz) {
		System.out.println("\nAs notas inseridas são:");
		for (int i = 0; i < xyz.length; i++) {
			System.out.printf("%dª nota: \t%.1f\n", i + 1, xyz[i]);
		}
	}
	
	static double gradesMean(double [] xyz) {
		double sum = 0.0;
		for (int i = 0; i < xyz.length; i++) {
			sum += xyz[i];
		}
		double mean = sum / xyz.length;
		return mean;
	}
	
	public static void main(String[] args) {
		
		Scanner read = new Scanner (System.in);
		
		double [] grades = new double [10];
		
		System.out.println("Olá!");
		
		for (int i = 0; i < grades.length; i++) {
			System.out.printf("Insira a nota de nº %d: ", i + 1);
			grades[i] = read.nextDouble();
		}
		
		showGrades(grades);
		
		System.out.printf("\nA média aritmética das notas inseridas é de: %.1f", gradesMean(grades));
	}
}
