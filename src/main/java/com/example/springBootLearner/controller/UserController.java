package com.example.springBootLearner.controller;

import com.example.springBootLearner.model.User;
import com.example.springBootLearner.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers() {
        List<User> usersList = userService.getUsers();
        if (usersList == null || usersList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(usersList);
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        if (updatedUser != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("User Updated");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Doesn't exist");
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        User user = userService.deleteUser(id);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("User Deleted :: " + user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Doesn't exist");
        }

    }

    @GetMapping("/getUser")
    public ResponseEntity<String> getUser(@RequestParam(required = false, defaultValue = "0") Integer id) {
        User user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("User Retrieved :: " + user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Doesn't exist");
        }

    }
}
