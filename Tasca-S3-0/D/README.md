# 🧲 D - Dependency Inversion Principle (DIP)

## 🧠 What is it?

The **Dependency Inversion Principle (DIP)** states that:

> **Classes should depend on abstractions, not on concrete classes.**

In other words, code should **rely on interfaces or abstract classes, not on specific implementations**. This allows different parts of the system to be **decoupled**, which **facilitates change, substitution and reuse** of components.

📌 This can be summarised in two key rules:
- 1 **High-level modules** (business logic) **should not depend on low-level modules** (implementations).
- 2 **Both should depend on abstractions**.

## 🚨 Why is it important?
Without DIP, high-level components can become **tightly coupled to concrete implementations**, making the system **difficult to modify, test or extend**.

When DIP is applied correctly:

- ✅ Code is more flexible and easier to test.
- ✅ Implementations can be swapped without affecting the main logic.
- ✅ It encourages dependency injection and abstraction-oriented programming.

### 👩‍🏫 **Example:**

Suppose you have an application that manages notifications always sent by email:
```java
public class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}
```
```java
public class NotificationManager {
    private EmailService emailService;

    public NotificationManager() {
        this.emailService = new EmailService();
    }

    public void notify(String message) {
        emailService.sendEmail(message);
    }
}
```

🔴 Problem:
`NotificationManager` depends directly on `EmailService` (a concrete implementation). If you want to add other channels like SMS, WhatsApp or Push, you would need to modify the class.

⚠️ This violates both **OCP** and **DIP**.

✅ Solution with DIP:

- **1️⃣ Create an abstraction (interface) for the notification service:**
```java
public interface NotificationChannel {
    void send(String message);
}
```

- **2️⃣ Make EmailService implement the interface:**
```java
public class EmailService implements NotificationChannel {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}
```

- **3️⃣ Modify NotificationManager to depend on the abstraction:**
```java
public class NotificationManager {
    private NotificationChannel channel;

    public NotificationManager(NotificationChannel channel) {
        this.channel = channel;
    }

    public void notify(String message) {
        channel.send(message);
    }
}
```

- **4️⃣ Now you can inject different channels without modifying NotificationManager:**
```java
public class Main {
    public static void main(String[] args) {
        NotificationChannel channel = new EmailService(); // or new SmsService(), new PushService()...
        NotificationManager manager = new NotificationManager(channel);
        manager.notify("Hello world!");
    }
}
```

---

## 🎯 Exercise Goal

In the Java file included in this directory, you will find a class that depends **directly on another concrete class**.

🔧 Your challenge is to:

1. Identify this direct dependency.
2. Create an appropriate **interface or abstraction**.
3. Refactor the classes so they **depend on the abstraction**, not the concrete implementation.
4. Apply **dependency injection** (via constructor, setter or method).

---

## 📌 Tips for applying DIP

✅ High-level classes should be **independent of technical details**.

✅ Use **interfaces or abstract classes** to decouple.

✅ Apply patterns like **Dependency Injection (DI) or Factory**.

✅ Writing unit tests is much easier when **DIP** is applied.

---

## 💬 Reflection

When you follow **DIP**:
- Your code becomes **modular and easy to maintain**.
- **New features can be added without breaking existing ones**.
- You favour a **cleaner, testable and scalable** system.

🔁 **Change implementations, not designs**.

---

🚀 Go ahead! Refactor with the DIP principle in mind and improve your code structure.

❓ **Are you depending on concrete classes? How could you invert that dependency?**