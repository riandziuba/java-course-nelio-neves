package org.example.stringUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String stringTest = " Teste ";
        System.out.println(stringTest.toLowerCase() + "lower");
        System.out.println(stringTest.toUpperCase() + "upper");
        System.out.println(stringTest.trim() + "trimmed");

        System.out.println(stringTest.substring(2) + "Substring only begin");
        System.out.println(stringTest.substring(2,4) + "Substring begin and end");
        System.out.println(stringTest.replace("t", "s") + "With replace");
        System.out.println(Arrays.stream(stringTest.split("s")).toList().toString() + " With split 's'");
        System.out.println(stringTest.indexOf("e") + " first index of 'e'");
        System.out.println(stringTest.lastIndexOf("e") + " last index of 'e'");

    }
}