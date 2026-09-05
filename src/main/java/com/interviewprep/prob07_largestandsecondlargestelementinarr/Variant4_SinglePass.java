package com.interviewprep.prob07_largestandsecondlargestelementinarr;

// Finds the largest and second-largest distinct elements in a single pass.
// This is the most efficient approach for the problem, but it has a subtle edge case:
// using Integer.MIN_VALUE as a sentinel can fail when the actual second-largest value
// is also Integer.MIN_VALUE. That is why the next variant introduces a boolean guard.
public class Variant4_SinglePass {

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

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest && number < largest) {
                secondLargest = number;
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
        Time  : O(n)
        Space : O(1)

    Important Note:
        This implementation is efficient, but it has a known edge case if Integer.MIN_VALUE
        is the actual second-largest value. For example:
            int[] numbers = {Integer.MIN_VALUE, 0, Integer.MIN_VALUE};

        In that case, using Integer.MIN_VALUE as a sentinel becomes ambiguous. The next variant
        resolves this by tracking whether a valid second largest has actually been found.

    Output:
        Largest: 20
        Second Largest: 15
*/
