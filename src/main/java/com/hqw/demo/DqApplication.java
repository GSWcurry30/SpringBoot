package com.hqw.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.hqw.demo.filter")
public class DqApplication {

    public static void main(String[] args) {
        SpringApplication.run(DqApplication.class, args);
    }

}

