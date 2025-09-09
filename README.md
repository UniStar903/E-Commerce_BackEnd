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

3. Configure MongoDB
Update application.properties:
spring.data.mongodb.uri=<Your_monogo_uri>

4. Build and Run
mvn clean install
mvn spring-boot:run

5. Test the application through postman or HTTPS

   there is a sample file in this location to read/ingest the json data
   src/main/resources/static/events.txt
   Post http://localhost:8080/api/events/ingest?filePath=<Enter the abosolute path to the entry.txt file> (eg: C:/ExampleUser/userName/Folder/e-commerce/e-commerce/src/main/resources/static/events.txt)

   Whenever you try to insert a data sample through
   GET http://localhost:8080/api/orders/ (eg: http://localhost:8080/api/orders/ORD001)
   this api endpoint
   , make sure that your json data should be like the example format given below
   {
    "orderId": "ORD001",
    "customerId": "CUST001",
    "items": [
        {
            "itemId": "P001",
            "qty": 2
        }
    ],
    "totalAmount": 100.0,
    "status": "SHIPPED",
    "eventHistory": [
        {
            "eventId": "e1",
            "timestamp": "2025-07-29T10:00:00Z",
            "eventType": "OrderCreated",
            "orderId": "ORD001",
            "customerId": "CUST001",
            "items": [
                {
                    "itemId": "P001",
                    "qty": 2
                }
            ],
            "totalAmount": 100.0
        },
        {
            "eventId": "e2",
            "timestamp": "2025-07-29T11:00:00Z",
            "eventType": "PaymentReceived",
            "orderId": "ORD001",
            "amountPaid": 100.0
        },
        {
            "eventId": "e3",
            "timestamp": "2025-07-29T12:00:00Z",
            "eventType": "ShippingScheduled",
            "orderId": "ORD001",
            "shippingDate": "2025-07-30"
        }
    ]
}

