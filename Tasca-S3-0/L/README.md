# 🧬 L - Liskov Substitution Principle (LSP)

## 🧠 What is it?

The **Liskov Substitution Principle (LSP)** states that:

> **Subclasses must be able to replace their superclasses without altering the behaviour of the program.**

This means that any child class should **behave like its parent class**. If a subclass **breaks contracts or behaviours** defined in the base class, then it violates this principle.

In other words, if a program is designed to work with an object of a base class, it should work correctly if that object is replaced by any object of a derived class.

## 🚨 Why is it important?
When we use **inheritance**, we expect a subclass to **extend the behaviour of the superclass, not break it**. If LSP is not respected, we can have hard-to-detect bugs and systems that are difficult to maintain or extend.

### 👩‍🏫 **Example:**

Suppose you are designing an application that works with various **cryptocurrencies** and you offer an **API** like this:
```java
public class Wallet {
    private String cryptoName;
    private String cancellationCode;

    public Wallet(String cryptoName, String cancellationCode) {
        this.cryptoName = cryptoName;
        this.cancellationCode = cancellationCode;
    }

    public void sendMoney(String destination, double amount) {
        System.out.println("Sending money via the " + cryptoName + " blockchain");
    }

    public void cancelTransaction(String transactionId) {
        if (AuthorizationCancel.cancel(cancellationCode, transactionId))
            System.out.println("Transaction " + transactionId + " cancelled with code " + cancellationCode);
        else throw new TransactionCancelException("Could not cancel the transaction");
    }
}
```

**Your API works with:**

- `Tezos`
- `Ethereum`
- `Monero`
```java
public class TezosWallet extends Wallet {
    public TezosWallet() {
        super("Tezos", "TEZ_0974_BLCH");
    }
}

public class EthereumWallet extends Wallet {
    public EthereumWallet() {
        super("Ethereum", "ETH_7637_BLCH");
    }
}

public class MoneroWallet extends Wallet {
    public MoneroWallet() {
        super("Monero", null); // Monero does not allow transaction cancellations
    }
}
```

🔴 Problem: `MoneroWallet` inherits from `Wallet`, but when someone calls `cancelTransaction()` with a `MoneroWallet` instance, the **program will always crash** because Monero does not allow cancellations.

⚠️ Therefore, `MoneroWallet` cannot be used in contexts that expect `Wallet.cancelTransaction()` to work correctly → this **breaks LSP.**

✅ Solution: apply LSP with a **clear hierarchy**:
> The key is to **separate responsibilities**: not all cryptocurrencies allow cancellations, so not all wallets should have this method.

- **1️⃣ Create the interface for cancellation:**
```java
public interface CancellationStrategy {
    void cancel(String id);
}
```

- **2️⃣ Implement the real and null strategies:**
```java
public class AllowedCancellationStrategy implements CancellationStrategy {
    private String cancellationCode;

    public AllowedCancellationStrategy(String cancellationCode) {
        this.cancellationCode = cancellationCode;
    }

    @Override
    public void cancel(String id) {
        System.out.println("Transaction " + id + " cancelled with code " + cancellationCode);
    }
}

public class NotAllowedCancellationStrategy implements CancellationStrategy {
    @Override
    public void cancel(String id) {
        System.out.println("Cancellation not supported by this wallet, ignoring transaction: " + id);
    }
}
```

- **3️⃣ Modify the Wallet class to use the cancellation strategy:**
```java
public class Wallet {
    private String cryptoName;
    private CancellationStrategy cancellationStrategy;

    public Wallet(String cryptoName, CancellationStrategy cancellationStrategy) {
        this.cryptoName = cryptoName;
        this.cancellationStrategy = cancellationStrategy;
    }

    public void sendMoney(String destination, double amount) {
        System.out.println("Sending money via the " + cryptoName + " blockchain");
    }

    public void cancelTransaction(String id) {
        cancellationStrategy.cancel(id);
    }
}
```

- **4️⃣ Create wallets with the appropriate strategy:**
```java
public class TezosWallet extends Wallet {
    public TezosWallet() {
        super("Tezos", new AllowedCancellationStrategy("TEZ_0974_BLCH"));
    }
}

public class EthereumWallet extends Wallet {
    public EthereumWallet() {
        super("Ethereum", new AllowedCancellationStrategy("ETH_7637_BLCH"));
    }
}

public class MoneroWallet extends Wallet {
    public MoneroWallet() {
        super("Monero", new NotAllowedCancellationStrategy());
    }
}
```

---

## 🎯 Exercise Goal

You will find a Java class that **misuses inheritance** and, as a result, **violates the Liskov principle**.

🔧 Your challenge is to:

1. Identify the hierarchy that **breaks the expected behaviour**.
2. Refactor the code to ensure that **subclasses are substitutable without breaking** the logic.
3. Apply **abstractions and polymorphism** to make the code more flexible and robust.

---

## 📌 Tips for applying LSP

✅ **Make sure all subclasses fulfil the contract of the superclass.**

✅ **Don't use inheritance just to reuse code.**

✅ **Consider patterns like Composition`*` over Inheritance when there is no clear type relationship.**

`*` **"Composition"** is an **OOP** concept that means building a class using other objects (from other classes) as internal parts, instead of creating an inheritance hierarchy (subclasses).

---

## 💬 Reflection

When you correctly apply **the Liskov principle**:
- You avoid unexpected behaviour at runtime.
- Your code is more predictable, safe and reusable.
- You can use polymorphism without surprises.

🔁 **Inheriting** behaviour means **respecting it**, **not breaking it**.

---

🚀 Go ahead! Review the code, identify the error and refactor the hierarchy so it complies with **LSP**.

❓ **Can a subclass be used in place of its superclass without issues?**