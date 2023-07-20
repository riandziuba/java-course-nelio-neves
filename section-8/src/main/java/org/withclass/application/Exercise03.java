package org.withclass.application;

import org.withclass.entities.Student;

import java.util.Scanner;

public class Exercise03 {

    public static void main(String[] args) {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);

        student.name = scanner.next();
        student.grade1 = scanner.nextDouble();
        student.grade2 = scanner.nextDouble();
        student.grade3 = scanner.nextDouble();

        System.out.println("FINAL GRADE: " + student.finalGrade());

        if(student.StudentIsApproved()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAILED");
            System.out.println("MISSING " + student.missingPoints() + " POINTS");
        }
    }
}
