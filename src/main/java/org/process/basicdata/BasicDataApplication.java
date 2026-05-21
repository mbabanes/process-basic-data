package org.process.basicdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class BasicDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicDataApplication.class, args);
    }

}
