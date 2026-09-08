package com.interviewprep.prob08_findmissingnumberinarray;

import java.util.Arrays;

// Find the missing number by sorting a copy and locating the first mismatch.
public class Variant1_SortingAndScan {

    public static void main(String[] args) {
        int[] numbers = {4, 7, 3, 0, 9, 2, 1, 6, 8};

        System.out.println("Missing Number: " + findMissingNumber(numbers));
    }

    private static int findMissingNumber(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        int[] sortedNumbers = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedNumbers);

        for (int expected = 0; expected < sortedNumbers.length; expected++) {
            if (sortedNumbers[expected] != expected) {
                return expected;
            }
        }

        return sortedNumbers.length;
    }
}

/*
Complexity:
Time: O(n log n), because the copied array is sorted.
Space: O(n), because a copy of the input is created.

NOTE:
Easy to understand, but less efficient than the arithmetic and XOR approaches.
*/