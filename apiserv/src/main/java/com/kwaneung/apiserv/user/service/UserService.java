package com.kwaneung.apiserv.user.service;

import com.kwaneung.apiserv.user.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String myName(String name) {
        if (name != null) {
            return "my name is " + name;
        } else {
            return "name param is null";
        }
    }

    public String myAge(Integer age) {
        if (age != null) {
            return "my age is " + age;
        } else {
            return "age param is null";
        }
    }

    public String myRole(String role) {
        if (role != null) {
            return "my role is " + role;
        } else {
            return "role param is null";
        }
    }

    public String myInfo(UserDto userDto){
        userDto.setName("test");
        return myName("name : " + userDto.getName()) + "\nage : " + myAge(userDto.getAge()) + "\nrole : " + myRole(userDto.getRole());
    }

    public String myInfoWithaddress(String address, UserDto userDto){
        return myInfo(userDto) + "\naddress : " + address;
    }
}