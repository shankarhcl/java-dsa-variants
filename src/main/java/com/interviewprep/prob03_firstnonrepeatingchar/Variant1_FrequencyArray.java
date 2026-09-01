package com.interviewprep.prob03_firstnonrepeatingchar;

// Find the first non-repeating character using a fixed-size ASCII frequency array.
public class Variant1_FrequencyArray {

    public static void main(String[] args) {
        String input = "engineeringbranch";
        char result = firstNonRepeatingCharacter(input);

        System.out.println("First Non-Repeating Character: " + result);
    }

    private static char firstNonRepeatingCharacter(String input) {
        if (input == null || input.isEmpty()) {
            return '\0';
        }

        int[] frequency = new int[256];

        for (int i = 0; i < input.length(); i++) {
            frequency[input.charAt(i)]++;
        }

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (frequency[currentChar] == 1) {
                return currentChar;
            }
        }

        return '\0';
    }
}

/*
Complexity:
Time: O(n)
Space: O(1), because the frequency array has a fixed size of 256.
*/
