# L — Liskov Substitution Principle

## What was wrong?
The original `Ghost` class extended `Character` but threw an
`UnsupportedOperationException` in `takeDamage()`:
```java
Character c = new Ghost();
c.takeDamage(10); // 💥 runtime crash
```

This means `Ghost` cannot safely replace `Character` — breaking LSP.

## Why did it violate the principle?
LSP states that subclasses must be safely substitutable for their base class
without breaking the program. The original design had:

Character → takeDamage() ✅
Ghost → takeDamage() → throws exception ❌

Any code working with `Character` expects `takeDamage()` to be safe to call.
Substituting a `Ghost` causes unexpected runtime failures — `Ghost` was not
a true substitute for `Character`.

## What solution was applied and why?
The root problem was that `takeDamage()` was in `Character`, but not all
characters can take physical damage. The fix was to remove it from the base
class and introduce a dedicated interface:

- **`Character`** — abstract base class with only `attack()` — shared by all
- **`Damageable`** — interface with `takeDamage(int points)` — only for characters that can take damage
- **`Warrior`** — extends `Character` + implements `Damageable` — attacks and takes damage
- **`Ghost`** — extends `Character` only — attacks but takes no physical damage

Now both `Warrior` and `Ghost` are safe substitutes for `Character` —
no broken promises, no runtime exceptions.

## Result
```
Character c = new Ghost();
c.attack(); // ✅ works perfectly

Damageable d = new Warrior();
d.takeDamage(10); // ✅ works perfectly
```