package com.publicssapient.weather;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Publics Sapient - Weather API",
                version = "1.0.0",
                description = "Weather API Documentation"
        ),
        servers = @Server(
                url = "http://localhost:8080",
                description = "Weather API Local Server"
        )
)
public class WeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args);
    }

}
