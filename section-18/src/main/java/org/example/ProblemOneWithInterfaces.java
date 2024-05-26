package org.example;

import org.example.entities.CarRental;
import org.example.entities.Vehicle;
import org.example.services.BrazilTaxServices;
import org.example.services.RentalServicesWithInterfaces;

import java.util.Scanner;

public class ProblemOneWithInterfaces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarRental carRental = new CarRental();
        RentalServicesWithInterfaces service = new RentalServicesWithInterfaces(new BrazilTaxServices());

        System.out.println("Enter rental data:");

        System.out.print("Car model: ");
        carRental.setVehicle(new Vehicle(scanner.nextLine()));

        System.out.print("Pickup (dd/MM/yyyy hh:mm):");
        carRental.setPickupDate(scanner.nextLine());

        System.out.print("Return (dd/MM/yyyy hh:mm):");
        carRental.setReturnDate(scanner.nextLine());

        System.out.print("Enter price per hour: ");
        service.setPricePerHour(scanner.nextDouble());

        System.out.print("Enter price per day: ");
        service.setPricePerDay(scanner.nextDouble());

        service.processInvoice(carRental);

        System.out.println(carRental);
    }
}
