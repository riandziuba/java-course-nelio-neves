package org.example;

import org.example.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String path = scanner.nextLine();
        System.out.print("Enter salary limit: ");
        double limitValue = scanner.nextDouble();
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                employees.add(new Employee(data[0], data[1], Double.parseDouble(data[2])));
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading" + e.getMessage());
        }

        List<Employee> filteredEmployees = employees.stream().filter(employee -> employee.getSalary() > limitValue).toList();
        Double sum = employees.stream().filter(employee -> employee.getName().charAt(0) == 'M').map(Employee::getSalary).reduce(0.0, (subtotal, element) -> subtotal + element);

        System.out.println("Employee with salary greater than " + limitValue);
        filteredEmployees.forEach(employee -> System.out.println(employee.getEmail()));
        System.out.println("Sum of employee with name starting with letter M is: " + sum);
    }
}
