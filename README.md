# 🐋 Orka – Event-Driven Microservices Demo with Kafka

**Orka** is a practice project demonstrating an event-driven microservices architecture using **Spring Boot** and **Apache Kafka** as the message broker. This system simulates real-world communication between microservices like `order-service`, `stock-service`, and `email-service` without connecting any database or frontend — focusing solely on backend messaging via Kafka.

---

## 📦 Microservices Overview

1. **Base-Domains**  
   Shared DTOs and Kafka event models used by all services for communication.

2. **Order-Service** 🛒  
   Produces an `OrderPlacedEvent` to Kafka when an order is created.

3. **Stock-Service** 📦  
   Listens for `OrderPlacedEvent`, simulates stock processing, and logs the event.

4. **Email-Service** 📧  
   Also listens for `OrderPlacedEvent`, simulates sending confirmation email, and logs the activity.

---

## 🎯 Project Goals

- Practice **Apache Kafka**-based messaging in a microservice setup.
- Simulate asynchronous communication via **event publishing and consuming**.
- Validate end-to-end flow using **console logs** (no actual DB/email integration).

---

## 🛠️ Tech Stack

- Java 24
- Spring Boot
- Apache Kafka
- Spring Cloud Stream (Kafka Binder)
- Lombok
- SLF4J Logger

---

## ⚙️ How It Works

```text
(order-service) 
     ⬇ Produces OrderPlacedEvent
(Kafka Topic: order-events)
     ⬇ Consumed by:
         ├── stock-service → Logs stock update simulation
         └── email-service → Logs email send simulation
