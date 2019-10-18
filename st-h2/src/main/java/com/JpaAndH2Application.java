package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class JpaAndH2Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(JpaAndH2Application.class).run(args);
    }
}
