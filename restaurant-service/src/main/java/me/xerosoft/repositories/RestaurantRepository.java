package me.xerosoft.repositories;

import me.xerosoft.models.Restaurant;

import java.util.Collection;

/**
 * Created by xero on 8/7/18.
 */
public interface RestaurantRepository extends BaseRepository<Restaurant, String> {

    boolean containsName(String name) throws Exception;
    Collection<Restaurant> findByName(String name) throws Exception;
}
