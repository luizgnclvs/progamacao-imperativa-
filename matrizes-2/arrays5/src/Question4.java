public class Question4 {

    public static String [] [] buildGrades (int students, int tests) {

        String [] [] grades = new String [students + 1] [tests + 1];

        grades[0][0] = "×××××××××××××××";

        for (int i = 1; i < grades[0].length; i++) {
            grades[0][i] = "Prova " + i;
        }

        for (int i = 1; i < grades.length; i++) {
            grades[i][0] = "Aluno nº" + i;
        }

        for (int i = 1; i < grades.length; i++) {
            for (int j = 1; j < grades[i].length; j++) {
                grades[i][j] = "  " + Double.toString(Math.floor((Math.random() * 10) * 10.0) / 10.0) + "  ";
            }
        }

        return grades;
    }

    public static void showGrades (String [] [] grades) {

        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < grades[i].length; j++) {
               System.out.print(grades[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    public static String [] [] smallestGrades (String [] [] grades) {

        String [] [] smallestGrades = new String [grades.length] [2];

        for (int i = 1; i < grades.length; i++) {
            smallestGrades[i][0] = grades[i][0];
        }

        smallestGrades[0][0] = "×××××××××××××××";
        smallestGrades[0][1] = "Menor Nota";

        for (int i = 1; i < grades.length; i++) {
            double smallest = 10.0;

            for (int j = 1; j < grades[i].length; j++) {
                if (Double.parseDouble(grades[i][j]) <= smallest) {
                    smallest = Double.parseDouble(grades[i][j]);
                }
            }

            smallestGrades[i][1] = Double.toString(Math.round(smallest * 10.0) / 10.0);
        }

        return smallestGrades;
    }

    private static String [] [] smallestGradeByTest (String [] [] grades) {

        String [] [] smallestGrades = new String [grades[0].length - 1] [3];

        for (int i = 0; i < smallestGrades.length; i++) {
            double smallest = 10.0;

            for (int j = 1; j < grades.length; j++) {
                if (Double.parseDouble(grades[j][i + 1]) <= smallest) {
                    smallest = Double.parseDouble(grades[j][i + 1]);
                }
            }

            int count = 0;

            for (int k = 1; k < grades.length; k++) {
                if (Double.parseDouble(grades[k][i + 1]) == smallest) {
                    count++;
                }
            }

            smallestGrades[i][0] = "Prova " + (i + 1) + ":";
            if (count == 1) {
                smallestGrades[i][1] = count + " aluno tirou a menor nota";
            } else {
                smallestGrades[i][1] = count + " alunos tiraram a menor nota";
            }

            smallestGrades[i][2] = "   " + Double.toString(Math.round(smallest * 10.0) / 10.0) + "   ";
        }

        return smallestGrades;
    }

    public static void main(String[] args) {

        String [] [] grades = buildGrades(10, 3);

        System.out.print("Notas dos alunos:\n\n");
        showGrades(grades);

        System.out.print("\nA menor das três notas de cada aluno:\n\n");
        showGrades(smallestGrades(grades));

        System.out.print("\nA menor nota de cada prova e quantos alunos a tiraram:\n\n");
        showGrades(smallestGradeByTest(grades));
    }
}