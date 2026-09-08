package com.interviewprep.prob08_findmissingnumberinarray;

// Find the missing number using the expected sum of values from 0 to n.
public class Variant2_ArithmeticSum {

    public static void main(String[] args) {
        int[] numbers = {4, 7, 3, 0, 9, 2, 1, 6, 8};

        System.out.println("Missing Number: " + findMissingNumber(numbers));
    }

    private static int findMissingNumber(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        long numberCount = numbers.length;
        long difference = numberCount * (numberCount + 1) / 2;

        for (int number : numbers) {
            difference -= number;
        }

        return (int) difference;
    }
}

/*
Complexity:
Time: O(n)
Auxiliary Space: O(1)

Note:
The calculation uses long to reduce the risk of integer overflow.
*/
