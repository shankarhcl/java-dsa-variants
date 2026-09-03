package com.interviewprep.prob05_removeduplicatechars;

// Remove duplicate ASCII characters from a given string using a fixed-size lookup array and StringBuilder.
// Optimized for ASCII characters
/*
Rules:
    Preserve the first occurrence
    Maintain original order
    Don't use distinct() or Streams
*/
public class Variant2_AsciiBooleanArray {

    private static final int ASCII_CHARACTER_COUNT = 256;

    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);

        System.out.println("Input:  " + input);
        System.out.println("Output: " + result);
    }

    private static String removeDuplicates(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        boolean[] seen = new boolean[ASCII_CHARACTER_COUNT]; // it contains array of 256 elements, which is enough to cover all ASCII characters.
        StringBuilder result = new StringBuilder(input.length());

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar >= ASCII_CHARACTER_COUNT) {
                throw new IllegalArgumentException(
                        "Input contains a non-ASCII character: " + currentChar
                );
            }

            if (!seen[currentChar]) {
                seen[currentChar] = true;
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}

/*
Complexity:
Time: O(n)
Space: O(n) for the resulting StringBuilder, plus O(1) for the fixed 256-element seen array.

Constraint:
This implementation accepts only ASCII characters.

Output:
Input:  programming
Output: progamin
*/