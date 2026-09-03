# Java DSA Variants

Classic coding-interview problems solved in Java — not one solution each, but **every approach worth knowing**, with complexity analysis and the reasoning for when you'd pick one over another.
The goal isn't a wall of accepted solutions. It's being able to answer the follow-up question: *"why this one?"*

---

## Feedback

Spotted a cleaner approach, a missing edge case, or a complexity claim that doesn't hold? Open an issue or a pull request — corrections are the most useful thing anyone can contribute here.

---

## License

Released under the [MIT License](LICENSE). Use it, fork it, learn from it.

---

**Requires:** JDK 8 or later.

---

## How this repo is organised

Each problem lives in its own package, numbered in the order I worked through it. Each approach is a separate runnable class.

```
com/
    └── interviewprep/
        └── prob01_reversestring/
            ├── Variant1_TwoPointerSwap.java
            ├── Variant2_StringConcatenation.java
            └── Variant3_StringBuilder.java
        └── prob02_palindromecheck/
            ├── Variant1_TwoPointerCheck.java
            ├── Variant2_ReverseStringCheck.java
            └── Variant3_RecursiveCheck.java
```

**Naming convention**

| Element | Pattern | Example |
| --- | --- | --- |
| Package | `probNN_problemname` | `prob01_reversestring` |
| Class | `VariantN_ApproachName` | `Variant2_StringConcatenation` |

The number is the order you'd walk an interviewer through the approaches; the suffix names the technique, so the file tree alone tells you what each version does.

**Every file contains**

- A one-line comment stating the constraint the variant is solving under
- A self-contained `main()` so any file runs on its own
- Null and empty-input guards
- A closing comment block with time complexity, space complexity, and a verdict — recommended, or why not

---

## Problem index

| # | Problem | Variants | Key concept |
| --- | --- | --- | --- |
| 01 | [Reverse a String](src/com/interviewprep/prob01_reversestring) | 3 | String immutability, two-pointer swap, `StringBuilder` |

*(Index grows as problems are added.)*

---

## Running the code

Any file compiles and runs on its own — no build tool, no dependencies.
Open the repo in IntelliJ IDEA / Eclipse / VS Code and run any `main()` directly.

---

## Featured breakdown — Problem 01: Reverse a String

### Variant 1 — Two-pointer swap

Convert to a char array, swap from both ends, walk inward until the pointers meet.

- **Time:** O(n) · **Space:** O(n) — `toCharArray()` allocates the array, `new String(chars)` allocates the result
- **Use when:** the interviewer says *"no library functions."* Demonstrates you can manipulate the underlying characters directly rather than reaching for an API.

### Variant 2 — String concatenation

`result = result + name.charAt(i)` inside a reverse-order loop.

- **Time:** O(n²) worst case · **Space:** O(n²) in total allocations
- **Verdict:** ❌ Not recommended. The logic is correct and the syntax is clean, which is exactly what makes it dangerous. Java Strings are immutable, so every `+` allocates a new String and copies everything accumulated so far. Correct output, silent quadratic cost.

### Variant 3 — StringBuilder

`new StringBuilder(name).reverse().toString()`.

- **Time:** O(n) · **Space:** O(n) — `StringBuilder`'s internal character buffer
- **Verdict:** ✅ Recommended. Mutable buffer, no intermediate garbage, one line. This is what belongs in production code when no constraint says otherwise.

### The part that actually matters

Variants 1 and 3 have **identical complexity** — `StringBuilder.reverse()` performs that same two-pointer swap internally. The difference between them isn't performance, it's intent:

- Variant 1 proves you understand the mechanism.
- Variant 3 proves you know not to rebuild what the JDK already ships.

**Edge case worth knowing:** the manual char-swap breaks on emoji and other non-BMP characters, because it reverses the two halves of a surrogate pair and produces invalid text. `StringBuilder.reverse()` detects surrogate pairs and keeps them intact. Bring this up before the interviewer does.

---

# Problem 02: Given a string, determine whether it is a palindrome.
A palindrome reads the same forward and backward.
Examples:

| Input | Output | Reason |
| --- | --- | --- |
| `madam` | `true` | Same forward and backward |
| `James` | `false` | Characters do not match from both ends |
| `A man, a plan, a canal: Panama` | `true` | After ignoring spaces, punctuation, and case, it becomes a palindrome |
| `race a car` | `false` | Valid characters do not form a palindrome |

## Files

| Variant | File name | What it demonstrates |
| --- | --- | --- |
| 1 | `Variant1_TwoPointerBasicPalindrome.java` | Basic palindrome check using two pointers |
| 2 | `Variant2_IgnoreNonAlphanumeric.java` | Valid palindrome check while ignoring spaces, punctuation, and case |
| 3 | `Variant3_AsciiBasedValidPalindrome.java` | Same valid palindrome logic, but with manual ASCII checks instead of `Character` helpers |

## Variant 1 — Basic two-pointer palindrome

**File:** `Variant1_TwoPointerBasicPalindrome.java`

This is the clean-input version. It compares characters from both ends and moves toward the center.

### Approach

1. Return `false` if the input is `null`.
2. Start one pointer at the beginning and one at the end.
3. Compare both characters.
4. If they differ, return `false`.
5. Keep moving inward until the pointers meet.
6. Return `true`.

### Complexity

| Metric | Complexity |
| --- | --- |
| Time | O(n) |
| Auxiliary space | O(1) |

### When to use

Use this when the input is expected to contain only the actual characters that should be compared.

## Variant 2 — Ignore spaces, punctuation, and case

**File:** `Variant2_IgnoreNonAlphanumeric.java`

