package com.example.zaman_cizelgesi_sistemi.controller;

import com.example.zaman_cizelgesi_sistemi.entity.User;
import com.example.zaman_cizelgesi_sistemi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/email/{eposta}")
    public List<User> getUsersByEmail(@PathVariable String eposta) {
        return userService.getUsersByEmail(eposta);
    }
}
