package me.xerosoft.controllers;

import me.xerosoft.models.Entity;
import me.xerosoft.models.Restaurant;
import me.xerosoft.services.RestaurantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by xero on 8/6/18.
 */
@RestController
@RequestMapping("/v1/restaurants")
public class RestaurantController {
    protected Logger logger = Logger.getLogger(RestController.class.getName());

    protected RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<Collection<Restaurant>> findByName(@RequestParam(value = "name", defaultValue = "") String name) {
        logger.info(String.format("restaurant-service findByName invoked: %s for %s", restaurantService.getClass().getName(), name));

        name = name.trim().toLowerCase();

        Collection<Restaurant> restaurants;
        try {
            restaurants = restaurantService.findByName(name);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised by findByName REST call", ex);
            return new ResponseEntity<Collection<Restaurant>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (restaurants.size() > 0)
            return new ResponseEntity<Collection<Restaurant>>(restaurants, HttpStatus.OK);
        return new ResponseEntity<Collection<Restaurant>>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Restaurant> add(@RequestBody Restaurant restaurantVO ) {
        logger.info(String.format("restaurant-service add() invoked: %s for %s", restaurantService.getClass().getName(), restaurantVO.getName()));

        Restaurant restaurant = new Restaurant(null, null, null);
        BeanUtils.copyProperties(restaurantVO, restaurant);

        try {
            restaurantService.add(restaurant);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised add Restaurant REST Call", ex);
            return new ResponseEntity<Restaurant>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<Restaurant>(restaurant, HttpStatus.CREATED);
    }

    @GetMapping("/{restaurant_id}")
    public ResponseEntity<Entity> findById(@PathVariable("restaurant_id") String restaurantId) {
        logger.info(String.format("restaurant-service findById() invoked: %s for %s", restaurantService.getClass().getName(), restaurantId));
        restaurantId = restaurantId.trim();
        Entity restaurant;

        try {
            restaurant = restaurantService.findById(restaurantId);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised findById REST Call", ex);
            return new ResponseEntity<Entity>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (restaurant != null)
            return new ResponseEntity<Entity>(restaurant, HttpStatus.OK);
        return new ResponseEntity<Entity>(HttpStatus.NO_CONTENT);

    }
}
