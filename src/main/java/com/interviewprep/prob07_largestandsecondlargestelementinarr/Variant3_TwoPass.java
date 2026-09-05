package com.interviewprep.prob07_largestandsecondlargestelementinarr;

// Finds the largest and second-largest distinct elements using a two-pass approach.
// First, we identify the largest value. Then we scan the array again to find the largest value smaller than that maximum.
// This is optimized solution but we can do better in terms of number of traversals in next variant.
public class Variant3_TwoPass {

    public static void main(String[] args) {
        int[] numbers = {10, 5, 20, 8, 20, 15};
        int[] result = findLargestAndSecondLargest(numbers);

        System.out.println("Largest: " + result[0]);
        System.out.println("Second Largest: " + result[1]);
    }

    private static int[] findLargestAndSecondLargest(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements");
        }

        int largest = numbers[0];

        // First pass: find the maximum value.
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }

        int secondLargest = Integer.MIN_VALUE;
        boolean foundSecondLargest = false;

        // Second pass: find the largest value smaller than the maximum.
        for (int number : numbers) {
            if (number < largest && number > secondLargest) {
                secondLargest = number;
                foundSecondLargest = true;
            }
        }

        if (!foundSecondLargest) {
            throw new IllegalArgumentException(
                    "Array does not contain a distinct second largest element"
            );
        }

        return new int[] {largest, secondLargest};
    }
}

/*
    Complexity:
        Time  : O(n)
        Space : O(1)

    Note:
        This is a clean and efficient solution that runs in linear time with constant space.

    Output:
        Largest: 20
        Second Largest: 15
*/
