package org.example.project.application;

import org.example.project.model.entities.Department;

public class Program {
    public static void main(String[] args) {
        Department department = new Department(1, "IT");
        System.out.println(department);
    }
}
