package com.interviewprep.prob04_validanagrams;

// Check whether two lowercase strings are anagrams using a fixed-size frequency array.
public class Variant2_FrequencyArrayLowercase {

    public static void main(String[] args) {
        String original = "radar";
        String target = "ardra";

        System.out.println("Is Anagram: " + isAnagram(original, target));
    }

    private static boolean isAnagram(String original, String target) {
        /*
         * Requirements:
         * - Input contains only lowercase English letters from 'a' to 'z'
         * - Character order does not matter
         * - Do not use sorting
         * - Target O(n) time and O(1) auxiliary space
         */
        if (original == null || target == null) {
            return false;
        }

        if (original.length() != target.length()) {
            return false;
        }

        int[] frequency = new int[26];

        for (int i = 0; i < original.length(); i++) {
            frequency[original.charAt(i) - 'a']++;
            frequency[target.charAt(i) - 'a']--;
        }

        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}

/*
Complexity:
Time: O(n), better than sorting's O(n log n).
Space: O(1), because the frequency array size is fixed at 26.

Note:
This works only when both strings contain lowercase letters from 'a' to 'z'.
If the input may contain uppercase letters, spaces, digits, punctuation, or
Unicode characters, this approach is not safe.
*/