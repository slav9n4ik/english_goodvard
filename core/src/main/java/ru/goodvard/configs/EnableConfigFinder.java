package ru.goodvard.configs;

import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(TYPE)
@Retention(RUNTIME)
@PropertySource(value = {"classpath:application.yaml"}, factory = CustomPropertySourceFactory.class)
public @interface EnableConfigFinder {
}
