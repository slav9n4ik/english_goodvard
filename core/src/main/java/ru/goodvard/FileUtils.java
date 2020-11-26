package ru.goodvard;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Slf4j
public class FileUtils {
    public static String readFromResource(Resource resource) {
        try {
            return new String(resource.getInputStream().readAllBytes());
        } catch (IOException e) {
            log.error("Can't load html template file");
            throw new RuntimeException();
        }
    }
}
