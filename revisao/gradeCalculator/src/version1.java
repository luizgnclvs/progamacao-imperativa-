import java.util.Scanner;

public class Version1 {
    
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);
			
	double grade1, grade2, grade3;
	String status;

	System.out.println("Insira sua primeira nota:");
	grade1 = read.nextDouble();

	System.out.println("\nInsira sua segunda nota:");
	grade2 = read.nextDouble();

	System.out.println("\nInsira sua terceira nota:");
	grade3 = read.nextDouble();

	double finalGrade = (grade1 + grade2 + grade3)/3;

	if (finalGrade >= 7) {
		status = "APROVADO POR MÉDIA";
	} else if (finalGrade >=5) {
		status = "APROVADO";
	} else {
		status = "REPROVADO";
	}

	System.out.printf("\nMédia: %.2f \nSituação: %s", finalGrade, status);
    }
}
