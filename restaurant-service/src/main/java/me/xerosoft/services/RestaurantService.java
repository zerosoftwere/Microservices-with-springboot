package me.xerosoft.services;

import me.xerosoft.models.Entity;
import me.xerosoft.models.Restaurant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Created by xero on 8/6/18.
 */
@Service
public interface RestaurantService {
    void add(Restaurant restaurant) throws Exception;

    void update(Restaurant restaurant) throws Exception;

    void delete(String id) throws Exception;

    Entity findById(String restaurantId) throws Exception;

    Collection<Restaurant> findByName(String name) throws Exception;

    Collection<Restaurant> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
