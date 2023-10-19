package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String[] array = scanner.nextLine().split(" ");
            int position = scanner.nextInt();
            System.out.println(array[position]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Position");
            e.printStackTrace();
            scanner.next();
        } catch (InputMismatchException e) {
            System.out.println("Input Error");
        }

        System.out.println("End of ProgramM");

        scanner.close();
    }
}