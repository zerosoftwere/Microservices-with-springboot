package me.xerosoft.services;

import me.xerosoft.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Created by xero on 8/10/18.
 */
@Service
public interface UserService  {

    void add(User user) throws Exception;
    void update(User user) throws Exception;
    void delete(String id) throws Exception;

    User findById(String userId) throws Exception;
    Collection<User> findByName(String name) throws Exception;
    boolean findByCriteria(Map<String, ArrayList<String>> name) throws Exception;

}
