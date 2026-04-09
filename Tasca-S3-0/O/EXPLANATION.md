# O — Open/Closed Principle

## What was wrong?
The original `InstrumentPlayer` used a chain of `if-else` statements to determine
how each instrument should be played based on a `String` value. Every time a new
instrument needed to be added, the `play()` method had to be modified — tightly
coupling the class to all possible instrument types.

## Why did it violate the principle?
OCP states that software entities should be open for extension but closed for modification.
The original design had:

InstrumentPlayer → if/else for each instrument ❌

Instead of:

InstrumentPlayer → Instrument ← Guitar / Drums / Piano ✅

Adding a new instrument (e.g. violin, trumpet) required modifying `InstrumentPlayer`
directly — making it unstable and hard to maintain.

## What solution was applied and why?
The solution was to replace the `if-else` logic with polymorphism:

- **`Instrument`** — interface defining the `play()` contract
- **`Guitar`**, **`Drums`**, **`Piano`** — concrete implementations, each encapsulating its own behaviour
- **`InstrumentPlayer`** — depends on the `Instrument` abstraction via constructor injection

New instruments can now be added by creating a new class that implements `Instrument`
without modifying any existing code.

## Why constructor injection?
`InstrumentPlayer` receives its `Instrument` dependency from outside via constructor.
This keeps the class decoupled from concrete implementations and makes it easy to
extend with new instruments without touching existing code.