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
            └── README.md
            └── ...
        └── prob02_palindromecheck/
            ├── Variant1_TwoPointerCheck.java
            ├── Variant2_ReverseStringCheck.java
            └── Variant3_RecursiveCheck.java
            └── README.md
            └── ...
        └── ...
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