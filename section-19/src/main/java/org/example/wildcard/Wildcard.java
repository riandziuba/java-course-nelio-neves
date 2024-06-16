package org.example.wildcard;

import java.util.List;

public class Wildcard {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 2, 10);
        printList(numbers);

        List<String> strings = List.of("Maria", "John", "Bob");
        printList(strings);
    }

    public static void printList(List<?> list) {
        for (Object item: list) {
            System.out.println(item);
        }
    }
}
