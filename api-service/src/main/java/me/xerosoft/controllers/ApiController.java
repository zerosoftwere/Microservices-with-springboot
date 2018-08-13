package me.xerosoft.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import me.xerosoft.models.Restaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by xero on 8/10/18.
 */
@RestController
@RequestMapping("/services")
public class ApiController {

    private RestTemplate restTemplate;
    private DiscoveryClient discoveryClient;

    private Logger logger = LoggerFactory.getLogger(ApiController.class.getName());

    @Autowired
    public ApiController(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<String> home() {
        return discoveryClient.getServices();
    }

    @GetMapping("/restaurants/{restaurant_id}")
    @HystrixCommand(fallbackMethod = "getDefaultRestaurant")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("restaurant_id") String restaurantId) {
        String url = String.format("http://restaurant-service/v1/restaurants/%s", restaurantId);
        ResponseEntity<Restaurant> response = restTemplate.getForEntity(url, Restaurant.class);

        logger.info("Get restaurant http-status: {}", response.getStatusCode());
        logger.debug("Get restaurant body: ", response.getBody());

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

    @GetMapping("/restaurants")
    @HystrixCommand(fallbackMethod = "defaultFindRestaurantByName")
    public ResponseEntity<Collection<Restaurant>> findRestaurantsByName(@RequestParam(value = "name", defaultValue = "") String name) {
        String url = String.format("http://restaurant-service/v1/restaurants?name=%s", name);
        ResponseEntity<Collection> response = restTemplate.getForEntity(url,Collection.class);

        logger.info("Get restaurant http-status: {}", response.getStatusCode());
        logger.debug("Get restaurant body: ", response.getBody());

        return new ResponseEntity<Collection<Restaurant>>(response.getBody(), HttpStatus.OK);
    }

    public ResponseEntity<Restaurant> getDefaultRestaurant(@PathVariable("restaurant_id") String restaurantId) {
        logger.warn("Invoking default get restaurant");
        Restaurant restaurant = new Restaurant("0", "Fallback Restaurant", null);
        return ResponseEntity.ok(restaurant);
    }

    public ResponseEntity<Collection<Restaurant>> defaultFindRestaurantByName(@RequestParam(value = "name", defaultValue = "") String name) {
        return new ResponseEntity<>(Collections.EMPTY_LIST, HttpStatus.NO_CONTENT);
    }
}
