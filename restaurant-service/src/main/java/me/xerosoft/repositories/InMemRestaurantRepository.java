package me.xerosoft.repositories;

import me.xerosoft.models.Entity;
import me.xerosoft.models.Restaurant;
import org.springframework.stereotype.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xero on 8/7/18.
 */
@Repository
public class InMemRestaurantRepository implements RestaurantRepository {

    private Map<String, Restaurant> entities;

    public InMemRestaurantRepository() {
        entities = new HashMap<>();

        Restaurant restaurant = new Restaurant("Big-O Restaurant", "1", null);
        entities.put(restaurant.getId(), restaurant);

        restaurant = new Restaurant("O Restaurant", "2", null);
        entities.put(restaurant.getId(), restaurant);
    }

    @Override
    public void add(Restaurant entity) {
        entities.put(entity.getId(), entity);
    }

    @Override
    public void remove(String id) {
        if (entities.containsKey(id)) {
            entities.remove(id);
        }
    }

    @Override
    public void update(Restaurant entity) {
        if (entities.containsKey(entity.getId())) {
            entities.put(entity.getId(), entity);
        }
    }

    @Override
    public boolean contains(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Entity get(String id) {
        return entities.get(id);
    }

    @Override
    public Collection<Restaurant> getAll() {
        return entities.values();
    }

    @Override
    public boolean containsName(String name) throws Exception {
        try {
            return this.findByName(name).size() > 0;
        } catch (Exception ex) {

        }
        return false;
    }

    @Override
    public Collection<Restaurant> findByName(String name) throws Exception {
        Collection<Restaurant> restaurants = new ArrayList<>();
        int noOfChars = name.length();

        entities.forEach((k, v) -> {
            if (v.getName().toLowerCase().contains(name.subSequence(0, noOfChars))) {
                restaurants.add(v);
            }
        });

        return restaurants;
    }
}
