package org.example.stringmanipulationfinal;

public class StringManipulation {
    public String toUpperCase(String input) {
        return input.toUpperCase();
    }

    public String toLowerCase(String input) {
        return input.toLowerCase();
    }

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
