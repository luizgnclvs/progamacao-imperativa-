import java.util.Scanner;

public class GradeReport {

    public static String [] studentsNames (int numberOfStudents, Scanner read) {
        String [] names = new String [numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Nome do(a) aluno(a): ");
            names[i] = read.next();
        }

        System.out.print("\n");

        return names;
    }

    public static double [] [] studentsGrades (String [] students, int numberOfTests, Scanner read) {
        double [] [] grades = new double [students.length] [numberOfTests + 1];

        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < numberOfTests; j++) {
                System.out.printf("A %dª nota do(a) aluno(a) \"%s\" é: ", (j + 1), students[i]);
                grades[i][j] = read.nextDouble();

                while (grades[i][j] < 0.0 || grades[i][j] > 10.0) {
                    System.out.print("Nota inválida! Tente novamente: ");
                    grades[i][j] = read.nextDouble();
                }
            }

            System.out.print("\n");
        }

        System.out.print("\n");

        return grades;
    }

    public static double [] overallGrades (double [] [] grades, int numberOfTests) {
        double [] overalls = new double [grades.length];

        for (int i = 0; i < grades.length; i++) {
            double mean = 0;

            for (int j = 0; j < numberOfTests; j++) {
                mean += grades[i][j];
            }

            overalls[i] = (mean / numberOfTests);
        }

        return overalls;
    }

    public static String [] passOrFail (double [] overallGrades, double passingGrade) {
        String [] status = new String [overallGrades.length];

        for (int i = 0; i < overallGrades.length; i++) {
            if (overallGrades[i] < passingGrade) {
                status[i] = "REPROVADO";
            } else {
                status[i] = "APROVADO";
            }
        }

        return status;
    }

    public static String [] reportHeaders (int numberOfTests) {
        String [] headers = new String [numberOfTests + 3];

        headers[0] = "Nome";
        headers[numberOfTests + 1] = "Média";
        headers[numberOfTests + 2] = "Situação";

        for (int i = 1; i <= numberOfTests; i++) {
            headers[i] = "Nota " + i;
        }

        return headers;
    }

    public static void fillReport (int numberOfStudents, int numberOfTests, double passingGrade, Scanner read) {
        String [] headers = reportHeaders(numberOfTests);
        String [] students = studentsNames(numberOfStudents, read);
        double [] [] grades = studentsGrades(students, numberOfTests, read);
        double [] overallGrades = overallGrades(grades, numberOfTests);
        String [] status = passOrFail(overallGrades, passingGrade);

        String [] [] report = new String [numberOfStudents + 1] [headers.length];

        for (int i = 0; i < headers.length; i++) {
            report[0][i] = headers[i];
        }

        for (int i = 1; i <= numberOfStudents; i++) {
            report[i][0] = students[i - 1];
            report[i][numberOfTests + 1] = Double.toString(Math.round(overallGrades[i - 1] * 10.0) / 10.0);
            report[i][numberOfTests + 2] = status[i - 1];

            for (int j = 0; j < numberOfTests; j++) {
                report[i][j + 1] = Double.toString(grades[i - 1][j]);
            }
        }

        printReport(report);

        printAuxiliatyReport(overallGrades, status, numberOfStudents);
    }

    public static void printReport (String [] [] report) {
        for (int i = 0; i < report.length; i++) {
            System.out.print("\n");

            for (int j = 0; j < report[i].length; j++) {
                System.out.print(report[i][j] + "\t");
            }

            if (i == 0) {
                System.out.print("\n");
            }
        }
    }

    public static void printAuxiliatyReport (double [] overallGrades, String [] status, int numberOfStudents) {
        double classAverage = 0;
        int passCount = 0;

        for (int i = 0; i < numberOfStudents; i++) {
            classAverage += overallGrades[i];

            if (status[i].matches("APROVADO")) {
                passCount++;
            }
        }

        System.out.println(
            "\n\nMédia da turma: " + Math.round((classAverage / numberOfStudents) * 10.0) / 10.0 +
            "\nPercentual de aprovados: " + Math.round((passCount * 100.0 / numberOfStudents) * 100.0) / 100.0 +
            "\nPercentual de reprovados: " + Math.round(((numberOfStudents - passCount) * 100.0 / numberOfStudents) * 100.0) / 100.0
        );
    }

    public static void main(String[] args) {

        Scanner read = new Scanner (System.in);

        System.out.print("\nOlá! Vamos preenhcer o relatório de notas da turma. \n\nQuantos alunos fazem parte da turma? ");
        int numberOfStudents = read.nextInt();

        System.out.print("Quantas provas e/ou testes compõem a média final? ");
        int numberOfTests = read.nextInt();

        System.out.print("Por fim, informe a nota de corte: ");
        double passingGrade = read.nextDouble();
        System.out.print("\n");

        fillReport(numberOfStudents, numberOfTests, passingGrade, read);
    }
}