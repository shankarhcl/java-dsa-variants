# Problem 04: Valid Anagram

Given two strings, determine whether they are anagrams.
Two strings are anagrams if they contain exactly the same characters with the same frequencies.
Examples:

| Original | Target | Output | Reason |
| --- | --- | --- | --- |
| `listen` | `silent` | `true` | Same letters with same counts |
| `radar` | `ardra` | `true` | Same characters with same frequencies |
| `hello` | `world` | `false` | Different characters |
| `Debit Card` | `Bad Credit` | `true` | Same letters after ignoring spaces and case |

## Files

| Variant | File name | What it demonstrates |
| --- | --- | --- |
| 1 | `Variant1_Sorting.java` | Simple sorting-based comparison |
| 2 | `Variant2_FrequencyArrayLowercase.java` | O(n) solution for lowercase `a-z` strings |
| 3 | `Variant3_HashMapNormalized.java` | Handles mixed case, spaces, digits, punctuation, and wider character sets |

## Variant 1 — Sorting

**File:** `Variant1_Sorting.java`

This is the easiest way to understand the problem. If two strings are anagrams, sorting both strings should produce the same result.

### Approach

1. Return `false` if either string is `null`.
2. Return `false` if both strings have different lengths.
3. Convert both strings to character arrays.
4. Sort both arrays.
5. Compare the sorted arrays.

### Complexity

| Metric | Complexity |
| --- | --- |
| Time | O(n log n) |
| Space | O(n) |

### When to use

Use this when you want the simplest solution to explain. It is correct, but not optimal because sorting costs O(n log n).

## Variant 2 — Frequency array for lowercase letters

**File:** `Variant2_FrequencyArrayLowercase.java`

This is the best solution when the input is guaranteed to contain only lowercase English letters from `a` to `z`.

### Approach

1. Return `false` if either string is `null`.
2. Return `false` if both strings have different lengths.
3. Create an integer array of size `26`.
4. Increment the count for each character in the first string.
5. Decrement the count for each character in the second string.
6. If all counts are zero, both strings are anagrams.

### Complexity

| Metric | Complexity |
| --- | --- |
| Time | O(n) |
| Space | O(1), because the array size is fixed at 26 |

### Important note

This approach works only when the input is limited to lowercase `a-z`. If uppercase letters, spaces, digits, punctuation, or Unicode characters are allowed, this approach can fail or throw an indexing error.

## Variant 3 — HashMap with normalization

**File:** `Variant3_HashMapNormalized.java`

This solution is useful when the input is not limited to lowercase letters.
After ignoring spaces and case, both contain the same letters.

### Approach

1. Return `false` if either string is `null`.
2. Count only letters and digits from the first string.
3. Convert characters to lowercase before counting.
4. Decrease the count while scanning the second string.
5. Remove characters whose count becomes zero.
6. Track valid character counts from both strings.
7. Return `true` only if both valid counts match and the map is empty.

### Complexity

| Metric | Complexity |
| --- | --- |
| Time | O(n) |
| Space | O(k), where k is the number of distinct normalized characters |

In the worst case, space becomes O(n).

## Key learning

All three variants solve the same problem, but the best solution depends on the input constraints.

| Variant | Best when | Time | Space |
| --- | --- | --- | --- |
| Sorting | You want the simplest explanation | O(n log n) | O(n) |
| Frequency array | Input is only lowercase `a-z` | O(n) | O(1) |
| HashMap | Input can contain mixed characters | O(n) | O(k) |

The main takeaway: before choosing a solution, ask about the **character set** and **normalization rules**. A solution that is perfect for lowercase `a-z` may not be safe for real-world input.

---