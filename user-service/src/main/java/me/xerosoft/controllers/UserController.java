package me.xerosoft.controllers;

import me.xerosoft.models.User;
import me.xerosoft.services.UserService;
import me.xerosoft.valueobjects.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by xero on 8/10/18.
 */
@RestController
@RequestMapping("/v1/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Collection<User>> findByName(@RequestParam String name) {
        name = name.toLowerCase();
        Collection<User> users;
        try {
            users = userService.findByName(name);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (users.size() > 0)
            return new ResponseEntity<>(users, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody UserVO userVO) {
        User user = new User(null, null, null, null, null);
        BeanUtils.copyProperties(userVO, user);
        try {
            userService.add(user);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<User> findById(@PathVariable("user_id") String userId) {
        userId = userId.trim();
        User user;
        try {
            user = userService.findById(userId);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (user != null) return new ResponseEntity<>(user, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
