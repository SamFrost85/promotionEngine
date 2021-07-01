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

}