This is closer to the common interview version of the problem: check whether a string is a valid palindrome after ignoring non-alphanumeric characters and case.
Example: A man, a plan, a canal: Panama
After filtering comparison rules, this becomes: amanaplanacanalpanama
So the answer is `true`.

### Approach

1. Return `false` if the input is `null`.
2. Use two pointers from both ends.
3. Skip characters that are not letters or digits.
4. Convert both comparable characters to lowercase.
5. If the normalized characters differ, return `false`.
6. Continue until the pointers cross.

### Complexity

| Metric | Complexity |
| --- | --- |
| Time | O(n) |
| Auxiliary space | O(1) |

### Why this is good

This avoids creating a cleaned-up copy of the string. Instead of building another string like `amanaplanacanalpanama`, it compares characters directly while scanning.

## Variant 3 — ASCII-based valid palindrome

**File:** `Variant3_AsciiBasedValidPalindrome.java`

This variant follows the same rules as Variant 2, but does not use:

- `Character.isLetterOrDigit()`
- `Character.toLowerCase()`

Instead, it implements both checks manually using ASCII ranges.

### Approach

1. Return `false` if the input is `null`.
2. Use two pointers from both ends.
3. Skip characters that are not ASCII letters or digits.
4. Convert uppercase ASCII letters to lowercase manually.
5. Compare normalized characters.
6. Return `false` on mismatch; otherwise continue scanning.

### Complexity

| Metric | Complexity |
| --- | --- |
| Time | O(n) |
| Auxiliary space | O(1) |

### Important note

This version is intentionally ASCII-focused. It works well for common interview inputs containing English letters, digits, spaces, and punctuation. It is not a full Unicode-aware solution.

## Key learning

The core pattern across all three variants is the same: **two pointers**.

What changes is how much normalization is needed before comparison.

| Variant | Handles punctuation? | Handles case? | Uses helper APIs? | Best use case |
| --- | --- | --- | --- | --- |
| 1 | No | No | No | Basic palindrome check |
| 2 | Yes | Yes | Yes | Practical interview solution |
| 3 | Yes | Yes | No `Character` helpers | Constraint-based interview follow-up |

The real takeaway: an interview problem often starts simple, then adds constraints. A strong answer is not just the final code — it is knowing how to adapt the same pattern when the rules change.

---

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

# Problem 05:  Remove Duplicate Characters from a String

This package demonstrates three ways to remove duplicate characters from a Java String while preserving the first occurrence and original order.

## Files

| Variant | File name | Main idea |
|---|---|---|
| 1 | `Variant1_StringConcatenation.java` | Uses only String operations, but takes quadratic time |
| 2 | `Variant2_AsciiBooleanArray.java` | Uses a fixed lookup array for ASCII input |
| 3 | `Variant3_Utf16BooleanArray.java` | Supports every Java `char` value using a 65,536-entry lookup array |

## Variant 1 - String concatenation

**File:** `Variant1_StringConcatenation.java`

For each character, this approach uses `indexOf()` to check whether the character already exists in the result. If it does not, the character is appended using String concatenation.

### Complexity

| Metric | Complexity |
|---|---|
| Time | O(n²) |
| Peak space including output | O(n) |
| Total temporary allocation | Can reach O(n²) |

Both `indexOf()` and repeated concatenation contribute to the quadratic cost. Java Strings are immutable, so every successful concatenation creates another String.

### When it is useful

This variant is valuable for explaining why an O(n) solution is not realistic when all additional tracking structures and mutable output buffers are prohibited.

## Variant 2 - ASCII boolean array

**File:** `Variant2_AsciiBooleanArray.java`

This approach tracks characters with a fixed `boolean[256]` array and builds the output with `StringBuilder`.

### Complexity

| Metric | Complexity |
|---|---|
| Time | O(n) |
| Tracking space | O(1) |
| Output space | O(n) |

The lookup array has a constant size, and every input character is processed once.

### Constraint

This variant accepts only ASCII characters, with values from 0 to 255. It validates that assumption and rejects unsupported input instead of failing with an unclear array-index error.

## Variant 3 - UTF-16 code-unit boolean array

**File:** `Variant3_Utf16BooleanArray.java`

This approach uses one lookup entry for every possible Java `char` value:

### Complexity

| Metric | Complexity |
|---|---|
| Time | O(n) |
| Tracking space | O(1), with respect to input length |
| Output space | O(n) |

The array always contains 65,536 boolean entries, regardless of input length.

### Unicode clarification

This solution covers all individual Java `char` values, which are UTF-16 code units. It is not fully Unicode code-point-aware: supplementary characters, including many emoji, consist of surrogate pairs and are processed as two units.

A fully code-point-aware implementation would iterate with `codePoints()` or `Character.codePointAt()` and track integer code points, usually with a `Set<Integer>`.

---

## Comparison

| Variant | Time | Tracking structure | Character support | Recommended use |
|---|---:|---|---|---|
| String concatenation | O(n²) | Result String itself | Java `char` values | Constraint discussion only |
| ASCII boolean array | O(n) | `boolean[256]` | ASCII | Best for ASCII-only input |
| UTF-16 boolean array | O(n) | `boolean[65,536]` | All Java `char` values | Broad BMP/code-unit input |

## Key takeaway

The optimal implementation depends on the **character-domain constraint**:

- If input is guaranteed to be ASCII, a 256-entry array is compact and fast.
- If every Java `char` value must be supported, a 65,536-entry array offers constant-time lookup at a higher fixed memory cost.
- If full Unicode code-point behavior is required, neither boolean-array variant is sufficient by itself.

The algorithm is straightforward once the contract is precise: scan left to right, record what has been seen, and append only the first occurrence.

---