package com.interviewprep.prob02_palindromecheck;

// Check whether a string is a valid palindrome by ignoring spaces, punctuation, and case.
public class Variant2_IgnoreNonAlphanumeric {

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        System.out.println("Is Valid Palindrome: " + isValidPalindrome(input));
    }

    private static boolean isValidPalindrome(String input) {
        /*
         * Rules:
         * - Ignore spaces and punctuation
         * - Ignore case
         * - Maintain O(1) auxiliary space
         *
         * Note:
         * Whether an empty string should be considered a palindrome depends on the
         * problem definition. Mathematically, an empty string is generally considered
         * a palindrome, and many coding platforms expect true.
         */
        if (input == null) {
            return false;
        }

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(input.charAt(left))) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(input.charAt(right))) {
                right--;
                continue;
            }

            char leftChar = Character.toLowerCase(input.charAt(left));
            char rightChar = Character.toLowerCase(input.charAt(right));

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

/*
Complexity:
Time: O(n)
Auxiliary Space: O(1), because no extra string, array, or collection is created.
*/