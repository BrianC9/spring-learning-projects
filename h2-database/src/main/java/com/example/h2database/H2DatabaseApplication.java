package com.example.h2database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class H2DatabaseApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context= SpringApplication.run(H2DatabaseApplication.class, args);

    }

}
