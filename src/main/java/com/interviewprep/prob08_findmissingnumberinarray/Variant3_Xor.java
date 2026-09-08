package com.interviewprep.prob08_findmissingnumberinarray;

// Find the missing number using XOR cancellation.
public class Variant3_Xor {

    public static void main(String[] args) {
        int[] numbers = {4, 7, 3, 0, 9, 2, 1, 6, 8};

        System.out.println("Missing Number: " + findMissingNumber(numbers));
    }

    private static int findMissingNumber(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        int missingNumber = numbers.length;

        for (int index = 0; index < numbers.length; index++) {
            missingNumber ^= index;
            missingNumber ^= numbers[index];
        }

        return missingNumber;
    }
}

/*
Complexity:
Time: O(n)
Auxiliary Space: O(1)

NOTE:
    1. Optimal and not vulnerable to arithmetic overflow.
    2. How XOR works:
            x ^ x = 0
            x ^ 0 = x
    3. Every matching index and array value cancels out.
    4. The only value left is the missing number.
*/