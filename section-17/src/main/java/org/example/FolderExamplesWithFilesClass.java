package org.example;

import java.io.File;
import java.util.Scanner;

public class FolderExamplesWithFilesClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a folder path: ");
        String path = scanner.nextLine();

        File folder = new File(path);

        File[] files = folder.listFiles(File::isDirectory);

        System.out.println("Folders:");
        for (File file : files) {
            System.out.println(file);
        }

        files = folder.listFiles(File::isFile);

        System.out.println("Files:");
        for (File file : files) {
            System.out.println(file);
        }

        boolean success = new File(path + "/createDirTest").mkdir();

        System.out.println("Directory created successfully: " + success);

        scanner.close();
    }
}
