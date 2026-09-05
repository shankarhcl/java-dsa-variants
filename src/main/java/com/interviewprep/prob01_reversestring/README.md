##  Problem 01: Reverse a String

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