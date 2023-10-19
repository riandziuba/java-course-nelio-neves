package org.example;

import org.example.model.entities.Reservation;
import org.example.model.exceptions.DomainException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CustomExceptions {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            Integer roomNumber = scanner.nextInt();
            System.out.print("Check-in date (dd/mm/yyyy): ");
            Date checkIn = dateFormat.parse(scanner.next());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            Date checkOut = dateFormat.parse(scanner.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println("Enter the data to update reservation:");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIn = dateFormat.parse(scanner.next());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkOut = dateFormat.parse(scanner.next());

            reservation.updateDates(checkIn, checkOut);

            System.out.println(reservation);
        } catch (ParseException e) {
            System.out.println("Invalid date format");
        } catch (DomainException e) {
            System.out.println("Reservation Exception: " + e.getMessage());
        }

        scanner.close();
    }
}
