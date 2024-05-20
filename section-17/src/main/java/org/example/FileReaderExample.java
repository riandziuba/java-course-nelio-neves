package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        String path = "src/main/java/org/example/test.txt";
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader(path);
            bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            do {
                System.out.println(line);
                line = bufferedReader.readLine();
            } while (line != null);
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
