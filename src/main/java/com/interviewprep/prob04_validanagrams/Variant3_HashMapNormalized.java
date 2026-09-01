package com.interviewprep.prob04_validanagrams;

import java.util.HashMap;
import java.util.Map;

// Check whether two strings are anagrams after ignoring spaces, punctuation, and case.
public class Variant3_HashMapNormalized {

    public static void main(String[] args) {
        String original = "Debit Card";
        String target = "Bad Credit";

        System.out.println("Is Anagram: " + isAnagram(original, target));
    }

    private static boolean isAnagram(String original, String target) {
        /*
         * Requirements:
         * - Input is not limited to lowercase letters
         * - Ignore spaces and punctuation
         * - Ignore case
         * - Digits are allowed
         */
        if (original == null || target == null) {
            return false;
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();

        int originalValidCharCount = 0;
        int targetValidCharCount = 0;

        for (int i = 0; i < original.length(); i++) {
            char currentChar = original.charAt(i);

            if (Character.isLetterOrDigit(currentChar)) {
                currentChar = Character.toLowerCase(currentChar);
                frequencyMap.put(currentChar, frequencyMap.getOrDefault(currentChar, 0) + 1);
                originalValidCharCount++;
            }
        }

        for (int i = 0; i < target.length(); i++) {
            char currentChar = target.charAt(i);

            if (Character.isLetterOrDigit(currentChar)) {
                currentChar = Character.toLowerCase(currentChar);

                if (!frequencyMap.containsKey(currentChar)) {
                    return false;
                }

                frequencyMap.put(currentChar, frequencyMap.get(currentChar) - 1);

                if (frequencyMap.get(currentChar) == 0) {
                    frequencyMap.remove(currentChar);
                }

                targetValidCharCount++;
            }
        }

        return originalValidCharCount == targetValidCharCount && frequencyMap.isEmpty();
    }
}

/*
Complexity:
Time: O(n), where n is the total number of characters scanned.
Space: O(k), where k is the number of distinct normalized characters.
In the worst case, Space: O(n).
*/