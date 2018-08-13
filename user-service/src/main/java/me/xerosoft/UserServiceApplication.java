package me.xerosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by xero on 8/10/18.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UserServiceApplication {
    public static void main(String... args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
