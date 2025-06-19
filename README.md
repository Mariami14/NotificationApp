# Customer Notification Address Facade System

## Overview

This project is a **Customer Notification Address Facade System**, a microservice designed to centralize and manage customer contact information and notification preferences. It acts as a **single source of truth** for recipient addresses and delivery statuses, allowing other systems to fetch or update customer delivery data efficiently.

## Technologies Used

* **Backend**: Java 17 with Spring Boot 3.5.0
* **Frontend**: HTML
* **Templating Engine**: Thymeleaf
* **Security**: Spring Security
* **Database**: MySQL (with Hibernate JPA)
* **Build Tool**: Maven

## Project Structure

```
src/main/java/com/marie/notification/
├── config/                     # Security and password configurations
├── controller/                 # Web controllers
├── dto/                        # DTO and request classes
│   └── request/                # Request DTOs
├── exception/                  # Global exception handling
├── mapper/                     # Mappers from DTO to Entity
├── model/                      # Entity classes and enums
├── repository/                 # JPA repositories
├── service/                    # Service interfaces and implementations
└── NotificationApplication.java # Main application entry point

src/main/resources/
├── static/                     
├── templates/                  # Thymeleaf HTML templates
│   ├── address/
│   ├── customer/
│   ├── auth/
│   ├── homePage.html
│   └── index.html
└── application.properties      # Spring configuration
```
## Database Schema
![image](https://github.com/user-attachments/assets/dfa65239-2a0b-491f-b4a7-80d955a8643a)

## How to Run the Project

1. **Clone the project**
2. **Create a MySQL database**:

   ```sql
   CREATE DATABASE notification;
   ```
3. **Update database credentials in `application.properties`**:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/notification
   spring.datasource.username=root
   spring.datasource.password=
   ```
4. **Build and run the project**:

   ```bash
   ./mvnw spring-boot:run
   ```
5. **Access the application**:

   * Visit: `http://localhost:8080`
   

## Maven Dependencies

All dependencies are defined in `pom.xml`, including:

* `spring-boot-starter-web`
* `spring-boot-starter-security`
* `spring-boot-starter-data-jpa`
* `spring-boot-starter-thymeleaf`
* `mysql-connector-j`
* `lombok`

## Endpoints Overview

### 🌐 Web Endpoints (Thymeleaf)

* `/customer/list` — List customers
* `/customer/new` — Form to add a new customer
* `/customer/edit/{id}` — Edit a customer
* `/customer/delete/{id}` — Delete customer
* `/address/list` — List of addresses
* `/address/new` — Form to add new address
* `/register` — Registration page
* `/login` — Login page



### Sample Request: Notification Status Submission

```json
{
  "customerId": 1,
  "notificationType": "EMAIL",
  "deliveryDate": "2024-06-15T18:30:00",
  "status": "DELIVERED"
}
```

## Security

* Spring Security is configured with form login.
* Users are stored in `sys_users` table.
* Passwords are encoded using `BCryptPasswordEncoder`.

## Notes

* Roles are defined using enum `Roles.java`
* Addresses and Notification Types use enums `AddressType.java`,`NotificationTracker.java`  and `NotificationTypes.java`
* Custom exception handling can be extended in `GlobalExceptionHandler.java`




