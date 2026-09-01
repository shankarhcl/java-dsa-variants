package com.interviewprep.prob03_firstnonrepeatingcharacter;

import java.util.HashMap;
import java.util.Map;

// Find the first non-repeating character using HashMap and a second pass over the string.
public class Variant3_HashMapWithSecondPass {

    public static void main(String[] args) {
        String input = "engineeringbranch";
        char result = firstNonRepeatingCharacter(input);

        System.out.println("First Non-Repeating Character: " + result);
    }

    private static char firstNonRepeatingCharacter(String input) {
        if (input == null || input.isEmpty()) {
            return '\0';
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            frequencyMap.put(currentChar, frequencyMap.getOrDefault(currentChar, 0) + 1);
        }

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (frequencyMap.get(currentChar) == 1) {
                return currentChar;
            }
        }

        return '\0';
    }
}

/*
Complexity:
Time: O(n)
Space: O(k), where k is the number of distinct characters.
In the worst case, Space: O(n).
*/
