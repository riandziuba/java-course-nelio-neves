package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderWithTryResources {
    public static void main(String[] args) {
        String path = "src/main/java/org/example/test.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            do {
                System.out.println(line);
                line = bufferedReader.readLine();
            } while (line != null);
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
