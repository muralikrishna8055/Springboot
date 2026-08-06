package com.basic.app.Springboot.controller;

import com.basic.app.Springboot.dto.UserDto;
import com.basic.app.Springboot.dto.UserResponse;
import com.basic.app.Springboot.entity.User;
import com.basic.app.Springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userController")
    public UserDto userController(){
        return new UserDto("Murali","Krishna","Adoor");
    }


    @GetMapping("/users")
    public List<UserResponse>getAllUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public User updateUserId(@PathVariable Long id, @RequestBody User user){
        return userService.updateUserById(id,user);
    }

}
