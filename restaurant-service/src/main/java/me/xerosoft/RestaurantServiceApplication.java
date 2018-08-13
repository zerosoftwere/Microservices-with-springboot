package me.xerosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by xero on 8/7/18.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class RestaurantServiceApplication {
    public static void main(String... args) {
        SpringApplication.run(RestaurantServiceApplication.class, args);
    }
}
