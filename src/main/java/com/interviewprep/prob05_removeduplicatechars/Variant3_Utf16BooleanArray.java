package com.interviewprep.prob05_removeduplicatechars;

// Remove duplicate Java char values from a given string using a UTF-16 code-unit lookup array and StringBuilder.
// Optimized for Unicode characters
/*
Rules:
    Preserve the first occurrence
    Maintain original order
    Don't use distinct() or Streams
*/
public class Variant3_Utf16BooleanArray {

    private static final int CHAR_VALUE_COUNT = Character.MAX_VALUE + 1;

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

        boolean[] seen = new boolean[CHAR_VALUE_COUNT]; // it contains array of 65536 elements, which is enough to cover all Unicode characters.
        StringBuilder result = new StringBuilder(input.length());

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

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
Tracking Space: O(1) with respect to input length, because the lookup array
always contains 65,536 entries.
Output Space: O(n) for the resulting StringBuilder, plus O(1) for the fixed 65536-element seen array.

Unicode note:
This implementation tracks UTF-16 code units, not complete Unicode code points.
Supplementary characters, including many emoji, use surrogate pairs and are
processed as two char values.

Output:
Input:  programming
Output: progamin
*/