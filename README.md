# Restaurant Booking API

This project is a simple RESTful API for managing bookings at a restaurant. It allows customers to make booking requests and the restaurant owner to view all bookings for a specific day.

## Requirements

- Java 11 or higher
- Maven

## Setup and Running

1. Clone the repository.
2. Navigate to the project directory and run `mvn clean install` to build the project.
3. Start the server with `java -jar target/restaurant-booking-api-1.0-SNAPSHOT.jar`.
4. Use a tool like Postman or curl to interact with the API.

## Endpoints




##Curl commands to test code 
### Request a Booking for customer
curl -X POST http://localhost:{portnumber}/bookings \
-H "Content-Type: application/json" \
-d '{"customerName": "John Doe", "tableSize": 5, "startTime": "2024-03-01T19:00:00Z","endTime": "2024-03-01T19:30:00Z"}'

### Get request for getting Booking details for Resturant owner
curl -X GET "http://localhost:{portnumber}/bookings?date=2024-03-01" \
-H "Accept: application/json"

