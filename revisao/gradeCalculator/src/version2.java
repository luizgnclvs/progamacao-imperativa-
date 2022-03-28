import java.util.Scanner;

public class Version2 {
    
    	static boolean isItValid(double x) {
		if (x > 10 || x < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	static double whatsFinalGrade(double x, double y, double z) {
		return (x + y + z)/3;
	}

	static String studentSituation(double x) {
		if (x >= 7) {
			return "APROVADO POR MÉDIA";
		} else if (x >= 5) {
			return "APROVADO";
		} else {
			return "REPROVADO";
		}
	}

	public static void main(String[] args) {

		Scanner read = new Scanner (System.in);

		double grade1, grade2, grade3;

		System.out.printf("Insira sua primeira nota: ");
		grade1 = read.nextDouble();
		while (isItValid(grade1) == false) {
			System.out.printf("Nota inválida! Tente novamente: ");
			grade1 = read.nextDouble();
		}

		System.out.printf("Insira sua segunda nota: ");
		grade2 = read.nextDouble();
		while (isItValid(grade2) == false) {
			System.out.printf("Nota inválida! Tente novamente: ");
			grade2 = read.nextDouble();
		}

		System.out.printf("Insira sua terceira nota: ");
		grade3 = read.nextDouble();
		while (isItValid(grade3) == false) {
			System.out.printf("Nota inválida! Tente novamente: ");
			grade3 = read.nextDouble();
		}

		double finalGrade = whatsFinalGrade(grade1, grade2, grade3);
		String status = studentSituation(finalGrade);

		System.out.printf("\n\nMédia: %.1f \t Situação: %s", finalGrade, status);		
	}
}
