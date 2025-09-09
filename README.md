E-Commerce Backend Application

#Overview
This is a Spring Boot-based backend system that handles order-related events such as:

Order creation
Payment receipt
Shipping scheduling
Order cancellation
The system uses MongoDB for persistence and implements an observer pattern to notify external systems (via console logs) when order status changes or a new event is processed.

Technology Stack
Spring Boot 3
MongoDB
Lombok for boilerplate reduction
Jackson for JSON parsing
RESTful APIs for all operations
Java 20

Setup Instructions
1. Clone the repository
git clone https://github.com/UniStar903/E-Commerce_BackEnd.git
cd e-commerce-backend

2. Configure MongoDB
Update application.properties:
spring.data.mongodb.uri=

3. Build and Run
mvn clean install
mvn spring-boot:run

