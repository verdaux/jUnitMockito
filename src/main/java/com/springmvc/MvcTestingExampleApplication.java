package com.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springmvc"})
@EnableAutoConfiguration
public class MvcTestingExampleApplication
{
    public static void main(String[] args) {
        SpringApplication.run(MvcTestingExampleApplication.class, args);
    }
}
