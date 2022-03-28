import java.util.Scanner;

public class Version3$2 {
    
	static void menu() {
		System.out.printf("%s \n%s \n%s \n%s\n", "Você deseja averiguar a situação acadêmica de algum aluno?", "Selecione alguma das opções abaixo:", "\"1\" - Prosseguir com a operação", "\"2\" - Encerrar operação");
	}

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

		String entry;
		double grade1, grade2, grade3;

		System.out.println("Olá!\n");
		while (true) {

			menu();			
			entry = read.next();

			while (!entry.equals("1") && !entry.equals("2")) {
				System.out.printf("Opção inválida! Tente novamente: ");
				entry = read.next();
			}

			if (entry.equals("1")) {
				System.out.printf("\nInsira o nome do aluno: ");
				String name = read.next();

				System.out.printf("Insira a primeira nota do aluno: ");
				grade1 = read.nextDouble();

				while (isItValid(grade1) == false) {
					System.out.printf("Nota inválida! Tente novamente: ");
					grade1 = read.nextDouble();
				}

				System.out.printf("Insira a segunda nota: ");
				grade2 = read.nextDouble();

				while (isItValid(grade2) == false) {
					System.out.printf("Nota inválida! Tente novamente: ");
					grade2 = read.nextDouble();
				}

				System.out.printf("Por fim, insira a terceira nota: ");
				grade3 = read.nextDouble();

				while (isItValid(grade3) == false) {
					System.out.printf("Nota inválida! Tente novamente: ");
					grade3 = read.nextDouble();
				}
					
				String status = studentSituation(whatsFinalGrade(grade1, grade2, grade3));

				System.out.printf("\nNome: %s\nMédia: %.1f \nSituação: %s\n\n", name, whatsFinalGrade(grade1, grade2, grade3), status);			
			} else {
				System.out.println("\nOPERAÇÂO ENCERRADA");
				break;
			}
		}
	}
}