import java.util.Scanner;

public class version3 {
    
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
		
		Scanner read = new Scanner(System.in);
		
		int entry;
		double grade1, grade2, grade3;
			
		System.out.println("Olá!\n");
        
		while (true) {
			System.out.println("Você deseja descobrir a situação de algum aluno? \nDigite \"1\" caso queira continuar, ou \"2\" caso deseje encerrar a operação");
		
			entry = read.nextInt();
		
			while (entry != 1 && entry != 2) {
				System.out.printf("Opção inválida! Tente novamente: ");
				entry = read.nextInt();
			}

			if (entry == 1) {
				System.out.printf("\nInsira o nome do aluno: ");
				String name = read.next();
				
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
				
				System.out.printf("\nNome: %s\nMédia: %.1f \nSituação: %s\n\n", name, finalGrade, status);			
			} else {
				System.out.println("\nOPERAÇÃO ENCERRADA");
				break;
			}
		}
	}
}
