package org.example;

import org.example.entities.Employee;
import org.example.entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        List<Employee> employees = new ArrayList<>();
        int numberOfEmployees = scanner.nextInt();
        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("Employee #" + (i+1) + " data:");
            System.out.print("OutSourced? (y/n) ");
            boolean outsourcedAnswer = scanner.next().equals("y");
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Hours: ");
            int hours = scanner.nextInt();
            System.out.print("Value per hour: ");
            double value = scanner.nextDouble();
            if (outsourcedAnswer) {
                System.out.print("Additional charge: ");
                double additionalCharge = scanner.nextDouble();
                Employee employee = new OutsourcedEmployee(name, hours, value, additionalCharge);
                employees.add(employee);
            } else {
                Employee employee = new Employee(name, hours, value);
                employees.add(employee);
            }
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
