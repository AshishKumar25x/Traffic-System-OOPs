# 🚦 Traffic Signal and Management System (OOP Project)

This project simulates a basic traffic management system in Java, demonstrating core Object-Oriented Programming (OOP) concepts like **Inheritance**, **Polymorphism**, and **Encapsulation**.

---

## ✨ Features

* **Traffic Signal Control:** Simulates Red, Yellow, and Green light states and provides instructions.
* **Vehicle Classification:** Distinguishes between standard vehicles (Car, Bike, Truck) and **Emergency Vehicles** (Ambulance).
* **Polymorphism in Action:** Uses the `isEmergency()` method override to apply special rules to emergency vehicles.
* **Rule Enforcement:** Calculates fines for:
    * Running a **RED** light.
    * Running a **YELLOW** light.
    * **Speed Limit** violations.
* **Emergency Exemption:** Emergency vehicles are exempt from all fines.

---

## 💻 OOP Concepts Demonstrated

| Concept | Class/Method Example | Description |
| :--- | :--- | :--- |
| **Inheritance** | `EmergencyVehicle extends Vehicle` | The `EmergencyVehicle` class inherits properties and methods from the `Vehicle` parent class. |
| **Polymorphism** | `v.isEmergency()` | The call to `isEmergency()` behaves differently based on whether `v` is a `Vehicle` or an `EmergencyVehicle` object (Run-time Polymorphism via Method Overriding). |
| **Encapsulation** | `TrafficSignal` class | The `color` of the signal is private, and access is controlled via a public method (`getColor()`). |

---

## 🛠️ How to Run

1.  **Save the Code:** Save the provided Java code as `TrafficSystem.java`.
2.  **Compile:** Open your terminal/command prompt and navigate to the directory where you saved the file.
    ```bash
    javac TrafficSystem.java
    ```
3.  **Run:** Execute the compiled class file.
    ```bash
    java TrafficSystem
    ```

### Example Interaction

The program will prompt the user for the following inputs:

1.  **Traffic Light Status:** (e.g., `Red`, `Green`)
2.  **Vehicle Selection:** (1-4 for Car, Bike, Truck, Ambulance)
3.  **Vehicle Running Status:** (e.g., `yes`, `no`)
4.  **Speed Limit** (if running)
5.  **Vehicle Speed** (if running)

The system will then output the relevant signal message and the total fine (if any).

---

## 📂 Class Structure

### 1. `Vehicle` (Parent Class)

* **Fields:** `type`, `isRunning`, `speed`.
* **Method:** `isEmergency()` (returns `false` by default).

### 2. `EmergencyVehicle` (Child Class)

* **Inherits** from `Vehicle`.
* **Method:** Overrides `isEmergency()` to return `true`.

### 3. `TrafficSignal`

* **Field:** `color` (Encapsulated).
* **Methods:** `getColor()`, `showMessage()`.

### 4. `TrafficSystem`

* Contains the `main` method for execution.
* Handles user input, object creation, and rule-based fine calculation.

---

## 👤 Author

Ashish Kumar
