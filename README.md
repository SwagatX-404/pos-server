# 🛒 POS System (React + Spring Boot + MySQL)

A full-stack **Point of Sale (POS) Management System** built using
**React (Frontend)**, **Spring Boot (Backend)**, and **MySQL (Database)**.
The system includes an **Admin Dashboard**, **Inventory Management**, **Billing**,
and **User Role Management**.

---

## 🚀 Tech Stack

### **Frontend**

* React.js
* Tailwind CSS / CSS
* Axios
* React Router

### **Backend**

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security (optional)
* Lombok

### **Database**

* MySQL
* Hibernate ORM

---

## ✨ Features

### ✅ **Admin Panel**

* Manage Products
* Manage Categories
* View Sales Reports
* Manage Users (Cashier / Staff)
* Dashboard Analytics

### 🛍️ **POS (Cashier) Module**

* Add items to cart
* Auto price calculation
* Apply discounts / GST
* Generate invoice
* Print / Download bill
* Daily sales view

### 📦 **Inventory Management**

* Add / Edit / Delete products
* Low-stock alert
* Category-based filtering

### 👤 **Authentication**

* Admin Login
* Cashier Login
* Role-based access (Admin & Staff)

---

## 📁 Project Structure

```
pos-system/
 ├── backend/
 │     ├── src/main/java/com/pos
 │     ├── src/main/resources/
 │     ├── pom.xml
 │
 ├── frontend/
 │     ├── src/
 │     ├── public/
 │     ├── package.json
 │
 ├── README.md
 └── .gitignore
```

---

## ⚙️ Backend Setup (Spring Boot)

### 1️⃣ Navigate to backend folder:

```
cd backend
```

### 2️⃣ Add MySQL credentials in `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/posdb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3️⃣ Run backend:

```
mvn spring-boot:run
```

---

## 🎨 Frontend Setup (React)

### 1️⃣ Navigate to frontend folder:

```
cd frontend
```

### 2️⃣ Install dependencies:

```
npm install
```

### 3️⃣ Run development server:

```
npm run dev
```

---

## 📡 API Endpoints (Sample)

### **Products**

```
GET    /api/products
POST   /api/products
PUT    /api/products/{id}
DELETE /api/products/{id}
```

### **Auth**

```
POST /api/auth/login
```

### **Billing**

```
POST /api/bill/create
GET  /api/bill/today
```

---

## 🔐 Environment Variables

### Backend

```
DB_USER=root
DB_PASSWORD=password
JWT_SECRET=secret-key
```

### Frontend

```
VITE_API_URL=http://localhost:8080
```

---

## 📸 Screenshots (Optional Section)

Add your screenshots:

```
![Dashboard](./screenshots/dashboard.png)
![POS Screen](./screenshots/pos.png)
```

---

## 🤝 Contributing

Pull requests are welcome.
For major changes, open an issue first.

---

## 📄 License

This project is licensed under the **MIT License**.

---

# 🎉 Thank you for checking out the POS System!
