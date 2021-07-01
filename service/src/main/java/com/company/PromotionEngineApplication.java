package com.company;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:configuration.properties.xml"})
public class PromotionEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(PromotionEngineApplication.class, args);
    }


    /*
    Time's up.
    Adding the other promotions is easy enough now that the whole engine is up.
    A few things I'd like to add are:
    - SLF4J logging
    - integration test with Spring MVC
    - Dockerize the engine and have 3 replicas


     */
}
