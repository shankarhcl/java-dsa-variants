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