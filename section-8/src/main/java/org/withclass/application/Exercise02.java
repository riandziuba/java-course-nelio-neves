package org.withclass.application;

import org.withclass.entities.Employee;

import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name:");
        employee.name = scanner.next();
        System.out.print("Gross salary:");
        employee.grossSalary = scanner.nextDouble();
        System.out.print("Tax:");
        employee.tax = scanner.nextDouble();

        System.out.println("Employee:" + employee);

        System.out.print("Which percentage to increase the salary? ");
        employee.increaseSalary(scanner.nextDouble());

        System.out.println("Update data: " + employee);
    }
}
