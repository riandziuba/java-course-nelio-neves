package org.example;

import org.example.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableInterface {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        String path = "src/main/java/org/example/name.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String employeeCsv = reader.readLine();

            while (employeeCsv != null) {
                String[] employeeFields = employeeCsv.split(",");
                employeeList.add(new Employee(employeeFields[0], Double.parseDouble(employeeFields[1])));
                employeeCsv = reader.readLine();
            }

            Collections.sort(employeeList);

            for (Employee employee : employeeList) {
                System.out.println(employee.getName() + ", " + employee.getSalary());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
