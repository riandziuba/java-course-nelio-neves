package org.example.whileloop;

import java.util.Scanner;

public class question03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int userCode = scanner.nextInt();
        int alcohol = 0;
        int diesel = 0;
        int gasoline = 0;

        while (userCode != 4) {
           switch (userCode) {
               case 1 -> alcohol++;
               case 2 -> gasoline++;
               case 3 -> diesel++;
           }
           userCode = scanner.nextInt();
        }

        System.out.println("Muito Obrigado");
        System.out.println("Alcool: " + alcohol);
        System.out.println("Gasolina: " + gasoline);
        System.out.println("Diesel: " + diesel);
        scanner.close();
    }

}
