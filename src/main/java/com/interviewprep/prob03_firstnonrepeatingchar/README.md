# Problem 03: First Non-Repeating Character in a String

Given a string, find the first character that does not repeat.
If no such character exists, return the null character `\0`.
Examples:

| Input | Output | Reason |
| --- | --- | --- |
| `engineeringbranch` | `g` | `g` is the first character that appears once |
| `aabbcc` | `\0` | No non-repeating character exists |
| `swiss` | `w` | `w` is the first character that appears once |
| `leetcode` | `l` | `l` appears once and comes first |

## Files

| Variant | File name | What it demonstrates |
| --- | --- | --- |
| 1 | `Variant1_FrequencyArray.java` | Uses a fixed-size ASCII frequency array without Map |
| 2 | `Variant2_LinkedHashMap.java` | Uses insertion order to find the first non-repeating character cleanly |
| 3 | `Variant3_HashMapWithSecondPass.java` | Uses HashMap for frequency and scans the original string again for order |

## Variant 1 — Frequency array

**File:** `Variant1_FrequencyArray.java`

This solution avoids `Map` and uses a fixed-size array of length `256` to count ASCII character frequencies.

### Approach

1. Return `\0` if the input is `null` or empty.
2. Create an integer array of size `256`.
3. Count the frequency of each character.
4. Scan the original string again.
5. Return the first character whose frequency is `1`.

### Complexity

| Metric | Complexity |
| --- | --- |
| Time | O(n) |
| Space | O(1), because the array size is fixed at 256 |

### When to use

Use this when the input is limited to ASCII characters and the interviewer asks you to avoid `Map`.

## Variant 2 — LinkedHashMap

**File:** `Variant2_LinkedHashMap.java`

This solution uses `LinkedHashMap`, which preserves insertion order.

### Approach

1. Return `\0` if the input is `null` or empty.
2. Store each character and its frequency in a `LinkedHashMap`.
3. Iterate through the map entries.
4. Return the first character whose frequency is `1`.

### Complexity

| Metric | Complexity |
| --- | --- |
| Time | O(n) |
| Space | O(k), where k is the number of distinct characters |

In the worst case, when all characters are unique, space becomes O(n).

### When to use

Use this when you want a clean, readable solution and preserving insertion order is useful.

## Variant 3 — HashMap with second pass

**File:** `Variant3_HashMapWithSecondPass.java`

This solution uses `HashMap` for frequency counting, then scans the original string again to preserve the original order.

### Why a second pass is needed

`HashMap` does not guarantee iteration order. So if we iterate directly over the map, we may not get the first non-repeating character from the original string.

That is why this variant first counts frequencies using `HashMap`, then loops through the original string again.

### Approach

1. Return `\0` if the input is `null` or empty.
2. Store each character and its frequency in a `HashMap`.
3. Scan the original string from left to right.
4. Return the first character whose frequency is `1`.

### Complexity

| Metric | Complexity |
| --- | --- |
| Time | O(n) |
| Space | O(k), where k is the number of distinct characters |

In the worst case, when all characters are unique, space becomes O(n).

---

## Key learning

All three variants solve the same problem in O(n) time, but they make different trade-offs.

| Variant | Data structure | Preserves order naturally? | Best use case |
| --- | --- | --- | --- |
| 1 | Fixed array | No, so we scan the string again | ASCII-only input without Map |
| 2 | LinkedHashMap | Yes | Cleanest map-based solution |
| 3 | HashMap | No, so we scan the string again | Common and practical interview solution |

The main learning is that **frequency alone is not enough**. Since the question asks for the *first* non-repeating character, we must respect the original order of the string.

---