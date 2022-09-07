package com.example.pss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class PssApplication {

    public static void main(String[] args) {
        SpringApplication.run(PssApplication.class, args);
    }

}
