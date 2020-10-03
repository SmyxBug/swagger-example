package com.swagger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class SwaggerApp {
    private static Logger logger = LoggerFactory.getLogger(SwaggerApp.class);
    public static void main(String[] args) {
        SpringApplication.run(SwaggerApp.class, args);
        logger.info(">>>>>>>>>>>>>>>>>>>>> SwaggerApp is Running.......");
    }
}
