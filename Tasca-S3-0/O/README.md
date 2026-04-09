# 🚪 O - Open/Closed Principle (OCP)

## 🧠 What is it?

The **Open/Closed Principle** states that:

> **Code should be open for extension, but closed for modification**

This means we should be able to **add new functionality** to our system **without having to modify existing code**.

### 👩‍🏫 **Example:**

Suppose you have a `DiscountCalculator` class with this method:
```java
public double calculateDiscount(Product product) {
    if (product.getType().equals("Christmas")) {
        return product.getPrice() * 0.2;
    } else if (product.getType().equals("BlackFriday")) {
        return product.getPrice() * 0.3;
    }
    return 0;
}
```

🔴 Problem: Every time you want to add a new discount type, **you have to modify this class**.
⚠️ This **violates the OCP**, because the code is not closed for modification.

✅ The solution is to use **polymorphism** or **design patterns** (such as **Strategy** or **Factory**), which allow adding new behaviours without touching existing code:

- **1️⃣ Define a common interface:**
```java
public interface DiscountStrategy {
    double applyDiscount(Product product);
}
```

- **2️⃣ Implement concrete strategies:**
```java
public class ChristmasDiscount implements DiscountStrategy {
    public double applyDiscount(Product product) {
        return product.getPrice() * 0.2;
    }
}

public class BlackFridayDiscount implements DiscountStrategy {
    public double applyDiscount(Product product) {
        return product.getPrice() * 0.3;
    }
}

public class AnniversaryDiscount implements DiscountStrategy {
    public double applyDiscount(Product product) {
        return product.getPrice() * 0.1;
    }
}
```

- **3️⃣ Flexible DiscountCalculator open for extension:**
```java
public class DiscountCalculator {
    public double calculateDiscount(Product product, DiscountStrategy strategy) {
        return strategy.applyDiscount(product);
    }
}
```

- **4️⃣ Usage example:**
```java
public class Main {
    public static void main(String[] args) {
        Product product = new Product("Laptop", 1000);

        DiscountCalculator calculator = new DiscountCalculator();

        double discount = calculator.calculateDiscount(product, new ChristmasDiscount());
        System.out.println("Discount applied: " + discount);
    }
}
```

---

## 🎯 Exercise Goal

In the attached Java file you will find a class that **does not respect the OCP**: it needs to be modified every time there is a change or extension of functionality.

🔧 Your challenge is to:

1. Identify which part of the code is **too exposed to modifications**.
2. Refactor it to be **easily extensible** without altering existing behaviour.
3. Apply **abstractions and polymorphism** to make the code more flexible and robust.

---

## 📌 Tips for applying OCP

✅ **Avoid conditional statements (if/else, switch)** to decide behaviours that may vary over time.

✅ **Define interfaces or abstract classes** that allow adding new functionality without touching existing code.

✅ **Use patterns like Strategy, Factory or Chain of Responsibility** depending on the context.

---

## 💬 Reflection

When a system is well designed according to **OCP**:
- You can add **new functionality** with ease.
- Your code is **more stable** and less vulnerable to regressions`*`.
- You improve **reusability** and **maintainability**.

🔁 **Extensible**, but **safe**. That is the power of OCP.

`*` **Regression** means that functionality that **previously worked correctly has stopped working** after changes were made to the code.

---

🚀 Go ahead! Review the code, detect how it can be improved and apply the OCP to make it more modular and future-proof.

❓ **Can you add a new product without changing the code?**