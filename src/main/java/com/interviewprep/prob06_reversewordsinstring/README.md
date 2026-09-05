# Problem 06: Reverse Words in a String

This package demonstrates three Java approaches for reversing the order of words in a string while normalizing whitespace.

Input:  "  Java   Dsa   Problem  "
Output: "Problem Dsa Java"

## Files

| Variant | File name | Main idea |
|---|---|---|
| 1 | `Variant1_SplitAndReverse.java` | Split into words and append them in reverse order |
| 2 | `Variant2_ReverseScanWithoutSplit.java` | Scan from right to left and extract words directly |
| 3 | `Variant3_InPlaceCharArrayReversal.java` | Normalize a char array, reverse everything, then reverse each word |

## Requirements

- Reverse the order of words.
- Preserve the characters inside each word.
- Remove leading and trailing whitespace.
- Replace repeated whitespace with one regular space.
- Return `null` for `null` input and an empty string for blank input.

## Variant 1 - Split and reverse

**File:** `Variant1_SplitAndReverse.java`

This is the simplest and most readable approach for normal application code. It trims the input, splits it on one or more whitespace characters, and appends the words in reverse order.

### Complexity

| Metric | Complexity |
|---|---|
| Time | O(n) |
| Space | O(n) |
| Code complexity | Low |

### Best use case

Use this when `split()` is allowed and readability is the main priority.

## Variant 2 - Reverse scan without split

**File:** `Variant2_ReverseScanWithoutSplit.java`

This version avoids creating an array of words. It scans from right to left, skips whitespace, locates each word, and appends it directly to the output.

### Complexity

| Metric | Complexity |
|---|---|
| Time | O(n) |
| Working space excluding output | O(1) |
| Output space | O(n) |

### Best use case

Use this when `split()` is prohibited or when avoiding the intermediate word array is desirable.

## Variant 3 - In-place char-array reversal

**File:** `Variant3_InPlaceCharArrayReversal.java`

This approach first normalizes whitespace inside a char array. It then:

1. Reverses the normalized character sequence.
2. Reverses each individual word.

### Complexity

| Metric | Complexity |
|---|---|
| Time | O(n) |
| Working space after array creation | O(1) |
| Total space including char array and output | O(n) |

### Best use case

Use this to demonstrate the classic in-place reversal technique when mutable character storage is available.

## Comparison

| Variant | Uses `split()` | Intermediate word array | Main advantage |
|---|---:|---:|---|
| Split and reverse | Yes | Yes | Most readable |
| Reverse scan | No | No | Direct extraction with minimal working state |
| Char-array reversal | No | No | Demonstrates in-place reversal mechanics |

All three variants run in O(n) time. The best choice depends on the constraint rather than asymptotic speed.

## Key takeaway

A straightforward library solution is often the best production choice, while manual scanning and char-array reversal demonstrate deeper control over indexing, whitespace normalization, and memory usage.

Before selecting an approach, clarify whether `split()` is allowed, how whitespace should be treated, and whether the input is mutable.

---