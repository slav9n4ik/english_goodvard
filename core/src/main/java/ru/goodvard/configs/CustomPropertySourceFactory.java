package ru.goodvard.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Properties;

import static java.lang.System.getProperty;
import static java.util.stream.Collectors.joining;

@Slf4j
public class CustomPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) {
        String filename = "application.properties";
        String path = getProperty("user.home") + "/Projects/goodvard-config";

        Properties properties = new Properties();
        loadProps(filename, path, properties);

        printResult(name, properties);
        return new PropertiesPropertySource(filename, properties);
    }

    private void loadProps(String filename, String path, Properties properties) {
        try (InputStream input = new FileInputStream(path + "/" + filename)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void printResult(String name, Properties properties) {
        log.info("App Properties filename: {}", name);
        String allProperties = properties
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(e -> e.getKey().toString()))
                .map(e -> e.getKey() + "=" + (isPassword((String) e.getKey()) ? "***" : e.getValue()))
                .collect(joining("\n", "\n", "\n"));
        log.info(allProperties);
    }

    private boolean isPassword(String propKey) {
        propKey = propKey.toLowerCase();
        return propKey.contains("key") || propKey.contains("password");
    }
}
