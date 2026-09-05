package com.interviewprep.prob07_largestandsecondlargestelementinarr;

// Finds the largest and second-largest distinct elements in a single pass.
// This is the most efficient and interview-friendly version of the solution:
// we maintain two tracking values while scanning the array only once.
public class Variant5_SinglePass {

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
        int secondLargest = Integer.MIN_VALUE;
        boolean foundSecondLargest = false;

        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];

            if (current > largest) {
                secondLargest = largest;
                largest = current;
                foundSecondLargest = true;
            } else if (current < largest && (!foundSecondLargest || current > secondLargest)) {
                secondLargest = current;
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

    Interview Note:
        We maintain two values while scanning the array once.
        - largest stores the maximum seen so far.
        - secondLargest stores the largest value strictly smaller than largest.

        If a new maximum is found, the previous maximum becomes the second largest.
        Otherwise, if the current value is smaller than the largest but greater than the
        current second largest, we update the second-largest value.

    Output:
        Largest: 20
        Second Largest: 15
*/
