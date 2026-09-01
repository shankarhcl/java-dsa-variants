package com.interviewprep.javadsavariants.prob01_reversestring;

// Reverse String without using toCharArray() or StringBuilder.reverse() or any library reverse function
public class Variant2_StringConcatenation {
    public static void main(String[] args) {
        String name = "myfirstprogram";
        System.out.println("Reversed String: " + reverseString(name));
    }

    private static String reverseString(String name) {
        if (name == null || name.length() == 0) {
            return "";
        }

        String result = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            result = result + name.charAt(i);
        }
        return result;
    }
}

/*
NOT recommended solution because String is immutable. Every result + character can create a new String.
So although the logic is correct, but with repeated String concatenation, the worst-case complexity can become O(n²).
*/
