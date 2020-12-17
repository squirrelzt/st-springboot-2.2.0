package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SwaggerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SwaggerApplication.class).run();
    }
}
