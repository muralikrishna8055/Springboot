package com.basic.app.Springboot.controller;

import com.basic.app.Springboot.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/userController")
    public UserDto userController(){
        return new UserDto("Murali","Krishna","Adoor");
    }


}
