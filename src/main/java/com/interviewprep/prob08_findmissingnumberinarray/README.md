# Problem 08: Find the Missing Number in an Array

This package demonstrates three Java approaches for finding the single missing number from an array containing distinct values in the range `0` to `n`.

Input:  {4, 7, 3, 0, 9, 2, 1, 6, 8}
Output: Missing Number: 5

For an array of length `n`, the complete range should contain `n + 1` values: `0, 1, 2, ..., n`. Exactly one value is missing.

## Files

| Variant | File name | Main idea |
|---|---|---|
| 1 | `Variant1_SortingAndScan.java` | Sort a copy and find the first index-value mismatch |
| 2 | `Variant2_ArithmeticSum.java` | Subtract the actual sum from the expected range sum |
| 3 | `Variant3_Xor.java` | Cancel matching indices and values with XOR |

## Assumptions

- The input array is not `null`.
- It contains `n` distinct integers.
- Every value lies in the inclusive range `0` to `n`.
- Exactly one number from that range is missing.
- The empty array is valid and represents a missing value of `0`.

The implementations solve the problem under this contract. Validating every assumption would require additional tracking or sorting and would change the implementation trade-offs.

## Variant 1 - Sorting and scanning

**File:** `Variant1_SortingAndScan.java`

This variant sorts a copy of the input and compares each value with its expected index. The first mismatch is the missing number. If every position matches, `n` is missing.

### Complexity

| Metric | Complexity |
|---|---|
| Time | O(n log n) |
| Space | O(n) for the copied array |

### Best use case

Use this as the most intuitive explanation when modifying the original array is undesirable and optimal complexity is not required.

---

## Variant 2 - Arithmetic sum

**File:** `Variant2_ArithmeticSum.java`

The expected sum of values from `0` through `n` is:
        Sum = n * (n + 1) / 2

Subtracting every array value from that expected sum leaves the missing number.

The implementation uses `long` during the calculation to reduce integer-overflow risk, then returns the result as an `int` because the missing number belongs to the input's integer range.

### Complexity

| Metric | Complexity |
|---|---|
| Time | O(n) |
| Auxiliary space | O(1) |

### Best use case

Use this when the mathematical relationship is welcome and the numeric range is understood.

## Variant 3 - XOR

**File:** `Variant3_Xor.java`

This variant relies on the following XOR properties:
    x ^ x = 0
    x ^ 0 = x

XORing all expected values from `0` to `n` with every value in the array cancels all matching values. The remaining value is the missing number.

### Complexity

| Metric | Complexity |
|---|---|
| Time | O(n) |
| Auxiliary space | O(1) |

### Best use case

Use this when constant auxiliary space and overflow-free arithmetic are priorities. It is often the strongest interview solution once clearly explained.

## Comparison

| Variant | Time | Auxiliary space | Modifies input? | Main trade-off |
|---|---:|---:|---:|---|
| Sorting and scan | O(n log n) | O(n) | No | Easiest to visualize, but slower |
| Arithmetic sum | O(n) | O(1) | No | Concise, but arithmetic needs overflow awareness |
| XOR | O(n) | O(1) | No | Optimal and overflow-safe, but less intuitive initially |

## Key takeaway

All three approaches return the same result, but they reveal different problem-solving skills:

- Sorting turns the problem into an order check.
- Arithmetic uses the expected total of a known range.
- XOR uses cancellation to isolate the missing value.

The best production choice is usually the clearest correct solution for the documented constraints. In an interview, explaining why XOR works is as important as writing it.

## Edge cases

| Input | Missing number |
|---|---:|
| `[]` | `0` |
| `[0]` | `1` |
| `[1]` | `0` |
| `[0, 1, 2, 3]` | `4` |
| `[4, 2, 1, 0]` | `3` |

---