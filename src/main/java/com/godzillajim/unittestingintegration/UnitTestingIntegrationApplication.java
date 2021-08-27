package com.godzillajim.unittestingintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("com.godzillajim.unittestingintegration.entities.*")
public class UnitTestingIntegrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(UnitTestingIntegrationApplication.class, args);
    }
}
