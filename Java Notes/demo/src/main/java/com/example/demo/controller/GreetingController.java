package com.example.demo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;

@RestController
public class GreetingController {

    private static List<User> users;
    private int count = 1;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/hello/{name}")
    public String personalGreeting(@PathVariable String name) {
        return "Hello " + name;
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        user.setId(count);
        users.add(user);
        count++;
        return user;
    }

    @GetMapping("/user/{index}")
    public ResponseEntity<User> getUser(@PathVariable int index) {
        return new ResponseEntity<>(users.get(index), HttpStatus.OK);
    }
}
