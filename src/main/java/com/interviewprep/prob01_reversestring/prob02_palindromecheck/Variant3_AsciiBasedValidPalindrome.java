package com.interviewprep.prob02_palindromecheck;

// Check whether a string is a valid palindrome using manual ASCII checks.
public class Variant3_AsciiBasedValidPalindrome {

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        System.out.println("Is Valid Palindrome: " + isValidPalindrome(input));
    }

    private static boolean isValidPalindrome(String input) {
        /*
         * Rules:
         * - Ignore spaces and punctuation
         * - Ignore case
         * - Do not use Character.isLetterOrDigit()
         * - Do not use Character.toLowerCase()
         * - Maintain O(1) auxiliary space
         */
        if (input == null) {
            return false;
        }

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            while (left < right && !isAsciiLetterOrDigit(input.charAt(left))) {
                left++;
            }

            while (left < right && !isAsciiLetterOrDigit(input.charAt(right))) {
                right--;
            }

            char leftChar = toAsciiLowerCase(input.charAt(left));
            char rightChar = toAsciiLowerCase(input.charAt(right));

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean isAsciiLetterOrDigit(char ch) {
        return isAsciiUppercase(ch) || isAsciiLowercase(ch) || isAsciiDigit(ch);
    }

    private static boolean isAsciiUppercase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    private static boolean isAsciiLowercase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    private static boolean isAsciiDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private static char toAsciiLowerCase(char ch) {
        if (isAsciiUppercase(ch)) {
            return (char) (ch + ('a' - 'A'));
        }

        return ch;
    }
}

/*
Complexity:
Time: O(n)
Auxiliary Space: O(1), because no extra string, array, or collection is created.

Note:
This solution is intentionally ASCII-focused. It works well for common interview
inputs containing English letters, digits, spaces, and punctuation. It is not a
full Unicode-aware solution.
*/