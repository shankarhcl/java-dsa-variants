package com.interviewprep.prob04_validanagrams;

import java.util.Arrays;

// Check whether two strings are anagrams using sorting.
public class Variant1_Sorting {

    public static void main(String[] args) {
        String original = "listen";
        String target = "silent";

        System.out.println("Is Anagram: " + isAnagram(original, target));
    }

    private static boolean isAnagram(String original, String target) {
        /*
         * Note:
         * Empty strings are considered anagrams because both contain the same
         * characters with the same frequencies: nothing.
         */
        if (original == null || target == null) {
            return false;
        }

        if (original.length() != target.length()) {
            return false;
        }

        char[] originalChars = original.toCharArray();
        char[] targetChars = target.toCharArray();

        Arrays.sort(originalChars);
        Arrays.sort(targetChars);

        return Arrays.equals(originalChars, targetChars);
    }
}

/*
Complexity:
Time: O(n log n), because both character arrays are sorted.
Space: O(n), because both strings are converted into character arrays.
*/