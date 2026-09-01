package com.interviewprep.javadsavariants.prob01_reversestring;

// Reverse String without using StringBuilder.reverse() or any library reverse function
public class Variant1_TwoPointerSwap {
    public static void main(String[] args) {
        String name = "myfirstprogram";
        System.out.println("Reversed String: " + reverseString(name));
    }

    private static String reverseString(String name) {
        if (name == null || name.length() == 0) {
            return "";
        }

        char[] charArray = name.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
}

/*
Complexity:
Time: O(n)
Space: O(n), because toCharArray() creates a character array and new String(chars) creates the result.
*/
