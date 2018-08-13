package me.xerosoft.services;

import me.xerosoft.models.Entity;
import me.xerosoft.models.Restaurant;
import me.xerosoft.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Created by xero on 8/7/18.
 */
@Service
public class RestaurantServiceImpl extends BaseService<Restaurant, String> implements RestaurantService{

    private RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        super(restaurantRepository);
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void add(Restaurant restaurant) throws Exception {
        if (restaurant.getName() == null || restaurant.getName().isEmpty()) {
            throw new Exception("Restaurant name cannot be null or an empty string");
        }
        if (restaurantRepository.containsName(restaurant.getName())) {
            throw new Exception(String.format("There is already a produce with name - %s", restaurant.getName()));
        }
        super.add(restaurant);
    }

    @Override
    public void update(Restaurant restaurant) throws Exception {
        restaurantRepository.update(restaurant);
    }

    @Override
    public void delete(String id) throws Exception {
        restaurantRepository.remove(id);
    }

    @Override
    public Entity findById(String restaurantId) throws Exception {
        return restaurantRepository.get(restaurantId);
    }

    @Override
    public Collection<Restaurant> findByName(String name) throws Exception {
        return restaurantRepository.findByName(name);
    }

    @Override
    public Collection<Restaurant> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
        // change the body of generated methods, choose Tools | Templates
    }
}
