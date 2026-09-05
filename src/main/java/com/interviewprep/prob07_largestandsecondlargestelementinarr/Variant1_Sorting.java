package com.interviewprep.prob07_largestandsecondlargestelementinarr;

import java.util.Arrays;

// Finds the largest and second-largest elements by sorting the array.
// This is the simplest approach, but not the preferred interview solution
// because it is not optimized for linear time.
public class Variant1_Sorting {

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

        int[] sortedCopy = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedCopy);

        int largest = sortedCopy[sortedCopy.length - 1];
        int secondLargest = Integer.MIN_VALUE;

        for (int i = sortedCopy.length - 2; i >= 0; i--) {
            if (sortedCopy[i] != largest) {
                secondLargest = sortedCopy[i];
                break;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "Array does not contain a distinct second largest element"
            );
        }

        return new int[] {largest, secondLargest};
    }
}

/*
    Complexity:
        Time  : O(n log n)
        Space : O(n), because we copied the array before sorting.

    Note:
        1. If modifying the original array is allowed, the auxiliary space can be O(1),
           but the time complexity remains O(n log n).
        2. Reject this approach if the interviewer asks for O(n).

    Output:
        Largest: 20
        Second Largest: 15
*/
