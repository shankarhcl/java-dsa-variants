package com.interviewprep.prob06_reversewordsinstring;

// Reverse word order by scanning from right to left without using split().
public class Variant2_ReverseScanWithoutSplit {
    public static void main(String[] args) {
        String input = "  Java   Dsa   Problem  ";
        System.out.println("Output: \"" + reverseWords(input) + "\"");
    }

    private static String reverseWords(String input) {
        if (input == null || input.isBlank()) {
            return input;
        }
        StringBuilder result = new StringBuilder();
        int right = input.length() - 1;

        while (right >= 0) {
            // Skip spaces
            while (right >= 0 && input.charAt(right) == ' ') {
                right--;
            }
            if (right < 0) {
                break;
            }
            int left = right;
            // Find beginning of word
            while (left >= 0 && input.charAt(left) != ' ') {
                left--;
            }
            if (result.length() > 0) {
                result.append(' ');
            }
            result.append(input, left + 1, right + 1);
            right = left - 1;
        }
        return result.toString();
    }
}

/*
Complexity:
Time: O(n)
Space: O(n) for the resulting StringBuilder
Additional algorithmic space: O(1). The algorithm itself uses O(1) working space, but because we must return a new String, the output requires O(n) memory.

Output:
Problem Dsa Java
*/
