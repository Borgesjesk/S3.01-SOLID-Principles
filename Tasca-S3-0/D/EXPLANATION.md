# D — Dependency Inversion Principle

## What was wrong?
The original `ServicePerson` class directly instantiated `MySql` — a concrete low-level
implementation — creating tight coupling between the high-level service and the database layer.

## Why did it violate the principle?
DIP states that high-level modules should not depend on low-level modules. Both should
depend on abstractions. The original design had:

ServicePerson → MySql ❌

Instead of:

ServicePerson → PersonRepository ← MySqlPersonRepository ✅

Any change to the persistence layer (e.g. switching to PostgreSQL or MongoDB) would
require modifying `ServicePerson` — also violating the Open/Closed Principle.

## What solution was applied and why?
A `PersonRepository` interface was introduced as an abstraction layer between the
high-level service and the low-level implementation:

- **`PersonRepository`** — defines the contract for person persistence
- **`MySqlPersonRepository`** — concrete implementation of that contract
- **`ServicePerson`** — now depends on `PersonRepository`, not on any specific database

This allows swapping implementations (PostgreSQL, MongoDB, Mock) without ever
modifying `ServicePerson`.

## Why constructor injection?
The dependency is injected via constructor, so `ServicePerson` never knows which
concrete implementation it receives. This improves flexibility, testability, and keeps
the high-level logic completely decoupled from infrastructure details.