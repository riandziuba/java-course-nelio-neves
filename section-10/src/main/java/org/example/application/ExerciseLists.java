package org.example.application;

import org.example.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ExerciseLists {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vai digitar quantos funcionarios?");
        int n = scanner.nextInt();

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Employee employee = new Employee();
            System.out.print("Id:");
            employee.setId(scanner.nextInt());
            System.out.print("Nome:");
            employee.setName(scanner.next());
            System.out.print("Salary:");
            employee.setSalary(scanner.nextDouble());
            employees.add(employee);
        }

        System.out.print("Coloque o id do trabalhador para receber aumento:");
        int id = scanner.nextInt();

        Employee selectedEmployee = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if(selectedEmployee == null) {
            System.out.println("Funcionario não encontrado");
        } else {
            System.out.println("Digite a porcentagem:");
            double perc = scanner.nextDouble();
            selectedEmployee.setSalary(selectedEmployee.getSalary() * (perc / 100 + 1));
            for(Employee employee : employees) {
                System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getSalary());
            }
        }
        scanner.close();

    }
}
