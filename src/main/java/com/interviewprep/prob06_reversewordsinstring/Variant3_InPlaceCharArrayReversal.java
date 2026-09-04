package com.interviewprep.prob06_reversewordsinstring;

// Reverse word order by normalizing and reversing a character array.
public class Variant3_InPlaceCharArrayReversal {

    public static void main(String[] args) {
        String input = "  Java   Dsa   Problem  ";
        System.out.println("Output: \"" + reverseWords(input) + "\"");
    }

    private static String reverseWords(String input) {
        if (input == null) {
            return null;
        }

        if (input.trim().isEmpty()) {
            return "";
        }

        char[] characters = input.toCharArray();
        int read = 0;
        int write = 0;

        // Normalize whitespace while preserving word order.
        while (read < characters.length) {
            while (read < characters.length
                    && Character.isWhitespace(characters[read])) {
                read++;
            }
            if (read >= characters.length) {
                break;
            }
            if (write > 0) {
                characters[write++] = ' ';
            }
            while (read < characters.length
                    && !Character.isWhitespace(characters[read])) {
                characters[write++] = characters[read++];
            }
        }
        reverse(characters, 0, write - 1);
        int wordStart = 0;
        for (int wordEnd = 0; wordEnd <= write; wordEnd++) {
            if (wordEnd == write || characters[wordEnd] == ' ') {
                reverse(characters, wordStart, wordEnd - 1);
                wordStart = wordEnd + 1;
            }
        }
        return new String(characters, 0, write);
    }

    private static void reverse(char[] characters, int left, int right) {
        while (left < right) {
            char temporary = characters[left];
            characters[left] = characters[right];
            characters[right] = temporary;

            left++;
            right--;
        }
    }
}

/*
Complexity:
Time: O(n)
Working Space: O(1) after creating the character array.
Total Space: O(n) for the character array and returned String.

NOTE:
Useful for demonstrating the classic reverse-all, then reverse-each-word technique.

Output:
Problem Dsa Java
*/