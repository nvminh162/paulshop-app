# Laptop Shop Application

## Overview
Laptop Shop is a comprehensive e-commerce web application built using Spring MVC and Spring Boot. This application provides a platform for selling laptops online with features for both customers and administrators. The system includes product management, user authentication, shopping cart functionality, and order processing.

## Technology Stack

### Desin Pattern in project
- Domain-driven design
- Repository pattern

### Backend
- **Java 17**
- **Spring Boot 3.2.2**
- **Spring MVC** - Web framework
- **Spring Security** - Authentication and authorization
- **Spring Data JPA** - Database interaction
- **Hibernate** - ORM tool
- **MySQL** - Database

### Frontend
- **JSP (Jakarta Server Pages)** - Server-side templating
- **JSTL** - JSP Standard Tag Library
- **Bootstrap** - Responsive design
- **CSS/JavaScript** - Frontend styling and interactivity

### Build & Deployment
- **Maven** - Dependency management and build automation
- **Docker** - Containerization
- **Docker Compose** - Multi-container application orchestration

## Features

### Customer Features
- **Product Browsing** - Browse through available laptop products
- **Product Search** - Search for products by various criteria
- **User Registration/Login** - Create accounts and log in
- **Shopping Cart** - Add/remove products to/from shopping cart
- **Order Management** - Place and track orders
- **Responsive Design** - Optimized for different device sizes

### Admin Features
- **Dashboard** - Overview of sales and system statistics
- **Product Management** - Add, edit, delete products
- **User Management** - Manage user accounts
- **Order Processing** - View and manage customer orders

## Project Structure

```
laptopshop/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── vn/hoidanit/laptopshop/
│   │   │       ├── config/         # Application configuration
│   │   │       ├── controller/     # MVC controllers
│   │   │       │   ├── admin/      # Admin controllers
│   │   │       │   └── client/     # Client controllers
│   │   │       ├── domain/         # Entity classes
│   │   │       ├── repository/     # Data access layer
│   │   │       └── service/        # Business logic layer
│   │   ├── resources/
│   │   │   └── application.properties  # Application settings
│   │   └── webapp/
│   │       ├── resources/          # Static resources
│   │       │   ├── client/         # Client-side resources
│   │       │   └── admin/          # Admin-side resources
│   │       └── WEB-INF/
│   │           └── view/           # JSP templates
│   └── test/                       # Test classes
├── docker-compose.yml              # Docker Compose configuration
├── Dockerfile                      # Docker build configuration
└── pom.xml                         # Maven project configuration
```

## Database Schema
The application uses MySQL with the following key entities:
- **User** - Stores user account information and credentials
- **Product** - Contains product details including price, description, and inventory
- **Cart** - Represents user shopping carts
- **CartDetail** - Contains details of items in a cart
- **Order** - Represents customer orders
- **OrderDetail** - Contains details of items in an order
- **Role** - Defines user roles for authorization

## Setup and Installation

### Prerequisites
- Java 17 or higher
- Maven
- MySQL Server
- Docker (optional, for containerized deployment)

### Local Development Setup

1. **Clone the repository**
   ```bash
   git clone [repository-url]
   cd laptopshop
   ```

2. **Configure MySQL database**
   - Create a MySQL database named `laptopshop`
   - Update database credentials in `src/main/resources/application.properties` if needed:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/laptopshop
     spring.datasource.username=root
     spring.datasource.password=root (your setting >,<>)
     ```

3. **Build the application**
   ```bash
   ./mvnw clean package
   ```

4. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Access the application**
   - Open a web browser and navigate to `http://localhost:8080`

### Docker Deployment

1. **Build and run with Docker Compose**
   ```bash
   docker compose -p hoidanit-spring-mvc up -d
   ```

2. **Access the application**
   - Open a web browser and navigate to `http://localhost:8080`

## Configuration Options

### File Upload
The application supports file uploads with the following configuration:
```properties
spring.servlet.multipart.max-file-size=50MB
spring.servlet.multipart.max-request-size=50MB
```

### Security
Spring Security is configured for both authentication and authorization, with separate roles for customers and administrators.

## Troubleshooting

### Common Issues
1. **Database Connection Issues**
   - Ensure MySQL is running and accessible
   - Verify database credentials in application.properties

2. **Build Failures**
   - Make sure Java 17 is installed and configured correctly
   - Ensure Maven is installed and added to PATH

3. **Docker Issues**
   - Verify Docker and Docker Compose are installed
   - Check if ports 8080 and 3306/3307 are available

## Development Guidelines

### Adding New Features
1. Create appropriate domain/entity classes
2. Create repository interfaces extending JpaRepository
3. Implement service classes with business logic
4. Create controller endpoints
5. Create JSP views

### Code Style
- Follow standard Java coding conventions
- Use proper JavaDoc comments for methods and classes
- Organize imports alphabetically

## Author
[@nvminh162](https://www.facebook.com/nvminh162)
