package com.basic.app.Springboot.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;
    private String city;
}
