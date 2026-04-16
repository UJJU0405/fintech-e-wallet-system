# 💰 Fintech E-Wallet System

A **production-grade backend application** that simulates real-world digital wallet platforms such as **Google Pay / PhonePe / Paytm**.

This project is designed with a focus on **transaction reliability, secure authentication, concurrency-safe operations, and scalable architecture**.

---

## 🚀 Key Features

### 🔐 Authentication & Security

* JWT-based user authentication
* Secure API access
* Role-based access structure
* Password encryption support

---

### 💳 Wallet Operations

* Create user wallet
* Add money to wallet
* Check wallet balance
* Transfer funds between users
* Transaction history

---

### 🏦 UPI Simulation

* Unique UPI IDs (`user@bank`)
* Send money via UPI ID
* Request ID based duplicate prevention
* Payment status tracking

---

### ⚡ Advanced Backend Engineering

* **Concurrency-safe wallet operations** using optimistic locking
* **Idempotent APIs** to prevent duplicate transactions
* **Retry mechanism** for temporary failures
* **Kafka-based event-driven architecture**
* Real-time transaction event logging

---

## 🧠 System Architecture

### 📂 Project Layers

```id="jxvhqo"
Controller → Service → Repository → Database
                     ↓
                 Kafka Events
```

---

### 💸 Transaction Flow

```id="l20gbj"
User Request
   ↓
JWT Authentication
   ↓
Balance Validation
   ↓
Idempotency Check
   ↓
Concurrency-safe Transfer
   ↓
Transaction Save
   ↓
Kafka Event Publish
   ↓
Success Response
```

---

## 🛠 Tech Stack

### Backend

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate

### Database

* MySQL

### Messaging

* Apache Kafka

### Tools

* Maven
* Postman
* GitHub
* Docker

---

## 📂 Folder Structure

```id="5mvdvc"
src/main/java/com/fintech/ewallet/
│
├── controller/
│   ├── AuthController.java
│   ├── WalletController.java
│   └── UpiController.java
│
├── service/
│   ├── WalletService.java
│   ├── TransactionService.java
│   └── RetryService.java
│
├── repository/
│   ├── UserRepository.java
│   ├── WalletRepository.java
│   └── TransactionRepository.java
│
├── model/
│   ├── User.java
│   ├── Wallet.java
│   └── Transaction.java
│
├── security/
│   ├── JwtUtil.java
│   ├── JwtFilter.java
│   └── SecurityConfig.java
│
├── event/
│   ├── KafkaProducer.java
│   └── KafkaConsumer.java
```

---

## 🔗 API Endpoints

### 🔐 Authentication

```id="g36t44"
POST /api/auth/login
```

---

### 💰 Wallet

```id="s3ml1r"
POST /api/wallet/add
GET  /api/wallet/balance
```

---

### 💸 UPI Transactions

```id="fcd07p"
POST /api/upi/send
```

---

## 🧪 Sample API Request

```json id="24xny0"
{
  "senderUpi": "user1@bank",
  "receiverUpi": "user2@bank",
  "amount": 500,
  "requestId": "txn123"
}
```

---

## ⚙️ How to Run

### 1. Clone Repo

```bash id="q51k1r"
git clone https://github.com/UJJU0405/fintech-e-wallet-system.git
cd fintech-e-wallet-system
```

---

### 2. Configure Database

```sql id="i3h6f0"
CREATE DATABASE ewallet;
```

---

### 3. Update `application.properties`

```properties id="8vxtq1"
spring.datasource.url=jdbc:mysql://localhost:3306/ewallet
spring.datasource.username=root
spring.datasource.password=yourpassword
```

---

### 4. Run Project

```bash id="4j69be"
mvn spring-boot:run
```

---

## 🔥 Advanced Features Highlight

### ✔ Concurrency Handling

Implemented using:

```java id="0n5hzr"
@Version
private Integer version;
```

Prevents **double deduction / race conditions**

---

### ✔ Idempotency

Each payment request uses:

```java id="5t5u7w"
requestId
```

Prevents duplicate payment execution

---

### ✔ Kafka Event System

Every successful transaction triggers:

```java id="skt64l"
transaction-topic
```

Used for:

* notifications
* logging
* event processing

---

## 📈 Future Enhancements

* Redis caching
* Rate limiting
* Microservices split
* Fraud detection engine
* Frontend integration

---

## 👨‍💻 Author

**Ujjwal Pandey**
GitHub: https://github.com/UJJU0405

---

## ⭐ If you found this project useful, consider giving it a star

