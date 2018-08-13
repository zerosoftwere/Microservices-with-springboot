package me.xerosoft.services;

import me.xerosoft.models.User;
import me.xerosoft.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Created by xero on 8/10/18.
 */
@Service
public class UserServiceImpl extends BaseService<User, String> implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) throws Exception {
        if (userRepository.containsName(user.getName())) {
            throw new Exception("Username already taken");
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new Exception("Username cannot be null or empty");
        }
        userRepository.add(user);
    }

    @Override
    public void update(User user) throws Exception {
        userRepository.update(user);
    }

    @Override
    public void delete(String id) throws Exception {
        userRepository.remove(id);
    }

    @Override
    public User findById(String userId) throws Exception {
        return userRepository.get(userId);
    }

    @Override
    public Collection<User> findByName(String name) throws Exception {
        return userRepository.findByName(name);
    }

    @Override
    public boolean findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
