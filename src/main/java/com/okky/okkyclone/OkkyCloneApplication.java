package com.okky.okkyclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class OkkyCloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(OkkyCloneApplication.class, args);
    }

}
