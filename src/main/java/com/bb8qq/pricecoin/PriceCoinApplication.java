package com.bb8qq.pricecoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PriceCoinApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriceCoinApplication.class, args);
    }

}
