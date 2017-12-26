/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2017 VTB Group. All rights reserved.
 */

package ru.vtb.dbo.state;

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
