package ru.goodvard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.goodvard.configs.EnableConfigFinder;

@EnableScheduling
@EnableConfigFinder
@SpringBootApplication
public class CoreStarter {
    public static void main(String[] args) {
        SpringApplication.run(CoreStarter.class, args);
    }
}
