# Weather Prediction

## Important Note
- **Port Used:** 8080
- **Credentials for API Authentication:**
    - Username: user
    - Password: password

## Flow Diagram
- The Flow diagram is provided for better understanding of the project.
```properties
Flow-Diagram.png
```

## Description
This project is a weather prediction application developed using Java, Spring Boot, and Gradle. It provides weather forecasts for different cities. The application fetches data from an external weather API and processes it to provide detailed weather forecasts.

## Technology Stack
- Java (Spring Boot)
- Gradle
- Swagger

### Prerequisites to have in local machine
- Java 21
- Gradle 3.2.2

## Working of the Application
The assignment requires development, testing, and deployment of a microservice to display the high and low temperatures for the next three days of a specified city. If rain is predicted in the next three days or if the temperature exceeds 40 degrees Celsius, the output for that day should include 'Carry umbrella' or 'Use sunscreen lotion' respectively with some additional requirements such as in case of high winds Wind 10mph mentionioning “It’s too windy, watch out!” and in case of Thunderstorms, mention “Don’t step out! A Storm is brewing!”.

## Rest API
The API has one endpoint:
1. /v1/weather/getWeatherByCity?city={city} - This endpoint fetches the weather forecast of 3 days of weather forecast including today's forecast for the given city.
2. /v1/weather/getAllWeatherByCity?city={city} - This endpoint fetches the detailed weather forecast of 5 days of weather forecast including today's forecast for the given city.

## Testing API with Curls
1. The API can be tested using Postman / React UI.

1.1 Get Weather of City for 3 days
```bash
curl --location 'http://localhost:8080/v1/weather/getWeatherByCity?city=london&isChecked=false' \
--header 'Authorization: Basic dXNlcjpwYXNzd29yZA=='
```
1.2 Get All Detail Weather Information of City for 5 days
```bash
curl --location 'http://localhost:8080/v1/weather/getAllWeatherByCity?city=london' \
--header 'Authorization: Basic dXNlcjpwYXNzd29yZA=='
```

## Swagger
1. Swagger is also included in the API .
2. Open your browser and navigate to the following URL:
```bash
http://localhost:8080/swagger-ui/index.html
```

## Exception Handling
1. Global Exception Handling is used to handle the exceptions in the API with '@ControllerAdvice' and '@ExceptionHandler' annotations.

## SOLID Principles
This project adheres to SOLID principles:

- **Single Responsibility Principle (SRP):** Each class has one responsibility. For instance, `WeatherClient` communicates with the weather API, `WeatherDetailsService` processes the weather data, and `WeatherController` handles HTTP requests and responses.

- **Open-Closed Principle (OCP):** Classes are open for extension but closed for modification. This is achieved by defining interfaces and implementing them in specific classes.

- **Interface Segregation Principle (ISP):** Each class should only need to know about the methods it actually uses. If the application uses interfaces, they should be small and specific rather than large and general.

- **Dependency Inversion Principle (DIP):** High-level modules should not depend on low-level modules. Both should depend on abstractions. This is achieved by using dependency injection to inject dependencies, such as services or repositories, into classes. This makes the code more flexible and easier to modify.

## HATEOAS Principles
- The API follows HATEOAS principles. It includes links to related resources in the response. For example, the response for the `/v1/weather/getWeatherByCity?city={city}` endpoint includes links to the `/v1/weather/getAllWeatherByCity?city={city}` endpoint.


