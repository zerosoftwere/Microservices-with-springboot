package me.xerosoft.repositories;

import me.xerosoft.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xero on 8/10/18.
 */
@Repository
public class InMemUserRepository implements UserRepository {

    private Map<String, User> entities;

    public InMemUserRepository() {
        entities = new HashMap<>();

        User user = new User("1", "User Name 1", "Address 1", "City 1", "9999911111");
        entities.put("1", user);

        User user2 = new User("1", "User Name 2", "Address 2", "City 2", "9999922222");
        entities.put("2", user2);
    }

    @Override
    public void add(User entity) {
        entities.put(entity.getId(), entity);
    }

    @Override
    public void update(User entity) {
        if (entities.containsKey(entity.getId())) {
            entities.put(entity.getId(), entity);
        }
    }

    @Override
    public void remove(String id) {
        if (entities.containsKey(id)) {
            entities.remove(id);
        }
    }

    @Override
    public User get(String id) {
        return entities.get(id);
    }

    @Override
    public boolean contains(String id) {
        throw new UnsupportedOperationException("Method not supported yet.");
    }

    @Override
    public Collection<User> getAll() {
        return entities.values();
    }

    @Override
    public boolean containsName(String name) {
        try {
            return findByName(name).size() > 0;
        } catch(Exception ex)  {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Collection<User> findByName(String name) throws Exception {
        Collection<User> users = new ArrayList<>();
        entities.forEach((k, v) -> {
            if (v.getName().toLowerCase().contains(name))
                users.add(v);
        });
        return users;
    }
}
