# Quiz Microservices Project

This project consists of multiple microservices: `Quiz-Service`, `Question-Service`, a Service Registry using Eureka, and an API Gateway. Each service interacts with the others through RESTful APIs, and the API Gateway handles all incoming requests.

## Project Structure

1. **Service Registry** (`Service-Registry`): A Eureka server that registers all services.
2. **Question Service** (`Question-Service`): Manages questions related to quizzes.
3. **Quiz Service** (`Quiz-Service`): Manages quizzes and their associated questions.
4. **API Gateway** (`API-Gateway`): Routes requests to the appropriate service.

## Database Schema

### Question Service
The application uses a MySQL database named `Question`, which contains a single table named `Question` with the following columns:
- `id`: Unique identifier for the question.
- `title`: The question text.
- `quizid`: The ID of the quiz this question belongs to.

### Quiz Service
The application uses a MySQL database named `quiz`, which contains a single table named `Quiz` with the following columns:
- `id`: Unique identifier for the quiz.
- `title`: The title of the quiz.
- `questions`: A transient field that holds a list of questions (this field is not stored in the database).

## Tools and Frameworks
- **Spring Boot**: For creating microservices.
- **Spring Cloud Netflix Eureka**: For service registration and discovery.
- **Spring Cloud Gateway**: For routing requests to appropriate microservices.
- **MySQL**: For database management.
- **JPA**: For database interaction.
- **Postman**: For testing RESTful APIs.

## Setup Instructions

### Install Required Tools
1. **IntelliJ IDEA** or any other Java IDE.
2. **MySQL** for database management.

### Setup MySQL Database
1. Create two databases: `Question` and `quiz` in MySQL Workbench.
2. Ensure that the MySQL service is running.

### Configure Application Properties
1. Update the `application.properties` files in the `Question-Service` and `Quiz-Service` projects with your MySQL setup:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

### Run the Application
1. Start the Eureka server (`Service-Registry`) on port 8383.
2. Start the `Question-Service` on port 8181.
3. Start the `Quiz-Service` on port 8282.
4. Start the `API-Gateway` on port 8585.

### Testing with Postman

#### **Question-Service**:

1. **Add a Question**:
   - **POST** `http://localhost:8181/Question`
   - **Request Body**:
     ```json
     {
       "title": "What is Java?",
       "quizid": 1
     }
     ```

2. **Get Question by ID**:
   - **GET** `http://localhost:8181/Question/{id}`

3. **Get Questions by Quiz ID**:
   - **GET** `http://localhost:8181/Question/question/{quizid}`

4. **Get All Questions**:
   - **GET** `http://localhost:8181/Question`

#### **Quiz-Service**:

1. **Add a Quiz**:
   - **POST** `http://localhost:8282/Quiz`
   - **Request Body**:
     ```json
     {
       "title": "Java Basics"
     }
     ```

2. **Get Quiz by ID**:
   - **GET** `http://localhost:8282/Quiz/{id}`

3. **Get All Quizzes**:
   - **GET** `http://localhost:8282/Quiz`

#### **API Gateway**:
- Test the same endpoints through the API Gateway:

1. **Get All Quizzes**:
   - **GET** `http://localhost:8585/Quiz`

2. **Get All Questions**:
   - **GET** `http://localhost:8585/Question`

### Running Unit Tests
Once the application is set up, you can run unit tests to ensure everything is working as expected. Use `mvn test` or your IDE's testing tools.

## Conclusion
This project demonstrates how to create a microservices architecture using Spring Boot, Spring Cloud Netflix Eureka, and Spring Cloud Gateway. Each service is independently deployable and interacts through RESTful APIs, making the system flexible and scalable.
