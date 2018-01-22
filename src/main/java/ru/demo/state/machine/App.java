package ru.demo.state.machine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Olga_Zlobina
 */
@SpringBootApplication
@EnableAutoConfiguration
public class App {

    /**
     * Start.
     */
    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }
}
