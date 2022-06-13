import java.util.Scanner;

public class Main {

    public static Scanner read = new Scanner (System.in);

    public static Employee [] boot () {
        System.out.print("\nOlá!\nAntes de realizar qualquer operação, você precisa cadastrar alguns funcionários.\nQuantos funcionários deseja cadastrar? ");
        int numberOfEmployees = read.nextInt();
        read.nextLine();

        System.out.println("\nUtilize a seguinte tabela como referência dos cargos disponíveis:\n");
        Post.printPostList();

        return registerMultipleEmployees(numberOfEmployees);
    }

    public static int menu () {
        System.out.printf(
            "%n%s%n%n%s\t%s%n%n%d\t%s%n%d\t%s%n%d\t%s%n%d\t%s%n%d\t%s%n%d\t%s%n%n%s",
            "Qual operação deseja realizar?",
            "Código", "Operação",
            1, "Organizar registros por matrícula.",
            2, "Buscar funcionário.",
            3, "Mostrar todos os funcionários que recebem menos que R$ 1000.00",
            4, "Mostrar todos os funcionários que recebem exatamente R$ 1000.00",
            5, "Mostrar todos os funcionários que recebem mais que R$ 1000.00",
            6, "Sair",
            "Selecione o código da operação desejada: "
        );

        int entry = read.nextInt();

        while (entry > 6 || entry < 1) {
            System.out.print("Opção inválida! Tente novamente: ");
            entry = read.nextInt();
        }

        return entry;
    }

    public static void operations (int operation, Employee [] employees) {
        if (operation == 1) {
            employees = sortById(employees);
            printEmployees(employees);
        } else if (operation == 2) {
            System.out.printf("%n%d\t%s%n%d\t%s%n%n%s", 1, "Matrícula", 2, "Nome", "Qual método de busca deseja utilizar? ");
            int searchMethod = read.nextInt();

            while (searchMethod > 2 || searchMethod < 1) {
                System.out.print("Opção inválida! Tente novamente: ");
                searchMethod = read.nextInt();
            }

            if (searchMethod == 1) {
                System.out.print("Ok, qual a matrícula do funcionário? ");
                int employeeId = read.nextInt();
                System.out.println("");
                searchEmployeeById(employees, employeeId);
            } else {
                System.out.print("Ok, qual o nome do funcionário? ");
                read.nextLine();
                String employeeName = read.nextLine();
                System.out.println("");
                searchEmployeeByName(employees, employeeName);
            }
        } else if (operation == 3) {
            if (isPaidLessThan1000(employees).length > 0) {
                printEmployees(isPaidLessThan1000(employees));
            } else {
                System.out.println("\nNenhum funcionário com esses parâmetros foi encontrado.");
            }
        } else if (operation == 4) {
            if (isPaidExactly1000(employees).length > 0) {
                printEmployees(isPaidExactly1000(employees));
            } else {
                System.out.println("\nNenhum funcionário com esses parâmetros foi encontrado.");
            }
        } else if (operation == 5) {
            if (isPaidMoreThan1000(employees).length > 0) {
                printEmployees(isPaidMoreThan1000(employees));
            } else {
                System.out.println("\nNenhum funcionário com esses parâmetros foi encontrado.");
            }
        } else {
            System.out.println("\nOk. Até a próxima.");
        }
    }

    public static Employee registerNewEmployee () {
        System.out.print("\nNome do funcionário: ");
        String name = read.nextLine();
        System.out.print("Id do Cargo do funcionário: ");
        int post = read.nextInt();
        read.nextLine();

        while (post < 1 || post > Post.postList.length) {
            System.out.print("Cargo inexistente! Tente novamente: ");
            post = read.nextInt();
            read.nextLine();
        }

        Employee employee = new Employee(name, post);

        return employee;
    }

    public static Employee [] registerMultipleEmployees (int numberOfEmployees) {
        Employee [] employees = new Employee [numberOfEmployees];

        for (int i = 0; i < numberOfEmployees; i++) {
            employees[i] = registerNewEmployee();
        }

        return employees;
    }

    public static void printEmployees (Employee [] employees) {
        System.out.println("");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
        }
    }

    public static Employee [] sortById (Employee [] employees) {
        for (int i = 0; i < employees.length; i++) {
            for (int j = i + 1; j < employees.length; j++) {
                Employee placeHolder = new Employee();
                if (employees[i].getId() > employees[j].getId()) {
                    placeHolder = employees[i];
                    employees[i] = employees[j];
                    employees[j] = placeHolder;
                }
            }
        }

        return employees;
    }

    public static Employee [] isPaidLessThan1000 (Employee [] employees) {
        int count = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < 1000.00) {
                count++;
            }
        }

        Employee [] matchedEmployees = new Employee [count];
        int index = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < 1000.00) {
                matchedEmployees[index] = employees[i];
                index++;
            }
        }

        matchedEmployees = sortById(matchedEmployees);

        return matchedEmployees;
    }

    public static Employee [] isPaidExactly1000 (Employee [] employees) {
        int count = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() == 1000.00) {
                count++;
            }
        }

        Employee [] matchedEmployees = new Employee [count];
        int index = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() == 1000.00) {
                matchedEmployees[index] = employees[i];
                index++;
            }
        }

        matchedEmployees = sortById(matchedEmployees);

        return matchedEmployees;
    }

    public static Employee [] isPaidMoreThan1000 (Employee [] employees) {
        int count = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > 1000.00) {
                count++;
            }
        }

        Employee [] matchedEmployees = new Employee [count];
        int index = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > 1000.00) {
                matchedEmployees[index] = employees[i];
                index++;
            }
        }

        matchedEmployees = sortById(matchedEmployees);

        return matchedEmployees;
    }

    public static void searchEmployeeById (Employee [] employees, int employeeId) {
        employees = sortById(employees);

        Employee searchedEmployee = new Employee();
        int beginning = 0, middle, end = employees.length - 1;
        boolean found = false;

        while (beginning <= end) {
            middle = (beginning + end) / 2;

            if (employees[middle].getId() == employeeId) {
                searchedEmployee = employees[middle];
                found = true;
                break;
            } else if (employees[middle].getId() > employeeId) {
                end = middle - 1;
            } else {
                beginning = middle + 1;
            }
        }

        if (found) {
            System.out.println(searchedEmployee.toString());
        } else {
            System.out.println("Nenhum funcionário com matrícula correspondente foi encontrado.");
        }
    }

    public static void searchEmployeeByName (Employee [] employees, String employeeName) {
        Employee searchedEmployee = new Employee();
        boolean found = false;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName().equals(employeeName)) {
                searchedEmployee = employees[i];
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println(searchedEmployee.toString());
        } else {
            System.out.println("Nenhum funcionário com este nome foi encontrado.");
        }
    }

    public static void main(String[] args) {
        Post.setPostList();

        Employee [] employees = boot();

        int entry = 0;

        while (entry != 6) {
            entry = menu();
            operations(entry, employees);
        }
    }
}