# I — Interface Segregation Principle

## What was wrong?
The original `MachineActions` interface bundled too many unrelated methods into a
single contract:

- `turnOn()`, `turnOff()` — shared by all machines
- `heat()`, `cool()` — only relevant to `AirConditioner`
- `wash()` — only relevant to `WashingMachine`

This forced every implementing class to provide implementations for methods they
don't actually use — a classic "fat interface" problem.

## Why did it violate the principle?
ISP states that a class should not be forced to depend on interfaces it does not use.
The original design had:

AirConditioner → forced to implement wash() ❌
WashingMachine → forced to implement heat() and cool() ❌

This leads to polluted implementations, increased coupling, and harder maintenance.

## What solution was applied and why?
The solution was to split `MachineActions` into three focused interfaces:

- **`Switchable`** → `turnOn()`, `turnOff()` — shared by all machines
- **`TemperatureControl`** → `heat()`, `cool()` — only for AirConditioner
- **`Washable`** → `wash()` — only for WashingMachine

Each class now implements only what it needs:

- `AirConditioner` → `Switchable`, `TemperatureControl`
- `WashingMachine` → `Switchable`, `Washable`

No unnecessary methods, no forced implementations, no polluted design.

## Benefits
- Each class is only coupled to behaviour it actually uses
- New devices can be added by combining existing interfaces
- Cleaner, more modular and maintainable architecture