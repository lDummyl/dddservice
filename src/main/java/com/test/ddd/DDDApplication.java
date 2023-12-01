package com.test.ddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableRetry
@ConfigurationPropertiesScan
@EnableFeignClients
@EnableScheduling
@SpringBootApplication
@EnableJpaAuditing
//@EnableLoadTimeWeaving //goes with -javaagent:{full-path}spring-instrument-6.0.11.jar
@EnableSpringConfigured
public class DDDApplication {

    public static void main(String[] args) {
        SpringApplication.run(DDDApplication.class, args);
    }

}
