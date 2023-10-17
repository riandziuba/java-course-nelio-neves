package org.example;

import org.example.entities.Department;
import org.example.entities.HourContract;
import org.example.entities.Worker;
import org.example.entities.enums.WorkerLevel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Exercise01 {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        Department department = new Department(scanner.next());
        System.out.println("Enter de worker data:");
        System.out.print("Name: ");
        String workerName = scanner.next();
        System.out.print("Level: ");
        String workerLevel = scanner.next();
        System.out.print("Base salary: ");
        Double workerBaseSalary = scanner.nextDouble();
        System.out.print("Number of contracts: ");
        int workerContractsQuantity = scanner.nextInt();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, department);

        for (int i = 0; i < workerContractsQuantity; i++) {
            System.out.println("Enter Contract #" + (i + 1) + " data:");
            System.out.print("Date: ");
            String contractDate = scanner.next();
            System.out.print("Value per hour: ");
            double contractValuePerHour = scanner.nextDouble();
            System.out.print("Duration(Hours): ");
            Integer contractHour = scanner.nextInt();
            HourContract contract = new HourContract(dateFormat.parse(contractDate), contractValuePerHour, contractHour);
            worker.addContract(contract);
        }

        System.out.print("Enter month and year to calculate the income (MM/YYYY): ");
        String incomeDate = scanner.next();
        String[] incomeDateSplitted = incomeDate.split("/");
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Name: " + worker.income(Integer.parseInt(incomeDateSplitted[1]), Integer.parseInt(incomeDateSplitted[0])));
    }
}
