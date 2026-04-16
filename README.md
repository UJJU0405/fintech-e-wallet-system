# fintech-e-wallet-system
Production-grade E-Wallet backend system with UPI simulation, concurrency handling, idempotency, and event-driven architecture using Spring Boot.
# 💰 Fintech E-Wallet System

A **production-grade backend system** simulating real-world digital payment platforms like UPI (Google Pay / PhonePe).
Built with focus on **scalability, security, and transaction reliability**.

---

## 🚀 Key Highlights

* 🔐 JWT-based Authentication & Authorization
* 💸 Wallet Top-up & Peer-to-Peer Transfers
* 🏦 **UPI Simulation (user@bank ID + collect requests)**
* ⚡ **Concurrency Handling (Optimistic Locking)**
* 🔁 **Idempotent Transactions (Duplicate prevention)**
* 📡 **Event-Driven Architecture (Kafka / Queue-based)**
* 🔄 **Transaction Retry Mechanism**
* 📊 Transaction Audit Logging
* 🔔 Real-time Notifications (WebSockets)

---

## 🧠 System Design

### Architecture:

* Controller Layer
* Service Layer
* Repository Layer
* Security Layer
* Event Layer

### Flow:

1. User initiates transaction
2. System validates balance + UPI PIN
3. Idempotency check prevents duplicates
4. Transaction processed with concurrency control
5. Event published → Notification & Logging services
6. Final status returned (SUCCESS / FAILED / PENDING)

---

## ⚙️ Tech Stack

### Backend:

* Java
* Spring Boot
* Spring Security (JWT)
* Hibernate / JPA

### Database:

* MySQL
* MongoDB (logs)

### Messaging:

* Kafka / RabbitMQ

### DevOps:

* Docker
* AWS (EC2, S3)

---

## 📂 Project Structure

```
src/main/java/com/fintech/
│
├── controller/
├── service/
├── repository/
├── model/
├── security/
├── config/
├── event/
└── util/
```

---

## 🔗 API Endpoints

### Auth

* POST /api/auth/register
* POST /api/auth/login

### Wallet

* POST /api/wallet/add-money
* POST /api/wallet/transfer

### UPI

* POST /api/upi/send
* POST /api/upi/request
* POST /api/upi/approve

### Transactions

* GET /api/transactions

---

## 🔐 Advanced Features

### 1. UPI Simulation

* Unique UPI ID (user@bank)
* Send & collect money
* PIN verification

### 2. Concurrency Handling

* Prevents double spending
* Implemented using Optimistic Locking

### 3. Idempotency

* Prevents duplicate transactions
* Uses unique request ID

### 4. Retry Mechanism

* Automatic retry on failure
* Exponential backoff strategy

### 5. Event-Driven System

* Kafka-based transaction events
* Decoupled notification & logging services

---

## 🧪 Testing

* Postman Collection included
* Covers all APIs

---

## 🐳 Running with Docker

```
docker build -t ewallet .
docker run -p 8080:8080 ewallet
```

---

## ▶️ Run Locally

```
git clone https://github.com/your-username/fintech-e-wallet-system.git
cd fintech-e-wallet-system
mvn spring-boot:run
```

---

## 📈 Future Enhancements

* 💳 Payment Gateway Integration
* 🌍 Multi-currency Wallet
* 🤖 AI-based Fraud Detection
* 📱 Frontend (React)

---

## 🧑‍💻 Author

Ujjwal
LinkedIn | GitHub

---

## ⭐ If you like this project, give it a star!
