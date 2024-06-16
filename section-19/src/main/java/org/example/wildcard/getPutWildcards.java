package org.example.wildcard;

import java.util.ArrayList;
import java.util.List;

public class getPutWildcards {
    public static void main(String[] args) {
       List<Integer> integers = List.of(1, 2, 3, 4);
       List<Double> doubles = List.of(3.14, 6.28);
       List<Object> objects = new ArrayList<>();

       copy(integers, objects);
       copy(doubles, objects);

       printList(objects);
    }

    public static void copy(List<? extends Number> source, List<? super Number> target) {
        target.addAll(source);
    }

    public static void printList(List<?> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }
}
