package com.interviewprep.prob02_palindromecheck;

// Check whether a clean string is a palindrome using the two-pointer approach.
public class Variant1_TwoPointerBasicPalindrome {

    public static void main(String[] args) {
        String input = "madam";
        System.out.println("Is Palindrome: " + isPalindrome(input));
    }

    private static boolean isPalindrome(String input) {
        /*
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
            if (input.charAt(left) != input.charAt(right)) {
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