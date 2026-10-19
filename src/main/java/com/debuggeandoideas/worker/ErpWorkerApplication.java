package com.debuggeandoideas.worker;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.EnableJdbcJobRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableBatchProcessing
@EnableJdbcJobRepository
public class ErpWorkerApplication {

    static void main(String[] args) {
        SpringApplication.run(ErpWorkerApplication.class, args);
    }

}