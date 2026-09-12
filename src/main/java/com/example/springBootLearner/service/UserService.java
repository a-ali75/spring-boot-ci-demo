package com.example.springBootLearner.service;

import com.example.springBootLearner.exceptions.UserNotFoundException;
import com.example.springBootLearner.model.User;
import com.example.springBootLearner.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private UserRepository userRepository;
    //private Map<Integer, User> userMap = new HashMap<>();
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
//        if (userMap.containsKey(user.getId())) {
//            logger.atDebug().log("User Already Exists");
//            return "User already exists with this Id :: " + user.getId();
//        } else {
//            userMap.put(user.getId(), user);
//            return "User Created!!";
//        }
        return userRepository.save(user);

    }

    public User updateUser(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            //userMap.put(user.getId(), user);
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User with ID " + user.getId() + " not found!!");
        }
    }

    public User getUser(Integer id) {
//        if (userMap.containsKey(id)) {
//            return userMap.get(id);
//        } else {
//            throw new IllegalArgumentException("User with ID " + id + " not found!!");
//        }

        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        } else {
            throw new IllegalArgumentException("User with ID " + id + " not found!!");
        }
    }

    public User deleteUser(Integer id) {
//        if (userMap.containsKey(id)) {
//            User user = userMap.get(id);
//            userMap.remove(id);
//            return user;
//        } else {
//            throw new UserNotFoundException("User with ID " + id + " not found!!");
//        }

        if (userRepository.findById(id).isPresent()) {
            User user = userRepository.findById(id).get();
            userRepository.delete(user);
            return user;
        } else {
            throw new UserNotFoundException("User with ID " + id + " not found!!");
        }
    }

    public List<User> getUsers() {
        //return userMap.values().stream().toList();
        return userRepository.findAll();
    }
}
