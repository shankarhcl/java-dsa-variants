package com.interviewprep.prob03_firstnonrepeatingcharacter;

import java.util.LinkedHashMap;
import java.util.Map;

// Find the first non-repeating character using LinkedHashMap.
public class Variant2_LinkedHashMap {

    public static void main(String[] args) {
        String input = "engineeringbranch";
        char result = firstNonRepeatingCharacter(input);

        System.out.println("First Non-Repeating Character: " + result);
    }

    private static char firstNonRepeatingCharacter(String input) {
        if (input == null || input.isEmpty()) {
            return '\0';
        }

        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            frequencyMap.put(currentChar, frequencyMap.getOrDefault(currentChar, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
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
