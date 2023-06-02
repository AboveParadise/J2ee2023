package com.example.j2ee;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableSwaggerBootstrapUI
@EnableJpaRepositories
@SpringBootApplication
public class J2eeApplication {

    public static void main(String[] args) {
        SpringApplication.run(J2eeApplication.class, args);
    }

}
