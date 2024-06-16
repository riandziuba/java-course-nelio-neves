package org.example.maps;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Map<String, Integer> candidates = new HashMap<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/votes.csv"))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                if (!candidates.containsKey(data[0])) {
                    candidates.put(data[0], Integer.parseInt(data[1]));
                } else {
                    candidates.put(data[0], candidates.get(data[0]) + Integer.parseInt(data[1]));
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        for (Map.Entry<String, Integer> candidate : candidates.entrySet()) {
            System.out.println(candidate.getKey() + ": " + candidate.getValue());
        }
    }


}
