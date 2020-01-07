package com.matheusvargas481.spring_bootpostgresqldocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootPostgresqlDockerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootPostgresqlDockerApplication.class, args);
    }
}
