package org.example.sets;

import java.util.*;

public class Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        List<Integer> courseA = new ArrayList<>();
        List<Integer> courseB = new ArrayList<>();
        List<Integer> courseC = new ArrayList<>();

        System.out.print("How many students on course A? ");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            courseA.add(scanner.nextInt());
        }

        System.out.print("How many students on course B? ");
        number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            courseB.add(scanner.nextInt());
        }

        System.out.print("How many students on course C? ");
        number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            courseC.add(scanner.nextInt());
        }

        set.addAll(courseA);
        set.addAll(courseB);
        set.addAll(courseC);

        System.out.println("Number of students: " + set.size());
    }

}
