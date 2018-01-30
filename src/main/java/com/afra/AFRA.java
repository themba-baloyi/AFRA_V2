package com.afra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:application.yaml"})
public class AFRA {
    public static void main(String[] args) {
        SpringApplication.run(AFRA.class, args);
    }
}
