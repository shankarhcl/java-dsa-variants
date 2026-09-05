package com.interviewprep.prob07_largestandsecondlargestelementinarr;

import java.util.TreeSet;

// Finds the largest and second-largest distinct elements using a TreeSet.
// This approach is clean and readable because TreeSet automatically removes duplicates and keeps values in sorted order.
// It is a good demonstration of collection behavior, though it is not the most optimal solution for interview constraints requiring O(n).
public class Variant2_TreeSet {

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

        TreeSet<Integer> set = new TreeSet<>();

        for (int number : numbers) {
            set.add(number);
        }

        if (set.size() < 2) {
            throw new IllegalArgumentException(
                    "Array does not contain a distinct second largest element"
            );
        }

        int largest = set.last();
        int secondLargest = set.lower(largest);

        return new int[] {largest, secondLargest};
    }
}

/*
    Complexity:
        Time  : O(n log n)
        Space : O(n)

    Note:
        1. Each TreeSet insertion is O(log n).
        2. This is a neat and expressive solution, but not optimal if the interviewer expects O(n) time.

    Output:
        Largest: 20
        Second Largest: 15
*/
