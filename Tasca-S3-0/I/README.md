# 🔌 I - Interface Segregation Principle (ISP)

## 🧠 What is it?

The **Interface Segregation Principle (ISP)** states that:

> **A class should not be forced to implement methods it does not need.**

This means that interfaces **must be specific and well-defined according to functionality**. If an interface is too large or generic, it can force classes to implement methods that make no sense for them.

⚠️ This problem is known as **fat interfaces** or **"code smell"** `*` of **bloated interfaces** with too many responsibilities.

`*` **"Code smell"** refers to a characteristic of source code that suggests a deeper problem or a **possible error in the design or structure of the code**.

## 🚨 Why is it important?
Having **smaller and more specific interfaces** makes it easier to **reuse** those interfaces in different parts of the system **without causing compatibility issues.**

### 👩‍🏫 **Example:**

Suppose you are designing an application that works with **various types of printers** and you offer an interface like this:
```java
public interface Printer {
    void print(String document);
    void scan(String document);
    void sendFax(String document);
}

public class BasicPrinter implements Printer {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }

    @Override
    public void scan(String document) {
        throw new UnsupportedOperationException("This printer cannot scan.");
    }

    @Override
    public void sendFax(String document) {
        throw new UnsupportedOperationException("This printer cannot send faxes.");
    }
}
```

🔴 The problem with this interface is that it groups **too many responsibilities into a single interface**. Not all printers have the ability to scan or send faxes, but they are still **forced to implement these methods**.

⚠️ This violates the **Interface Segregation Principle (ISP)**

✅ Solution with ISP:
> Split the Printer interface into **smaller, more specific interfaces** (Printer, Scanner, Fax), and **make each class implement only the ones it needs**.

- **1️⃣ Interfaces segregated by functionality:**
```java
public interface Printer {
    void print(String document);
}

public interface Scanner {
    void scan(String document);
}

public interface Fax {
    void sendFax(String document);
}
```

- **2️⃣ Basic printer — prints only:**
```java
public class BasicPrinter implements Printer {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }
}
```

- **3️⃣ Printer with scanner — prints and scans:**
```java
public class PrinterScanner implements Printer, Scanner {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("Scanning: " + document);
    }
}
```

- **4️⃣ Multifunction printer — prints, scans and sends faxes:**
```java
public class MultifunctionPrinter implements Printer, Scanner, Fax {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("Scanning: " + document);
    }

    @Override
    public void sendFax(String document) {
        System.out.println("Sending fax: " + document);
    }
}
```

---

## 🎯 Exercise Goal

In the attached Java file you will find a class or class hierarchy that implements a **fat interface**.

🔧 Your challenge is to:

1. Detect which methods **make no sense** for some of the classes.
2. Refactor the interface into **smaller, more focused interfaces**.
3. Make each class implement **only the interfaces it needs**.

---

## 📌 Tips for applying ISP

✅ **If a class has to implement a method that only throws an exception or stays empty... you may be violating ISP.**

✅ **Prefer multiple specific interfaces over a single generic one.**

✅ **Small, focused interfaces favour a more flexible and maintainable design.**

---

## 💬 Reflection

When **ISP** is followed:
- Classes are simpler and more coherent.
- We avoid absurd or unnecessary implementations.
- It facilitates the use of composition instead of forced inheritance.

🔁 **More modularity, less coupling.**

---

🚀 Go ahead! Review the interface, apply the **ISP** and refactor with elegance.

❓ **Is your interface doing too many things? Which parts could be split?**