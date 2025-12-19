Canteen Management System (Java)

## Overview
The **Canteen Management System** is a Java-based console application designed to streamline canteen operations.  
It provides two distinct sections: **Admin** and **User**, each with specific functionalities.  
The project demonstrates the use of **arrays, searching, deletion, and calculations** in a real-world scenario.

---

## Admin Section
- **Login Authentication**: Admin logs in using a predefined **ID and Password**.
- **Functionalities**:
  - **Insert Items**: Add new food items with details (Item Number, Name, Price, Quantity).
  - **Update Items**: Modify item details using **Binary Search** on Item Number.
  - **Delete Items**: Remove items from the menu using **array deletion logic**.
  - **Display Menu**: View the current list of items available.

---

## User Section
- **View Menu**: Displays all available food items with their details.
- **Order Food**:
  - Select items by Item Number.
  - Enter desired quantity (validated against stock).
  - Updates inventory automatically.
- **Invoice Generation**:
  - Shows ordered items, quantities, prices, and total amount.
  - Includes **GST (5%)** and applicable **discounts** (7% or 10% based on bill amount).
  - Generates **random Table Number and Bill Number** for uniqueness.
  - Displays a formatted bill with a “Thank You” message.

---

## Key Concepts Used
- **Arrays**  
  - Storage of item details (Item Number, Name, Price, Quantity).  
  - Deletion and shifting of elements after removing an item.  
- **Binary Search**  
  - Efficient search for items by Item Number during updates.  
- **Calculations**  
  - GST, discounts, and total bill computation.  
- **Control Structures**  
  - Loops and conditionals for menu navigation and order processing.  

---

## Technologies
- **Language**: Java  
- **Concepts**: Arrays, Binary Search, Deletion, Console I/O, Control Structures  

---

## How to Run
1. Compile the program:
   ```bash
   javac Canteen_Management_System.java
2. Run the Program :
   java Canteen_Management_System
