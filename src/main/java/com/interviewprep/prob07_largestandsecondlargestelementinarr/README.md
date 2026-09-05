# Problem 07: Largest and Second-Largest Element in an Array

This package demonstrates five Java approaches for finding the largest and second-largest **distinct** elements in an integer array.

    Input:
        {10, 5, 20, 8, 20, 15}
    Output:
        Largest: 20
        Second Largest: 15

## Files

| Variant | File name                  | Main idea                                                              |
| ------- | -------------------------- | ---------------------------------------------------------------------- |
| 1       | `Variant1_Sorting.java`    | Sort a copy of the array and identify the two largest distinct values  |
| 2       | `Variant2_TreeSet.java`    | Use `TreeSet` to remove duplicates and maintain sorted order           |
| 3       | `Variant3_TwoPass.java`    | Find the largest first, then find the largest value smaller than it    |
| 4       | `Variant4_SinglePass.java` | Track largest and second-largest values in one traversal               |
| 5       | `Variant5_SinglePass.java` | Single-pass solution with explicit state to handle sentinel edge cases |

## Requirements

* Find the largest element.
* Find the second-largest **distinct** element.
* Duplicate maximum values should not be treated as the second largest.
* Do not modify the original array unnecessarily.
* Handle negative numbers correctly.
* Handle arrays without a distinct second-largest element.
* Handle `Integer.MIN_VALUE` correctly.
* Reject `null` arrays and arrays containing fewer than two elements.

## Variant 1 - Sorting

**File:** `Variant1_Sorting.java`

This is the simplest approach. A copy of the array is sorted, after which the largest element and the next distinct value are identified.

### Complexity

| Metric | Complexity |
| ------ | ---------- |
| Time   | O(n log n) |
| Space  | O(n)       |

### Best use case

Use this when simplicity is more important than optimal complexity and modifying the original array is undesirable.

### Limitation

Sorting performs more work than necessary because the problem only requires identifying two values, not ordering the entire array.

## Variant 2 - TreeSet

**File:** `Variant2_TreeSet.java`

This approach uses `TreeSet`, which automatically removes duplicate values and maintains elements in sorted order.

The largest value is obtained using `last()`, while the second-largest distinct value is obtained using `lower()`.

### Complexity

| Metric | Complexity |
| ------ | ---------- |
| Time   | O(n log n) |
| Space  | O(n)       |

### Best use case

Use this when clean collection-based code and automatic duplicate handling are priorities.

### Limitation

The ordering provided by `TreeSet` is unnecessary for this problem, making it less efficient than a linear scan.

## Variant 3 - Two-Pass Traversal

**File:** `Variant3_TwoPass.java`

The first traversal identifies the largest element.

The second traversal finds the largest value that is strictly smaller than the maximum.

### Complexity

| Metric | Complexity |
| ------ | ---------- |
| Time   | O(n)       |
| Space  | O(1)       |

### Best use case

Use this when you want a simple linear-time solution that is easy to reason about and avoids collection overhead.

### Advantage

It avoids sorting and additional data structures while remaining straightforward to implement.

## Variant 4 - Single-Pass with Sentinel

**File:** `Variant4_SinglePass.java`

This approach tracks both values during a single traversal.

When a new largest value is found, the previous largest becomes the second largest.

### Complexity

| Metric | Complexity |
| ------ | ---------- |
| Time   | O(n)       |
| Space  | O(1)       |

### Important limitation

The implementation uses `Integer.MIN_VALUE` as a sentinel for `secondLargest`.

This creates an ambiguity when `Integer.MIN_VALUE` is itself a legitimate second-largest value.

For example:

```java
{Integer.MIN_VALUE, 0, Integer.MIN_VALUE}
```

The algorithm is asymptotically optimal, but the sentinel-based state makes this edge case problematic.

## Variant 5 - Single-Pass with Explicit State

**File:** `Variant5_SinglePass.java`

This is the recommended interview solution.

The algorithm maintains:

* `largest` - the largest value encountered so far.
* `secondLargest` - the largest value strictly smaller than `largest`.
* `foundSecondLargest` - explicitly tracks whether a valid second-largest value has been found.

This avoids relying solely on `Integer.MIN_VALUE` as an indicator of whether a value exists.

### Complexity

| Metric | Complexity |
| ------ | ---------- |
| Time   | O(n)       |
| Space  | O(1)       |

### Best use case

Use this when the interviewer expects an optimal single-pass solution with correct handling of boundary conditions.

## Comparison

| Variant                         |       Time | Space | Main advantage                              |
| ------------------------------- | ---------: | ----: | ------------------------------------------- |
| Sorting                         | O(n log n) |  O(n) | Simplest approach                           |
| TreeSet                         | O(n log n) |  O(n) | Automatic sorting and duplicate removal     |
| Two-Pass                        |       O(n) |  O(1) | Simple optimal solution                     |
| Single-Pass with Sentinel       |       O(n) |  O(1) | One traversal, but has a sentinel edge case |
| Single-Pass with Explicit State |       O(n) |  O(1) | Optimal and robust                          |

## Important Edge Cases

The implementation should be tested against:

{10, 5, 20, 8, 15}
→ Largest: 20
→ Second Largest: 15

{10, 20, 20, 5}
→ Largest: 20
→ Second Largest: 10

{-5, -2, -10, -1}
→ Largest: -1
→ Second Largest: -2

{10, 10, 10}
→ No distinct second-largest element

{10}
→ Invalid input

{Integer.MIN_VALUE, 0}
→ Largest: 0
→ Second Largest: Integer.MIN_VALUE

## Key Takeaway

This problem demonstrates an important progression in algorithmic problem solving:

**O(n log n) → O(n) → O(n) with fewer traversals → O(n) with robust edge-case handling.**

The most important lesson is that achieving optimal Big-O complexity is not enough. A production-quality or interview-quality solution must also handle duplicates, negative values, boundary values, and invalid input correctly.

For interview purposes, `Variant5_SinglePass.java` is the preferred solution because it provides **O(n) time, O(1) space, a single traversal, and explicit state management for edge cases**.

---