package com.basic.app.Springboot.controller;

import com.basic.app.Springboot.dto.UserDto;
import com.basic.app.Springboot.dto.UserResponse;
import com.basic.app.Springboot.entity.User;
import com.basic.app.Springboot.exception.UserExistsException;
import com.basic.app.Springboot.exception.UserNotFoundException;
import com.basic.app.Springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder){

        try{
             userService.createUser(user);
            HttpHeaders headers=new HttpHeaders();
            headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<Void>(headers,HttpStatus.CREATED);

        }catch (UserExistsException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }

    }



    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){

        try{
            return userService.getUserById(id);

        } catch (UserNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }



    @PutMapping("/users/{id}")
    public User updateUserId(@PathVariable Long id, @RequestBody User user){
        try{
            return userService.updateUserById(id,user);
        } catch (UserNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
    }



    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable Long id){
            return userService.deleteUserById(id);
    }


    @GetMapping("/users/username/{userName}")
    public Optional<User> findUserByUserName(@PathVariable String userName){
        return userService.getUserByUserName(userName);
    }

    /*@GetMapping("/users")
    public User getUserByUsername(@RequestParam String username) */

    @GetMapping("/users/username")
    public Optional<User> findByUserNames(@RequestParam String userName){
        return userService.getUserByUserName(userName);
    }

}
