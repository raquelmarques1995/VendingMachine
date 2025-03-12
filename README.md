# Vending Machine Simulation

This project involves developing an application that simulates a vending machine for snacks. The application allows customers to purchase various types of products and enables staff to manage the machine.

## 🛒 Features

### Product Sales
- Customers can insert an amount and choose an available product.
- Available products include:
  - **Chocolates**: With different cocoa types (dark, white, or milk) and brands.
  - **Soft Drinks**: Regular or sugar-free, with associated brands (Pepsi, Sumol, or Lipton).
  - **Sandwiches**: Various types (mixed, ham, or cheese) with producer identification.
- If the inserted amount is insufficient, the application informs the missing value.
- The product is delivered, and change is returned (if applicable).
- Stock is updated after each sale.

### Machine Management
- A staff member can:
  - Add new products to the stock.
  - Remove products from the machine.
  - Check the total sales revenue.
  - View and clear the sales history.

## 🏗️ Project Structure
The project follows **Object-Oriented Programming (OOP)** principles, ensuring flexibility and scalability. Key features include:
- Classes representing different types of products.
- Data persistence mechanism using the `stock.dat` file, ensuring information is automatically loaded when the machine starts.
- Exception handling to prevent unexpected failures.

## 💾 Data Persistence
Machine data is stored in the `stock.dat` file, which contains information about product stock and sales history. Whenever the machine is started, the data is automatically loaded.

## 🚀 How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/vending-machine.git
   ```
2. Navigate to the project folder:
   ```bash
   cd vending-machine
   ```
3. Compile and run the application:
   ```bash
   javac Main.java
   java Main
   ```

## 📌 Future Improvements
- Implement a graphical user interface for better usability.
- Integrate digital payment methods.
- Expand the product catalog.

## 📄 License
This project is open-source and licensed under the **MIT License**.
