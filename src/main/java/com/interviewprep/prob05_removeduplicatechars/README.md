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