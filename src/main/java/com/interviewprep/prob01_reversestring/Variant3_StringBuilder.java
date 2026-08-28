package com.interviewprep.prob01_reversestring;

// Reverse String with StringBuilder
public class Variant3_StringBuilder {
    public static void main(String[] args) {
        String name = "James";
        System.out.println("Reversed String: " + reverseString(name));
    }

    private static String reverseString(String name) {
        if (name == null || name.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder(name);
        return sb.reverse().toString();
    }
}

/*
Recommended solution because StringBuilder is mutable and provides an efficient reverse() method.
The time complexity is O(n) and the space complexity is O(n) due to the internal character array used by StringBuilder.
*/
