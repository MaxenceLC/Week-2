package org.example.week2ui;

public class StringManipulation {
    public static String toUpperCase(String input) {
        return input.toUpperCase();
    }

    public static String toLowerCase(String input) {
        return input.toLowerCase();
    }

    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
