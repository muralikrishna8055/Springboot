package com.basic.app.Springboot.service;


import com.basic.app.Springboot.dto.UserResponse;
import com.basic.app.Springboot.entity.User;
import com.basic.app.Springboot.exception.UserNotFoundException;
import com.basic.app.Springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    // to find all records
    public List<UserResponse> getAllUsers(){
       //return userRepository.findAll();

        List<User>users=userRepository.findAll();
        List<UserResponse> userResponses=new ArrayList<>();

        for(User user: users){

            UserResponse mapper=new UserResponse();
            mapper.setUserName(user.getUsername());
            mapper.setId(user.getId());
            mapper.setEmail(user.getEmail());
            mapper.setFirstName(user.getFirstname());
            mapper.setLastName(user.getLastname());
            mapper.setRole(user.getRole());

            userResponses.add(mapper);
        }
        return userResponses;
    }



    // create user
    public User createUser(User request){
        return userRepository.save(request);
    }



    //get user by id
    public Optional<User> getUserById(Long id) throws UserNotFoundException {
        //return userRepository.findById(id);
        Optional<User> user=userRepository.findById(id);

        if(!user.isPresent()){
            throw new UserNotFoundException("User not found");
        }

        return user;
    }


    //update user
    public User updateUserById(Long id,User user) throws UserNotFoundException{

        Optional<User> optionalUser=userRepository.findById(id);
        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("user not found in db");
        }

        user.setId(id);
        return userRepository.save(user);
    }



    // find user by id
    public String deleteUserById(Long id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return "user deleted";
        }
        else{
            return "user dont exsist";
        }
    }


    //find user by username
    public Optional<User> getUserByUserName(String userName){
        return userRepository.findByUsername(userName);
    }


}
