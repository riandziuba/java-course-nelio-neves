package org.example.forloop;

import java.util.Scanner;

public class question03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        float grade1, grade2, grade3;

        for (int i = 0; i < x; i++) {
            grade1 = scanner.nextFloat() * 2;
            grade2 = scanner.nextFloat() * 3;
            grade3 = scanner.nextFloat() * 5;
            System.out.println("A média é " + String.format("%.1f", (grade1 + grade2 + grade3) / 10));
        }
        scanner.close();
    }
}
