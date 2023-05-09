package org.kamenchuk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GateWayModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayModuleApplication.class, args);
    }

}
