package com.interviewprep.prob05_removeduplicatechars;

// Remove duplicate characters from a given string using only String operations (no StringBuilder or any additional data structures).
// Not Optimized
/*
Rules:
    Preserve the first occurrence
    Maintain original order
    Don't use distinct() or Streams
*/
public class Variant1_StringConcatenation {

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

        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (result.indexOf(currentChar) == -1) {
                result += currentChar;
            }
        }

        return result;
    }
}

/*
Complexity:
Time: O(n²), because indexOf() scans the growing result and String
concatenation repeatedly copies existing characters.

Auxiliary Space: O(n), including the returned String.
Total temporary allocation can reach O(n²) because String is immutable.

NOTE:
Useful for demonstrating the limitations of a String-only solution,
but not recommended for performance-sensitive code.

Output:
Input:  programming
Output: progamin
*/
