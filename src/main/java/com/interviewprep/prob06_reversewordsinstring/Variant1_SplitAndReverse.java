package com.interviewprep.prob06_reversewordsinstring;

// Reverse word order using split() and StringBuilder.
public class Variant1_SplitAndReverse {
    public static void main(String[] args) {
        String input = "  Java   Dsa   Problem  ";
        System.out.println("Output: \"" + reverseWords(input) + "\"");
    }

    private static String reverseWords(String input) {
        if (input == null) {
            return null;
        }

        String trimmedInput = input.trim();

        if (trimmedInput.isEmpty()) {
            return "";
        }

        String[] words = trimmedInput.split("\\s+");
        StringBuilder result = new StringBuilder(trimmedInput.length());

        for (int i = words.length - 1; i >= 0; i--) {
            if (result.length() > 0) {
                result.append(' ');
            }

            result.append(words[i]);
        }

        return result.toString();
    }
}

/*
Complexity:
Time: O(n)
Space: O(n) for the word array and output.

Verdict:
The most readable solution for normal application code when split() is allowed.

Output:
Problem Dsa Java
*/