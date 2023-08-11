package org.example.application;

import org.example.entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class ExerciseHeight {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos pessoas vai digitar? ");
        int n = scanner.nextInt();
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person();
            System.out.println("Qual o nome? ");
            people[i].setName(scanner.next());
            System.out.println("Qual a idade? ");
            people[i].setAge(scanner.nextInt());
            System.out.println("Qual a altura? ");
            people[i].setHeight(scanner.nextDouble());
        }

        double sumHeight = 0;
        int lowerSixteen = 0;
        String namesLowerSixteen = "";
        for (Person person: people) {
            sumHeight += person.getHeight();
            if (person.getAge() < 16) {
                lowerSixteen++;
                namesLowerSixteen = namesLowerSixteen.concat(person.getName() + "\n");
            }
        }

        System.out.println("A altura média é " + (sumHeight / n));
        System.out.println("Pessoas com menos de 16 anos: " + (lowerSixteen * 100 / n) + "%");
        System.out.println(namesLowerSixteen);
    }
}
