package org.example;

import java.io.File;
import java.util.Scanner;

public class GetFileInfoExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        System.out.println("File name: " + file.getName());
        System.out.println("Parent directory: " + file.getParent());
        System.out.println("Path: " + file.getPath());
        scanner.close();
    }
}
