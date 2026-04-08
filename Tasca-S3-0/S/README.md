# 🧱 S - Single Responsibility Principle (SRP)

## 🧠 What is it?

The **Single Responsibility Principle** states that:

> **A class should have only one reason to change.**

In other words, a class should have **a single responsibility**, or **a single reason to be modified**.

👩‍🏫 **Example:**
If you have a `Report` class that:
- generates content,
- prints the report,
- and saves the report.
```java
public class Report {
    private String content;

    public Report(String content) {
        this.content = content;
    }
    
    public String getContent() {
        return content;
    }

    public void print() {
        System.out.println("Printing report:");
        System.out.println(content);
    }

    public void save(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Report saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving report: " + e.getMessage());
        }
    }
}
```
🔴 Problem: Each of these functions **belongs to a different responsibility** and should be separated into different classes.

⚠️ You are violating the principle!

✅ Refactored version with SRP applied — responsibilities split into separate classes:

- **1️⃣ Report: contains only the content.**
```java
// Single responsibility: maintain report content
public class Report {
    private String content;

    public Report(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
```

- **2️⃣ Printer: handles printing.**
```java
// Single responsibility: print reports
public class Printer {
    public void printReport(Report report) {
        System.out.println("Printing report:");
        System.out.println(report.getContent());
    }
}
```

- **3️⃣ Saver: handles saving the report.**
```java
// Single responsibility: save reports
public class Saver {
    public void saveReport(Report report, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(report.getContent());
            System.out.println("Report saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving report: " + e.getMessage());
        }
    }
}
```

- **4️⃣ Usage example:**
```java
public class Main {
    public static void main(String[] args) {
        Report report = new Report("This is the report content.");

        Printer printer = new Printer();
        printer.printReport(report);

        Saver saver = new Saver();
        saver.saveReport(report, "report.txt");
    }
}
```

---

## 🎯 Exercise Goal

In the attached Java file you will find a class that **does not respect this principle** — it does too many things at once.

🔧 Your challenge is to:

1. Analyse the multiple responsibilities the class has.
2. Separate them into **different classes**, each with a single clear responsibility.
3. Keep the code readable, modular and easy to maintain.

---

## 📌 Tips for applying SRP

✅ Ask yourself: *"What reasons would this class have to change?" and "What are the responsibilities of this class?"*

✅ If there is more than one... it's time to separate responsibilities!

✅ Don't be afraid to create **more small, focused classes**.

---

## 💬 Reflection

When a class has only one responsibility:
- It is easier to read.
- It is easier to test.
- It is less likely to introduce bugs when you change a feature.

🔁 **Less coupling, more cohesion.**

---

🚀 Go ahead! Review the code, apply the SRP and enjoy the refactoring process.

❓ **How many responsibilities does the class have?**