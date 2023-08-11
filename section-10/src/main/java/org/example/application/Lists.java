package org.example.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lists {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Maria");
        list.add("Alex");
        list.add("Bob");
        list.add("Ana");
        list.add("Anna");
        list.add(2, "Marco");

        System.out.println(list.size());


        for (String x : list) {
            System.out.println(x);
        }

        System.out.println("--------------");
        list.remove("Ana");
        list.removeIf(x -> x.charAt(0) == 'M');
        for (String x : list) {
            System.out.println(x);
        }

        System.out.println("--------------");
        System.out.println("Index of Bob: "+ list.indexOf("Bob"));
        System.out.println("--------------");

        List<String> list2 = list.stream().filter(x -> x.charAt(0) == 'A').toList();

        for (String x : list2) {
            System.out.println(x);
        }
        System.out.println("--------------");

        String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
    }
}
