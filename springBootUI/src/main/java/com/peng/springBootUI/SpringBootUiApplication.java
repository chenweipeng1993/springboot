package com.peng.springBootUI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication组合注解，兼备了@EnableAutoConfiguration和@ComponentScan 注解的功能。
 */
@SpringBootApplication
public class SpringBootUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootUiApplication.class, args);
    }
}
