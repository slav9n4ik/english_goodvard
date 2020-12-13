package ru.goodvard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.goodvard.configs.EnableConfigFinder;

@EnableConfigFinder
@SpringBootApplication
public class CoreStarter {
    public static void main(String[] args) {
        SpringApplication.run(CoreStarter.class, args);
    }
}
