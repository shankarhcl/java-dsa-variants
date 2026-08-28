# Java DSA Variants

Classic coding-interview problems solved in Java — not one solution each, but **every approach worth knowing**, with complexity analysis and the reasoning for when you'd pick one over another.

The goal isn't a wall of accepted solutions. It's being able to answer the follow-up question: *"why this one?"*

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

## Featured breakdown — Problem 01: Reverse a String

Three solutions. All three print `semaJ`. Only one is the right answer, and which one depends entirely on the constraint you were given.

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

## Running the code

Any file compiles and runs on its own — no build tool, no dependencies.

```bash
cd src
javac com/interviewprep/prob01_reversestring/Variant3_StringBuilder.java
java com.interviewprep.prob01_reversestring.Variant3_StringBuilder
```

Or open the repo in IntelliJ IDEA / Eclipse / VS Code and run any `main()` directly.

**Requires:** JDK 8 or later.

---

## Feedback

Spotted a cleaner approach, a missing edge case, or a complexity claim that doesn't hold? Open an issue or a pull request — corrections are the most useful thing anyone can contribute here.

---

## License

Released under the [MIT License](LICENSE). Use it, fork it, learn from it.
