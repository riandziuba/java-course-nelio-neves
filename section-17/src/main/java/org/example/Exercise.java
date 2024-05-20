package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the csv path:");
        String path = scanner.nextLine();

        File file = new File(path);
        Map<String, Double> information = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                Double unitValue = Double.parseDouble(parts[1]);
                Integer quantity = Integer.parseInt(parts[2]);

                information.put(name, unitValue * quantity);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean success = false;

        File newFolder = new File(file.getParent() + "/out");
        if (newFolder.exists()) {
            success = true;
        } else {
            success = newFolder.mkdir();
        }

        if (success) {
            String summaryPath = newFolder.getPath() + "/summary.csv";
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(summaryPath))) {
                for(String dataKey : information.keySet()) {
                    bufferedWriter.write(dataKey + "," + information.get(dataKey));
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        scanner.close();
    }
}
