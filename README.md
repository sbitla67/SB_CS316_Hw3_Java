# CS316 — Enumeration Types: Java
**Author:** Shouri Bitla
**Course:** CS316: Programming Languages
**Language:** Java

---

## AI Disclosure

AI assistance (Claude by Anthropic) was used for **research purposes only** — specifically to understand the landscape of Java enum features, identify relevant edge cases, and outline the type of program that would best demonstrate each concept. All source code was written by me and is explained in full during the code demonstration video.

---

## Sources

* https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
* https://www.youtube.com/watch?v=wq9SJb8VeyM
* https://www.w3schools.com/java/java_enums.asp
* https://www.geeksforgeeks.org/java/enum-in-java/

---

## Project Overview

This project contains 5 Java programs that demonstrate how enumeration types work in Java — covering basic declaration, control flow, extended behavior, iteration/introspection, and a real-world applied scenario.

---

## Programs

### Program 1 — Enumeration Basics (`p1.java`)

Declares a `Color` enum with three constants: `ORANGE`, `BLACK`, and `WHITE`. Assigns a constant to a variable and prints it, demonstrating that Java prints the constant's name by default.

**Beyond Normal Usage:**
- **Expected:** Accessing `Color.values()[3]` on a 3-constant enum would throw an error at compile time.
- **Actual:** Java compiled the code without issue. At runtime, it threw an `ArrayIndexOutOfBoundsException`.
- **When caught:** Runtime — Java does not validate array index access on enum values at compile time.

---

### Program 2 — Exhaustive Control Flow (`p2.java`)

Declares a `TrafficLight` enum with `RED`, `YELLOW`, and `GREEN`. Uses a `switch` statement that handles all three variants and prints the corresponding message.

**Beyond Normal Usage:**
- **Expected:** Adding a new `PURPLE` variant to the enum without updating the switch would cause a compiler warning or error.
- **Actual:** The code compiled and ran silently. The `PURPLE` case was completely ignored with no output and no warning.
- **When caught:** Never — Java's classic `switch` does not enforce exhaustiveness. This is a known design gap.

---

### Program 3 — Extended Enum Behavior (`p3.java`)

Declares a `Shape` enum where each constant carries its own data via constructor fields. `CIRCLE` stores a radius and `RECTANGLE` stores width and height. Each constant uses `getDescription()` to describe its dimensions and `area()` to compute and return its area using the correct formula per shape.

**Beyond Normal Usage:**
- **Expected:** Assigning `null` to a `Shape` variable and calling `.getDescription()` on it would be caught at compile time.
- **Actual:** The compiler accepted the null assignment without complaint. At runtime, it threw a `NullPointerException`.
- **When caught:** Runtime — enum variables are reference types in Java, so `null` is always a valid assignment and the compiler does not prevent it.

---

### Program 4 — Iteration and Introspection (`p4.java`)

Contains two enums. `RockyPlanets` iterates over `MERCURY`, `VENUS`, `EARTH`, and `MARS` using `values()`, printing each constant's `.name()` and `.ordinal()` — demonstrating built-in iteration with no reflection needed. `Priority` demonstrates that two constants (`MEDIUM` and `HIGH`) can share the same custom field value.

**Beyond Normal Usage:**
- **Expected:** `MEDIUM(2)` and `HIGH(2)` sharing the same custom level value would cause one to be suppressed or treated as a duplicate during iteration.
- **Actual:** Both constants appeared separately during iteration. Java treats them as completely distinct constants regardless of shared field values.
- **When caught:** Never — no error. Ordinals (`1` and `2`) are always unique and auto-assigned; custom field values are independent and have no effect on how Java distinguishes constants.

---

### Program 5 — Applied Enumeration (`p5.java`)

A vending machine state machine driven entirely by a `VendingState` enum with four states: `IDLE`, `ACCEPTING_MONEY`, `DISPENSING`, and `OUT_OF_STOCK`. The enum controls every state transition in the program's loop. Only `ACCEPTING_MONEY` processes coin input, and only `DISPENSING` modifies stock. When stock reaches zero, the program exits and prints a goodbye message. Removing the enum would require a full redesign of the control flow — it is not just a label.

---

## How to Run

Each program is a standalone `.java` file. Compile and run individually:

```bash
javac p1.java && java p1
javac p2.java && java p2
javac p3.java && java p3
javac p4.java && java p4
javac p5.java && java p5
```

> Note: `p5.java` requires user input via the terminal (coin values and Enter key presses).
